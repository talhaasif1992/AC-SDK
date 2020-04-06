package com.augmentcare.patient.fragments;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
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

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.PhoneEditTextNew;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
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

public class AddDependentMemberFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks, View.OnClickListener{

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

    @BindView(R.id.tv_email)
    TextView tv_email;

    @BindView(R.id.tv_phone_number)
    TextView tv_phone_number;

    @BindView(R.id.upload_picture_layoutsNew)
    RelativeLayout mPictureSetRelativeLayout;

    @BindView(R.id.btn_upload_picture)
    FloatingActionButton btn_upload_picture;

    @BindView(R.id.ivProfileImageNew)
    CircularImageView ivdocImage;

    @BindView(R.id.daySpinner)
    Spinner daySpinner;
    @BindView(R.id.monthSpinner)
    Spinner monthSpinner;
    @BindView(R.id.yearSpinner)
    Spinner yearSpinner;


    @BindView(R.id.canLoginSwitch)
    SwitchCompat canLoginSwitch;

//    @BindView(R.id.btn_male)
//    RadioButton btnMale;
//    @BindView(R.id.btn_female)
//    RadioButton btnFemale;

    private static final int STORAGE_PERMISSION = 322;
    private String uploadedFileURL;
    String pic;

    String fn, ln;
    String monthNumber;

    String[] values = {"Mother", "Father", "Wife", "Husband", "Son", "Daughter", "Sibling"};
    String[] values1 = {"Father", "Mother", "Wife", "Husband", "Son", "Daughter", "Sibling"};
    String[] values2 = {"Wife", "Mother", "Father", "Husband", "Son", "Daughter", "Sibling"};
    String[] values3 = {"Husband", "Mother", "Father", "Wife", "Son", "Daughter", "Sibling"};
    String[] values4 = {"Son", "Mother", "Father", "Wife", "Husband", "Daughter", "Sibling"};
    String[] values5 = {"Daughter", "Mother", "Father", "Wife", "Husband", "Son", "Sibling"};
    String[] values6 = {"Sibling", "Mother", "Father", "Wife", "Husband", "Son", "Daughter"};

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_add_dependent, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, rootView);

        btnSave.setOnClickListener(this);
        mPictureSetRelativeLayout.setOnClickListener(this);
        btn_upload_picture.setOnClickListener(this);

        canLoginSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            email.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            phone.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        setSpinner(values, relationSpinner);

        Glide.with(baseActivity)
                .load(R.drawable.profile_placeholder)
                .into(ivdocImage);

        canLoginSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            tv_email.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            tv_phone_number.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            email.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            phone.setVisibility(isChecked ? View.VISIBLE : View.GONE);

        });

        tv_email.setVisibility(canLoginSwitch.isChecked() ? View.VISIBLE : View.GONE);
        tv_phone_number.setVisibility(canLoginSwitch.isChecked() ? View.VISIBLE : View.GONE);
        email.setVisibility(canLoginSwitch.isChecked() ? View.VISIBLE : View.GONE);
        phone.setVisibility(canLoginSwitch.isChecked() ? View.VISIBLE : View.GONE);

        email.setEnabled(true);

    }

    private void setSpinner(String[] values, Spinner spinner) {
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(baseActivity, android.R.layout.simple_spinner_item, values);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save_information:
                try {
                    apiValidation();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    errorDialog("Please select dependent.");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
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

    private void addDependentsApiCall(Dependent dependent) {
        getDisposer().add(
                baseActivity.RXAPI.addDependent(dependent)
                        .subscribe(s -> {
                            Toasty.success(Utils.getApp(), s.getMessage()).show();
                            baseActivity.onBackPressed();
                        }, LocalUtils::processAPIError)
        );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, baseActivity, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
            }

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
        if (canLoginSwitch.isChecked()) {
            if (!isValidEmail(email.getText().toString().trim())) {
                errorDialog("Please Enter Valid Email");
                return;
            } else if (TextUtils.isEmpty(phone.getPhoneNumber().trim())) {
                errorDialog("Please enter phone number.");
                return;
            }
        }

        if (TextUtils.isEmpty(membersName.getText().toString().trim())) {
            errorDialog("Please enter dependent's name.");
        } else if (StringUtils.isEmpty((String) relationSpinner.getSelectedItem())) {
            errorDialog("Please enter your relationship with dependent");
        }
//        else if(!btnMale.isChecked() && !btnFemale.isChecked()){
//            errorDialog("Please select the gender");
//        }
        else {
            String str = membersName.getText().toString();
            if (str.contains(" ")) {
                String[] splittedStr = str.split(" ", 2);
                fn = splittedStr[0];
                ln = splittedStr[1];
            } else {
                fn = str;
                ln = "";
            }

            switch (monthSpinner.getSelectedItem().toString()) {
                case "January":
                    monthNumber = "01";
                    break;
                case "Febraury":
                    monthNumber = "02";
                    break;
                case "March":
                    monthNumber = "03";
                    break;
                case "April":
                    monthNumber = "04";
                    break;
                case "May":
                    monthNumber = "05";
                    break;
                case "June":
                    monthNumber = "06";
                    break;
                case "July":
                    monthNumber = "07";
                    break;
                case "August":
                    monthNumber = "08";
                    break;
                case "September":
                    monthNumber = "09";
                    break;
                case "October":
                    monthNumber = "10";
                    break;
                case "November":
                    monthNumber = "11";
                    break;
                case "December":
                    monthNumber = "12";
                    break;
            }
            String dob = daySpinner.getSelectedItem().toString() + "/" + monthNumber + "/" + yearSpinner.getSelectedItem().toString();

//            if (args.getDependent() != null) {
            pic = uploadedFileURL;

            Dependent selected = new Dependent()
                    .withName(fn + " " + ln)
                    .withFirstName(fn)
                    .withLastName(ln)
                    .withCanLogin(canLoginSwitch.isChecked()+"")
                    .withEmail(canLoginSwitch.isChecked() ? email.getText().toString() : "")
                    .withPhone(canLoginSwitch.isChecked() ? phone.getPhoneNumber() : "")
                    .withUserUid(baseActivity.userData.getUid())
                    .withRelationWithPrimary(((String) relationSpinner.getSelectedItem()).toLowerCase())
                    .withRelationshipId(getRelationShipID((String) relationSpinner.getSelectedItem()))
                    .withDependentType(getRelationShipID((String) relationSpinner.getSelectedItem())+"")
                    .withDob(dob);

            if(MyApp.get().getOrganization() != null){
                selected.withOrganizationId(MyApp.get().getOrganization().getId());
            }

            if (!StringUtils.isEmpty(uploadedFileURL))
                selected.withPhoto(pic);
//            }
            addDependentsApiCall(selected);
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
}