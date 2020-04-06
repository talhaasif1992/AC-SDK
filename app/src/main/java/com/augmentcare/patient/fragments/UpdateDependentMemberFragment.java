package com.augmentcare.patient.fragments;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SwitchCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import com.augmentcare.patient.model.Loc;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class UpdateDependentMemberFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks, View.OnClickListener {
    @BindView(R.id.btn_save_information)
    Button btnSave;

    @BindView(R.id.et_user_name)
    EditText membersName;
    @BindView(R.id.relationSpinner)
    AppCompatSpinner relationSpinner;
    @BindView(R.id.et_user_email)
    EditText email;
    @BindView(R.id.et_user_mobile)
    PhoneEditTextNew phone;

    @BindView(R.id.upload_picture_layoutsNew)
    RelativeLayout mPictureSetRelativeLayout;

    @BindView(R.id.btn_upload_picture)
    FloatingActionButton btn_upload_picture;

    @BindView(R.id.ivProfileImageNew)
    CircularImageView ivdocImage;

    @BindView(R.id.tv_email)
    TextView tv_email;

    @BindView(R.id.tv_phone_number)
    TextView tv_phone_number;

    @BindView(R.id.daySpinner)
    Spinner daySpinner;
    @BindView(R.id.monthSpinner)
    Spinner monthSpinner;
    @BindView(R.id.yearSpinner)
    Spinner yearSpinner;

    @BindView(R.id.canLoginSwitch)
    SwitchCompat canLoginSwitch;

    private NavController mainNav;

//    @BindView(R.id.btn_male)
//    RadioButton btnMale;
//    @BindView(R.id.btn_female)
//    RadioButton btnFemale;

    private static final int STORAGE_PERMISSION = 322;
    private String uploadedFileURL;
    String pic;

    String fn, ln;

    String[] values = {"Mother", "Father", "Wife", "Husband", "Son", "Daughter", "Sibling"};
    String[] values1 = {"Father", "Mother", "Wife", "Husband", "Son", "Daughter", "Sibling"};
    String[] values2 = {"Wife", "Mother", "Father", "Husband", "Son", "Daughter", "Sibling"};
    String[] values3 = {"Husband", "Mother", "Father", "Wife", "Son", "Daughter", "Sibling"};
    String[] values4 = {"Son", "Mother", "Father", "Wife", "Husband", "Daughter", "Sibling"};
    String[] values5 = {"Daughter", "Mother", "Father", "Wife", "Husband", "Son", "Sibling"};
    String[] values6 = {"Sibling", "Mother", "Father", "Wife", "Husband", "Son", "Daughter"};

    private View rootView;
    private UpdateDependentMemberFragmentArgs args;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_add_dependent, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {
        loadArgs();

        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        if (args.getDependent() != null) {
            boolean canLogin = Boolean.valueOf(
                    LocalUtils.getOr(args.getDependent().getCanLogin(), false+"")
            );
            Dependent dependent = args.getDependent();

            membersName.setText(args.getDependent().getName());

            Integer relationId = args.getDependent().getRelationshipId();
            if (relationId != null && relationId == 0) {
                setSpinner(values, relationSpinner);
            } else if (relationId != null && relationId == 1) {
                setSpinner(values1, relationSpinner);
            } else if (relationId != null && relationId == 2) {
                setSpinner(values2, relationSpinner);
            } else if (relationId != null && relationId == 3) {
                setSpinner(values3, relationSpinner);
            } else if (relationId != null && relationId == 4) {
                setSpinner(values4, relationSpinner);
            } else if (relationId != null && relationId == 5) {
                setSpinner(values5, relationSpinner);
            } else if (relationId != null && relationId == 6) {
                setSpinner(values6, relationSpinner);
            } else {
                setSpinner(values, relationSpinner);
            }

            relationSpinner.setEnabled(false);

            tv_email.setVisibility(canLogin ? View.VISIBLE : View.GONE);
            tv_phone_number.setVisibility(canLogin ? View.VISIBLE : View.GONE);
            email.setVisibility(canLogin ? View.VISIBLE : View.GONE);
            phone.setVisibility(canLogin ? View.VISIBLE : View.GONE);

            if(canLogin){
                email.setText(StringUtils.null2Length0(args.getDependent().getEmail()));
                phone.setPhoneNumber(StringUtils.null2Length0(args.getDependent().getPhone()));
            } else {
                email.setText("");
                phone.setPhoneNumber("");
            }

            Glide.with(baseActivity)
                    .load(args.getDependent().getPhoto())
                    .placeholder(R.drawable.profile_placeholder)
                    .error(R.drawable.profile_placeholder)
                    .into(ivdocImage);


            canLoginSwitch.setChecked(canLogin);
            String[] dobs=new String[]{};

            if(dependent.getDob()!=null) {
                dobs = dependent.getDob().split("\\/");
            }

            String[] days = getResources().getStringArray(R.array.days_numeric_array);
            String[] months = getResources().getStringArray(R.array.months_full_names);
            String[] years = getResources().getStringArray(R.array.years_numeric_array);

            int dayPos = 0;
            int monthPos = 0;
            int yearPos = 0;

            if(dobs.length == 3) {
                for (int i = 0; i < days.length; i++) {
                    if (Integer.valueOf(dobs[0]).equals(Integer.valueOf(days[i]))) {
                        dayPos = i;
                        break;
                    }
                }
                monthPos = getMonthPosition(dobs[1]) - 1;
                for (int i = 0; i < days.length; i++) {
                    if (Integer.valueOf(dobs[2]).equals(Integer.valueOf(years[i]))){
                        yearPos = i;
                        break;
                    }
                }
            }

            daySpinner.setSelection(dayPos, true);
            monthSpinner.setSelection(monthPos, true);
            yearSpinner.setSelection(yearPos, true);
        }

        canLoginSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tv_email.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            tv_phone_number.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            email.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            phone.setVisibility(isChecked ? View.VISIBLE : View.GONE);

            if (isChecked) {
                email.setText(StringUtils.null2Length0(args.getDependent().getEmail()));
                phone.setPhoneNumber(StringUtils.null2Length0(args.getDependent().getPhone()));
            } else {
                email.setText("");
                phone.setPhoneNumber("");
            }
        });

        mPictureSetRelativeLayout.setOnClickListener(this);
        btn_upload_picture.setOnClickListener(this);

        btnSave.setOnClickListener(v -> {
            if(validate()){
                getDisposer().add(
                        baseActivity.RXAPI.getProfilesByPhone(phone.getPhoneNumber(), "").subscribe(this::OnCheckMobile, LocalUtils::processAPIError)
                );
            }
        });
    }

    private void OnCheckMobile(ProfilesInfo profilesInfo) {
        if(profilesInfo.getCount() > 0){
            Toasty.error(getContext(), "Phone number already registered with an account").show();
        }
        else{
            apiValidation();
            mainNav.navigate(UpdateDependentMemberFragmentDirections.actionUpdateDependentMemberFragmentToFragmentOTPUpdateDependent().setEmail("").setPhone(phone.getPhoneNumber()));
        }
    }

    private boolean validate(){
        String mobile = phone.getPhoneNumber();
        if (!mobile.trim().isEmpty() && PhoneNumberUtils.isGlobalPhoneNumber(mobile.trim()) && mobile.trim().length() == 13){
            phone.setError(null);
            return true;
        }
        else{
            phone.setError(getString(R.string.error_enter_valid_phone));
            return false;
        }
    }

    private void setSpinner(String[] values, Spinner spinner) {
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(baseActivity, android.R.layout.simple_spinner_item, values);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } catch (Exception ignored) {
        }
    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = UpdateDependentMemberFragmentArgs.fromBundle(getArguments());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_upload_picture:
            case R.id.upload_picture_layoutsNew:
                requestPermission();
                break;
        }
    }

    @AfterPermissionGranted(STORAGE_PERMISSION)
    private void requestPermission() {
        String[] perms = {android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};

        if (EasyPermissions.hasPermissions(baseActivity, perms)) {
            EasyImage.openChooserWithGallery(this, "Choose source", 300);
        } else {
            EasyPermissions.requestPermissions(this, "We need to access Camera and Storage to save pictures", STORAGE_PERMISSION, perms);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        requestPermission();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
    }

    private void updateDependentsApiCall(
            int depID,
            Dependent dependent
    ) {
        getDisposer().add(
                baseActivity.RXAPI.updateDependent(depID, dependent)
                        .subscribe(s -> {
                            Toasty.success(Utils.getApp(), s.getMessage()).show();
                            baseActivity.onBackPressed();
                        }, LocalUtils::processAPIError)
        );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, baseActivity, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type){}

            @Override
            public void onImagesPicked(@NotNull List<File> imagesFiles, EasyImage.ImageSource source, int type) {
                String folderPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/AugmentCare/Claims/";
                String filePath = imagesFiles.get(0).getAbsolutePath();
                byte[] imageFileBitmap = ImageUtils.compressByQuality(ImageUtils.getBitmap(filePath), 50, true);
                FileIOUtils.writeFileFromBytesByChannel(filePath, imageFileBitmap, true);
//                ImageUtils.save(imageFileBitmap, filePath, Bitmap.CompressFormat.PNG, true);

                uploadFileAPI(baseActivity.userData.getUserId(), new File(filePath));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Intent intent = new Intent(this, DependentActivity.class);
                baseActivity.finish();
                // startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void uploadFileAPI(int userId, File file) {
        getDisposer().add(
                baseActivity.RXAPI.uploadFile(userId, file)
                        .subscribe(s -> {
                            if (s.isSuccessful()) {
                                String uploadedFileURL = s.body();
                                afterUploadFile(uploadedFileURL);
                            } else {
                                Toasty.error(Utils.getApp(), "Unable to Upload file yet try again").show();
                            }
                        }, LocalUtils::processAPIError)
        );
    }

    private void afterUploadFile(String fileURL) {
        uploadedFileURL = fileURL;
        Glide.with(baseActivity)
                .load(uploadedFileURL)
                .into(ivdocImage);

        mPictureSetRelativeLayout.setVisibility(View.VISIBLE);
    }

    private void errorDialog(String message) {
        ViewUtils.showOneButtonDialog(baseActivity, "", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void firebaseEvents(String type) {
        try {
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty())
                FirebaseLogger.viewFirebaseLogEvent(type, baseActivity.userData.getId());
        } catch (Exception ignored) {
        }
    }

    private void apiValidation() {
        if(canLoginSwitch.isChecked()){
            if (!isValidEmail(email.getText().toString().trim())) {
                errorDialog("Please Enter Valid Email");
                return;
            } else if (TextUtils.isEmpty(phone.getPhoneNumber().toString().trim())) {
                errorDialog("Please enter phone number.");
                return;
            }
        }

        if (TextUtils.isEmpty(membersName.getText().toString().trim())) {
            errorDialog("Please enter dependent's name.");
        }
        else if (TextUtils.isEmpty((String) relationSpinner.getSelectedItem())){
            errorDialog("Please enter your relationship with dependent");
        }
//        else if(!btnMale.isChecked() && !btnFemale.isChecked()){
//            errorDialog("Please select the gender");
//        }
//        else if (!daySpinner.performClick()) {
//            errorDialog("Please select a daySpinner");
//        } else if (!monthSpinner.performClick()) {
//            errorDialog("Please select a month");
//        } else if (!yearSpinner.performClick()) {
//            errorDialog("Please select a yearSpinner");
//        }
        else{
            String str = membersName.getText().toString();
            if (str.contains(" ")) {
                String[] splittedStr = str.split(" ", 2);
                fn = splittedStr[0];
                ln = splittedStr[1];
            }
            else {
                fn = str;
                ln = "";
            }


            String dob = daySpinner.getSelectedItem().toString() + "/" + monthSpinner.getSelectedItem().toString() + "/" + yearSpinner.getSelectedItem().toString();

            if(args.getDependent() != null){
                Dependent selected = args.getDependent();

                pic = uploadedFileURL;

                selected.withName(fn + " " + ln)
                        .withFirstName(fn)
                        .withLastName(ln)
                        .withCanLogin(canLoginSwitch.isChecked()+"")
                        .withPhone(canLoginSwitch.isChecked() ? phone.getPhoneNumber() : "")
                        .withDob(dob);
                if (!StringUtils.isEmpty(uploadedFileURL))
                    selected.withPhoto(pic);

                updateDependentsApiCall(selected.getId(), selected);
            }
        }
    }

    public int getRelationShipID(String relationShip) {
        if (relationShip.equals("Mother")) return 0;
        if (relationShip.equals("Father")) return 1;
        if (relationShip.equals("Wife")) return 2;
        if (relationShip.equals("Husband")) return 3;
        if (relationShip.equals("Son")) return 4;
        if (relationShip.equals("Daughter")) return 5;
        if (relationShip.equals("Sibling")) return 6;
        return -1;
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public int getMonthPosition(String month){
        int whatToReturn = 0;
        switch(month){
            case "January":
                whatToReturn = 1;
                break;
            case "Febraury":
                whatToReturn = 2;
                break;
            case "March":
                whatToReturn = 3;
            break;
            case "April":
                whatToReturn = 4;
            break;
            case "May":
                whatToReturn = 5;
            break;
            case "June":
                whatToReturn = 6;
            break;
            case "July":
                whatToReturn = 7;
            break;
            case "August":
                whatToReturn = 8;
            break;
            case "September":
                whatToReturn = 9;
            break;
            case "October":
                whatToReturn = 10;
            break;
            case "November":
                whatToReturn = 11;
            break;
            case "December":
                whatToReturn = 12;
            break;
        }
        return whatToReturn;
    }

}