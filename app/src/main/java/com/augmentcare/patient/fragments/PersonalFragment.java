package com.augmentcare.patient.fragments;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.AddressActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import com.augmentcare.patient.network.restApi.apimodels.ProfilesInfo;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.functions.Consumer;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class PersonalFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks {

    private static final int STORAGE_PERMISSION = 322;

    @BindView(R.id.et_user_name)
    EditText mUserNameTextView;

    @BindView(R.id.et_user_email)
    EditText txtEmail;

    @BindView(R.id.relationSpinner)
    EditText txtAddress;

    @BindView(R.id.et_user_mobile)
    PhoneEditTextNew txtPhone;

    @BindView(R.id.changePhoneSwitch)
    SwitchCompat changePhoneSwitch;

    @BindView(R.id.ivProfileImageNew)
    ImageView ivProfileImage;

    @BindView(R.id.upload_picture_layoutNew)
    RelativeLayout mUploadPictureLayout;

    @BindView(R.id.upload_picture_layoutsNew)
    RelativeLayout mUploadPictureLayouts;

    @BindView(R.id.btn_update_profile)
    Button editButton;

    @BindView(R.id.btn_upload_picture)
    FloatingActionButton btnUploadPicture;

    UserDataLogin userInfo;
    NavController navController;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_personal, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMe();
    }

    private void initMe(){
        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        bindViews();
        txtPhone.setEditable(false);

        changePhoneSwitch.setOnCheckedChangeListener((buttonView, isChecked) ->{
            if(changePhoneSwitch.isChecked()){
                txtPhone.setEditable(true);
            }
            else if(!changePhoneSwitch.isChecked() && !txtPhone.getPhoneNumber().isEmpty()){
                txtPhone.setEditable(false);
            }
        });

        txtAddress.setOnClickListener(v ->{
            ActivityUtils.startActivity(AddressActivity.class);
        });

        mUploadPictureLayout.setOnClickListener(v -> {
            //     requestPermission();
        });

        ivProfileImage.setOnClickListener(v -> {
        });

        btnUploadPicture.setOnClickListener(v -> {
            requestPermission();
        });

        editButton.setOnClickListener(v -> {
            if(mUserNameTextView.getText() != null && !mUserNameTextView.getText().toString().isEmpty()) {
                String str = mUserNameTextView.getText().toString();
                String[] splittedStr = str.split("\\s+", 2);
                userInfo.setFirstName(splittedStr[0]);
                userInfo.setLastName(splittedStr[1]);
            }

            userInfo.setAddress(txtAddress.getText().toString());

            if(changePhoneSwitch.isChecked()){
                if(txtPhone.isValid()){
                    if(txtPhone.getPhoneNumber().equals(userInfo.getPhone())){
                        Toasty.info(getContext(),"This is your current Number").show();
                    }
                    else{
                        getDisposer().add(
                                baseActivity.RXAPI.getProfilesByPhone(txtPhone.getPhoneNumber(), "")
                                        .subscribe(this::onGetProfileByPhone, LocalUtils::processAPIError)
                        );
                    }
                }
                else{
                    txtPhone.setError("Please Enter a valid Mobile Number");
                }
            }
            else{
                callUpdateProfile(userInfo);
            }
        });
    }

    private void onGetProfileByPhone(ProfilesInfo profiles) {
        if (profiles != null){
            int registeredNoOfUsers = profiles.getCount();
            if (registeredNoOfUsers == 1) {
                Toasty.error(Objects.requireNonNull(getContext()), "There is already an account against this phone number",
                        Toast.LENGTH_LONG, false).show();
            }
            else if (registeredNoOfUsers > 1) {
                Toasty.error(Objects.requireNonNull(getContext()), "There are more than one account for this phone number",
                        Toast.LENGTH_LONG, false).show();
            }
            else{
                navController.navigate(EditProfileFragmentDirections.actionEditProfileFragmentToVerifyOTPPhoneFragment2().setPhone(txtPhone.getPhoneNumber()).setUserInfo(userInfo));
            }
        }
    }

    private void callUpdateProfile(UserDataLogin user){
        getDisposer().add(
                baseActivity.RXAPI.updateUserProfile(
                        new UserInfoUpdateRequest()
                                .setUserInfo(user)

                ).subscribe(userInfo ->{
                    enableFalse();
                    Toasty.success(Utils.getApp(), "Profile Updated", Toast.LENGTH_LONG, false).show();
                    if (baseActivity.userData != null){
                        PrefsHelper.setUserInfo(this.userInfo);
                    }
                    else{
                        PrefsHelper.get(baseActivity).clear();
                        if (!NavGraphUtils.getMe(navController).isLastDest(R.id.loginFragment)){
                            Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                            navController.navigate(R.id.action_global_loginFragment);
                        }
                    }
                    baseActivity.setResult(RESULT_OK);
                }, LocalUtils::processAPIError)
        );
    }

    private boolean validateEmail(){
        if (txtEmail.getText().toString().trim().isEmpty()) {
            Toasty.info(getContext(), getString(R.string.error_enter_valid_email), Toast.LENGTH_LONG, false).show();
            return false;
        }

        if (!txtEmail.getText().toString().trim().isEmpty()) {
            if ((TextUtils.validateEmail(txtEmail.getText().toString().trim()))) {
                //Toasty.info(getContext(), getString(R.string.email_phone_required), Toast.LENGTH_LONG, false).show();
            } else {
                Toasty.info(getContext(), getString(R.string.error_enter_valid_email), Toast.LENGTH_LONG, false).show();
                return false;
            }
        }
        return true;
    }


    private void bindViews() {
        userInfo = baseActivity.userData;
        getDisposer().add(
                baseActivity.RXAPI.getUserInfo((int) MyApp.get().getRole().getId())
                        .subscribe(gotUserInfo -> {
                            if (gotUserInfo.getPhone() != null)
                                userInfo.setPhone(gotUserInfo.getPhone());
                            if (gotUserInfo.getAddress() != null)
                                userInfo.setAddress(gotUserInfo.getAddress());
                            if (gotUserInfo.getPhoto() != null)
                                userInfo.setPhoto(gotUserInfo.getPhoto());
                            if (baseActivity.userData != null) {
                                PrefsHelper.setUserInfo(userInfo);
                            } else {
                                PrefsHelper.get(baseActivity).clear();
                                if (!NavGraphUtils.getMe(navController).isLastDest(R.id.loginFragment)) {
                                    Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                                    navController.navigate(R.id.action_global_loginFragment);
                                }
                            }
                        })
        );

        mUserNameTextView.setText(String.format("%s %s", baseActivity.userData.getFirstName(), baseActivity.userData.getLastName()));
        txtEmail.setText(userInfo.getEmail());
        txtAddress.setText(userInfo.getAddress());
        txtPhone.setDefaultCountry("PK");
        txtPhone.setPhoneNumber(userInfo.getPhone());

        enableFalse();

        if (userInfo.getPhoto() != null && !userInfo.getPhoto().isEmpty()) {
            Glide.with(this)
                    .load(userInfo.getPhoto())
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivProfileImage);
            mUploadPictureLayouts.setVisibility(View.VISIBLE);
            ivProfileImage.setVisibility(View.VISIBLE);
            mUploadPictureLayout.setVisibility(View.INVISIBLE);
        } else {
            mUploadPictureLayout.setVisibility(View.VISIBLE);
            ivProfileImage.setVisibility(View.INVISIBLE);
            mUploadPictureLayouts.setVisibility(View.INVISIBLE);
        }
    }

    private void enableTrue() {
        txtEmail.setEnabled(false);
    }


    private void enableFalse() {
        txtEmail.setEnabled(false);
    }

    public void setUserInfo(UserDataLogin userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(STORAGE_PERMISSION)
    private void requestPermission() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(Objects.requireNonNull(getContext()), perms)) {
            // if there is no server URL set
            EasyImage.openChooserWithGallery(this, "Choose source", 300);
        } else {
            EasyPermissions.requestPermissions(this, "We need to access Camera and Storage to save pictures", STORAGE_PERMISSION, perms);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        requestPermission();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, baseActivity, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
            }

            @Override
            public void onImagesPicked(@NonNull List<File> imagesFiles, EasyImage.ImageSource source, int type) {
                String folderPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/AugmentCare/Claims/";
                String filePath = imagesFiles.get(0).getAbsolutePath();
                byte[] imageFileBitmap = ImageUtils.compressByQuality(ImageUtils.getBitmap(filePath), 50, true);
                FileIOUtils.writeFileFromBytesByChannel(filePath, imageFileBitmap, true);
//                ImageUtils.save(imageFileBitmap, filePath, Bitmap.CompressFormat.PNG, true);

                uploadFileAPI(userInfo.getUserId(), new File(filePath));

            }
        });

        if (requestCode == Constants.REQUEST_PHONE_NUMBER) {
            userInfo.setPhone(data.getStringExtra(Constants.KEY_DATA));
        }

    }

    private void uploadFileAPI(int userId, File file) {
        getDisposer().add(
                baseActivity.RXAPI.uploadFile(userId, file)
                        .subscribe(new Consumer<Response<String>>() {
                            @Override
                            public void accept(Response<String> s) throws Exception {
                                if (s.isSuccessful()) {
                                    String uploadedFileURL = s.body();
                                    userInfo.setPhoto(uploadedFileURL);
                                    mUploadPictureLayout.setVisibility(View.INVISIBLE);
                                    mUploadPictureLayouts.setVisibility(View.VISIBLE);
                                    ivProfileImage.setVisibility(View.VISIBLE);
                                    Glide.with(PersonalFragment.this)
                                            .load(userInfo.getPhoto())
                                            .error(R.drawable.profile_placeholder)
                                            .placeholder(R.drawable.profile_placeholder)
                                            .into(ivProfileImage);
                                    PersonalFragment.this.callUpdateProfile(userInfo);
                                } else {
                                    Toasty.error(Utils.getApp(), "Unable to Upload file yet try again").show();
                                }
                            }
                        }, LocalUtils::processAPIError)
        );
    }
}
