package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FacebookLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class SignupEmailFragment extends BaseFragment{

    private static final String TAG = "SignupEmailFragment";

    @BindView(R.id.tvEmailMobile)
    TextView tvEmailMobile;

    @BindView(R.id.tv_next_step_tell_us_about_your_new_mobile_number)
    TextView tvNextStep;

    @BindView(R.id.etxtEmail)
    AppCompatEditText etxtEmail;

//    @BindView(R.id.layoutPhoneInput)
//    PhoneEditText layoutPhoneInput;

    @BindView(R.id.pet_Phone)
    PhoneEditTextNew pet_Phone;

    @BindView(R.id.btnNext)
    View btnNext;

    @BindView(R.id.txtName)
    TextView txtName;

    @BindView(R.id.tv_already_have_an_account)
    TextView alreadyHaveAccountTV;

    private boolean isGoogleSignUp = false;
    private SignupEmailFragmentArgs args;

    private NavController mainNav;

    public SignupEmailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup_email, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {
        loadArgs();

        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        if(args.getFromSignupFlow()){
            etxtEmail.setEnabled(true);
            tvEmailMobile.setText("Email & Mobile");
            tvNextStep.setText("Next step is to tell us about your\nEmail and Mobile Number");
        }
        else{
            etxtEmail.setEnabled(false);
            tvEmailMobile.setText("Verify Mobile");
            tvNextStep.setText("Next step is to tell us about your\nMobile Number");
        }

        pet_Phone.setTextColor(R.color.colorSecondary);
        pet_Phone.setHint(R.string.mobile_number);
        pet_Phone.setDefaultCountry("PK");
        String email = PrefsHelper.get(baseActivity).getString(Constants.KEY_EMAIL_GOOGLE_SIGN_IN, "");
        if (!email.isEmpty()) {
            etxtEmail.setText(email);
            isGoogleSignUp = true;
        } else {
            isGoogleSignUp = false;
        }

        btnNext.setOnClickListener(view -> {
            if (validate()){
                if(args.getFromSignupFlow()){
                    getDisposer().add(
                            baseActivity.RXAPI.getProfilesByPhone(pet_Phone.getPhoneNumber(),etxtEmail.getText().toString()).subscribe(this::OnCheckNumberAndEmail, LocalUtils::processAPIError)
                    );
                }
                else if(mainNav != null){
                    getDisposer().add(
                            baseActivity.RXAPI.getProfilesByPhone(pet_Phone.getPhoneNumber(),etxtEmail.getText().toString()).subscribe(this::OnCheckNumber, LocalUtils::processAPIError)
                    );
                }

                FacebookLogger.viewControllerLogEvent(
                        "register",
                        "emailID_and_phone_number",
                        "ViewController",
                        "0",
                        ""
                );
            }
            else {

            }
        });

        alreadyHaveAccountTV.setOnClickListener(v -> {
            mainNav.setGraph(R.navigation.main_navigation);
           mainNav.navigate(R.id.action_global_loginFragment);
        });
    }

    private void OnCheckNumberAndEmail(ProfilesInfo profiles){
        if(profiles.isEmail_exists() && profiles.getCount() > 0){
            Toasty.error(getContext(), "Sorry! Phone number and Email already registered").show();
        }
        else if(profiles.isEmail_exists()){
            Toasty.error(getContext(), "Email already registered with an account").show();
        }
        else if(profiles.getCount() > 0){
            Toasty.error(getContext(), "Phone number already registered with an account").show();
        }
        else{
            mainNav.navigate(
                    SignupEmailFragmentDirections
                            .actionSignupEmailFragmentToSignupPasswordFragment(
                                    StringUtils.null2Length0(pet_Phone.getPhoneNumber()),
                                    StringUtils.null2Length0(etxtEmail.getText().toString()),
                                    StringUtils.null2Length0(args.getFName()),
                                    StringUtils.null2Length0(args.getLName())
                            ).setIsGoogleSignUp(isGoogleSignUp)

            );
        }
    }

    private void OnCheckNumber(ProfilesInfo profiles){
        if(profiles.getCount() > 0){
            Toasty.error(getContext(), "Phone number already registered with an account").show();
        }
        else{
            OTPFragmentArgs passingVals = new OTPFragmentArgs.Builder(
                    null,
                    StringUtils.null2Length0(etxtEmail.getText().toString()),
                    StringUtils.null2Length0(pet_Phone.getPhoneNumber())
            ).setFromSignUpFlow(args.getFromSignupFlow()).build();
            mainNav.navigate(R.id.action_signupEmailFragment2_to_OTPFragment2, passingVals.toBundle());
        }
    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = SignupEmailFragmentArgs.fromBundle(getArguments());

            if (args.getFromSignupFlow()) {
                txtName.setText(MessageFormat.format("{0} {1} ", args.getFName(), args.getLName()));
            } else {
                if (args.getEmail() != null) {
                    etxtEmail.setText(args.getEmail());
                }
                if (args.getPhone() != null) {
                    pet_Phone.setPhoneNumber(args.getPhone());
                    btnNext.performClick();
                }
                txtName.setText("");
            }

        }
    }

    private boolean validate(){
        String phone = pet_Phone.getPhoneNumber();
        if (!phone.trim().isEmpty() && PhoneNumberUtils.isGlobalPhoneNumber(phone.trim()) && phone.trim().length() == 13){
            pet_Phone.setError(null);
            return true;
        }
        else{
            pet_Phone.setError(getString(R.string.error_enter_valid_phone));
            return false;
        }
    }
}