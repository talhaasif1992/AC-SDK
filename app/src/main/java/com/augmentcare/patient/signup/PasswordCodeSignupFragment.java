package com.augmentcare.patient.signup;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.blankj.utilcode.util.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import se.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class PasswordCodeSignupFragment extends BaseFragment{

    private NavController employeeSignUpNav;

    private PasswordCodeSignupFragmentArgs args;

    private boolean showPassword = true , showConfirmPassword=true;

    public PasswordCodeSignupFragment(){}

    @BindView(R.id.etxtPassword)
    AppCompatEditText etxtPassword;
    @BindView(R.id.etxtConfirmPassword)
    AppCompatEditText etxtConfirmPassword;
    @BindView(R.id.btnNext)
    View btnNext;
    @BindView(R.id.tvUserName)
    TextView tvUserName;
    @BindView(R.id.passwordInputMeter)
    PasswordStrengthMeter meter;
    // @BindView(R.id.txtTermsAndConditions)
    // TextView txtTermsAndConditions;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password_code_signup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }
    private void initMe(){
        loadArgs();
        setNames(args.getUserLogin().getUserData().getFirstName());
        employeeSignUpNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        etxtPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;
            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (etxtPassword.getRight() - etxtPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showPassword){
                        etxtPassword.setTransformationMethod(null);
                        //etxtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                        Drawable img = etxtPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        etxtPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = false;
                    }
                    else{
                        etxtPassword.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = etxtPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        etxtPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });
        etxtConfirmPassword.setOnTouchListener((v, event) -> {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;
            if(event.getAction() == MotionEvent.ACTION_UP){
                if(event.getRawX() >= (etxtConfirmPassword.getRight() - etxtConfirmPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    if(showConfirmPassword){
                        etxtConfirmPassword.setTransformationMethod(null);
                        Drawable img = etxtConfirmPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_hide);
                        etxtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = false;
                    }
                    else{
                        etxtConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());
                        Drawable img = etxtConfirmPassword.getContext().getResources().getDrawable(R.drawable.ic_eye_show);
                        etxtConfirmPassword.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                        showConfirmPassword = true;
                    }
                    return true;
                }
            }
            return false;
        });
        etxtPassword.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus){
                meter.setEditText(etxtPassword);
                meter.setVisibility(View.VISIBLE);
            }
            else{
                meter.setVisibility(View.INVISIBLE);
            }
        });
        btnNext.setOnClickListener(view1 -> {
            if (validate() && etxtPassword.getText() != null) {
                setEmployeePasswordAPI(args.getUserLogin().getEmail(), etxtPassword.getText().toString(), args.getEmployeeCode());
            }
            GenApiLogger.fireRegistrationPassword();
        });
       /* txtTermsAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(baseActivity, TermAndConditionActivity.class);
                baseActivity.startActivity(intent);
            }
        }); */
    }
    private void loadArgs() {
        if (getArguments() != null) {
            args = PasswordCodeSignupFragmentArgs.fromBundle(getArguments());
        }
    }
    private boolean validate() {
        String password = etxtPassword.getText().toString().trim();
        String rePassword = etxtConfirmPassword.getText().toString().trim();
        if (password.isEmpty() || rePassword.isEmpty()) {
            etxtConfirmPassword.setError("Please enter password");
            return false;
        } else if (password.length() < 8) {
            etxtPassword.setError("Password length must be at least 8 characters");
            return false;
        } else if (rePassword.length() < 8) {
            etxtConfirmPassword.setError("Password length must be at least 8 characters");
            return false;
        } else if (!password.equals(rePassword)) {
            etxtConfirmPassword.setError("Should be same as password");
            etxtConfirmPassword.setText("");
            return false;
        }
        return true;
    }
    private void setNames(String fName) {
        String dsc = "Welcome " + fName + ", please set your password";
        tvUserName.setText(dsc);
    }
    private void setEmployeePasswordAPI(String email, String password, String employeeCode) {
        getDisposer().add(
                baseActivity.RXAPI.setEmployeeSignUpPassword(email, password, employeeCode)
                        .subscribe(b -> {
                            onSignUpPassResponse(email,password);
                        }, LocalUtils::processAPIError)
        );
    }
    private void onSignUpPassResponse(String email, String password) {
        //0.EmailCodeSignUpFragment
        //1. PasswordCodeSignupFragment
        //2. OTPCodeSignupFragment
        //3. ThankYouCodeSignUpFragment
        UserDataLogin userDataLogin = args.getUserLogin().getUserData();
        String phone = userDataLogin.getPhone();
        resendOTP_API(email, phone,() -> {
            employeeSignUpNav.navigate(
                    PasswordCodeSignupFragmentDirections.actionPasswordCodeSignupFragmentToOTPCodeSignupFragment(
                            password,
                            phone,
                            email
                    )
            );
        });
        GenApiLogger.fireSetPasswordCorporate();
        GenApiLogger.fireCompleterRegistrationEmployeeCodeEvent(userDataLogin);
    }
    private void resendOTP_API(String email, String phone,Runnable done) {
        getDisposer().add(
                baseActivity.RXAPI.resendOTP(email, phone)
                        .subscribe(sent -> {
                            if (sent) {
                                Toasty.info(Utils.getApp(), R.string.code_sent_please_wait, Toast.LENGTH_LONG, false).show();
                            }
                            done.run();
                        }, LocalUtils::processAPIError)
        );
    }
}