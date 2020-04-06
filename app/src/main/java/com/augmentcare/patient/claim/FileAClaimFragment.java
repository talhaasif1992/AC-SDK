package com.augmentcare.patient.claim;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.ClaimInterface;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.DependentsView;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class FileAClaimFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks, View.OnClickListener, ClaimInterface{

    @BindView(R.id.tilClaimAmount)
    TextInputLayout tilClaimAmount;

    @BindView(R.id.spConsultationFor)
    Spinner spTransactionType;

    @BindView(R.id.etDateTime1)
    EditText etDateTime;

    @BindView(R.id.etAmount)
    EditText etAmount;

    @BindView(R.id.etDetails)
    EditText etDetails;

    @BindView(R.id.llBox1)
    RelativeLayout llBox1;

    @BindView(R.id.llBox2)
    RelativeLayout llBox2;

    @BindView(R.id.llBox3)
    RelativeLayout llBox3;

    @BindView(R.id.llBox4)
    RelativeLayout llBox4;

    @BindView(R.id.llBox5)
    RelativeLayout llBox5;

    @BindView(R.id.btnFileAClaim)
    RelativeLayout btnFileAClaim;

    @BindView(R.id.ivImage1)
    ImageView ivImage1;

    @BindView(R.id.ivImage2)
    ImageView ivImage2;

    @BindView(R.id.ivImage3)
    ImageView ivImage3;

    @BindView(R.id.ivImage4)
    ImageView ivImage4;

    @BindView(R.id.ivImage5)
    ImageView ivImage5;

    @BindView(R.id.recyclerViewImages)
    RecyclerView mImagesRecyclerView;

    @BindView(R.id.dep_view)
    DependentsView dependentsView;

    private static final int STORAGE_PERMISSION = 322;
    int CURRENT_IMAGE_SELECTION = 0;
    private ArrayList<String> imagesPaths = new ArrayList<>();
    public static String TAG = "FileAClaimFragment";

    private String CHOOSED_DATE_TIME = "", CHOOSED_DATE_ONLY = "", CHOOSED_TIME_ONLY = "", emptyValidation = "";
    private ArrayAdapter<String> transactionTypeAdapter;
    private String[] transaction_type = {"Claim Type", "Consultation", "Lab Test", "Medicine", "Other"};
    private String[] transaction_type_server = {"Claim Type", "consultation", "lab_test", "medicine", "other"};
    private RecycleViewAdapterImages recycleViewAdapterImages;
    private List<String> multiImagesList = new ArrayList<>();;
    private int counter = 0;
    private String dependentName = "", dependentId = "";
    private View rootView;

    private NavController mainNav;

    public FileAClaimFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_file_a_claim_new, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initIt();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    private void initIt(){
        ((HomeScreenActivity)baseActivity).setToolbarTitle("File A Claim");
        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        etDateTime.setFocusableInTouchMode(false);
        etDateTime.setFreezesText(true);
        int path = R.drawable.ic_claim_pick_image;

        if(imagesPaths.size() <= 5) {
            for (int i = 0; i < 5; i++){
                    imagesPaths.add(String.valueOf(path));
            }
        }
        initImagesRecycler(imagesPaths);

        transactionTypeAdapter = new ArrayAdapter<String>(baseActivity, R.layout.item_spinner_dropdown_claim, transaction_type) {
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }

            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;

                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.parseColor("#848484"));
                } else {
                    tv.setTextColor(Color.parseColor("#034963"));
                }
                return view;
            }
        };

        spTransactionType.setAdapter(transactionTypeAdapter);

        etDateTime.setOnClickListener(this);
        llBox1.setOnClickListener(this);
        llBox2.setOnClickListener(this);
        llBox3.setOnClickListener(this);
        llBox4.setOnClickListener(this);
        llBox5.setOnClickListener(this);
        btnFileAClaim.setOnClickListener(this);

        dependentsView.getSelectedDependent(v -> {
            dependentId = v.getId()+"";
            dependentName = v.getName();
        });

        dependentsView.selectDependentByName(
                baseActivity.userData.getFirstName()+ " " +
                        baseActivity.userData.getLastName()
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFileAClaim:
                getDependent();
                if(emptyValidation()){
                    mainNav.navigate(
                            FileAClaimFragmentDirections.actionFileAClaimFragmentToConfirmClaimFragment(
                                    "",
                                    "",
                                    etDateTime.getText().toString(),
                                    CHOOSED_TIME_ONLY,
                                    CHOOSED_DATE_ONLY,
                                    transaction_type_server[spTransactionType.getSelectedItemPosition()],
                                    dependentName,
                                    dependentId,
                                    dependentName,
                                    baseActivity.userData.getUserId(),
                                    imagesPaths.toArray(new String[0]),
                                    etDetails.getText().toString()
                            ).setAmount(etAmount.getText().toString())
                            .setOrganizationId(MyApp.get().getOrganization().getId())
                    );
                } else {
                    Toast.makeText(Utils.getApp(), emptyValidation, Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.etDateTime1:
                pickDateDialog();
                break;

            case R.id.llBox1:
                uploadClaimEvent("upload_claim");
                CURRENT_IMAGE_SELECTION = 0;
                requestPermission();
                break;

            case R.id.llBox2:
                CURRENT_IMAGE_SELECTION = 1;
                requestPermission();
                break;

            case R.id.llBox3:
                CURRENT_IMAGE_SELECTION = 2;
                requestPermission();
                break;

            case R.id.llBox4:
                CURRENT_IMAGE_SELECTION = 3;
                requestPermission();
                break;

            case R.id.llBox5:
                CURRENT_IMAGE_SELECTION = 4;
                requestPermission();
                break;
        }
    }


    @Override
    public void dismissDialog() {

    }

    @Override
    public void deleteImage() {
        if (counter > 0) {
            counter = counter - 1;
        }
    }

    private void afterUploadFile(String fileURL){
        try {
            int path = R.drawable.ic_claim_pick_image;
            if (imagesPaths.get(counter) != null && !imagesPaths.get(counter).trim().isEmpty() && counter <= 4 && imagesPaths.size() <= 5) {
                if (imagesPaths.get(counter).trim().equals(String.valueOf(path))) {
                    imagesPaths.set(counter, fileURL);
                    counter = counter + 1;
                    initImagesRecycler(imagesPaths);
                } else if (!imagesPaths.get(counter + 1).trim().equals(String.valueOf(path))) {
                    imagesPaths.add(fileURL);
                    initImagesRecycler(imagesPaths);
                    counter = counter + 1;
                }
            } else if (counter <= 4 && imagesPaths.size() <= 5 && !imagesPaths.get(counter).trim().equals(String.valueOf(path))) {
                imagesPaths.add(fileURL);
                initImagesRecycler(imagesPaths);
                counter = counter + 1;
            } else {
                imagesPaths.add(fileURL);
                initImagesRecycler(imagesPaths);
                counter = counter + 1;
            }
            uploadClaimEvent("upload_claim_success");
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
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
                byte[] imageFileBitmap = ImageUtils.compressByQuality(ImageUtils.getBitmap(filePath), 50,true);
                FileIOUtils.writeFileFromBytesByChannel(filePath,imageFileBitmap,true);
//                ImageUtils.save(imageFileBitmap, filePath, Bitmap.CompressFormat.PNG, true);

                uploadFileAPI(baseActivity.userData.getUserId(), new File(filePath));
            }
        });

    }
    private void getDependent(){
        if(dependentId.equals("")){
            dependentId = PrefsHelper.getUserInfo().getId();
        }
        if(dependentName.equals("")){
            dependentName = PrefsHelper.getUserInfo().getFirstName() + " " + PrefsHelper.getUserInfo().getLastName();
        }
    }
    private boolean emptyValidation() {
        String amount = etAmount.getText().toString().trim();
        String claimFor = dependentName;
        String details = etDetails.getText().toString();
        int spConsultationForPos = spTransactionType.getSelectedItemPosition();
        int path = R.drawable.ic_claim_pick_image;
        CHOOSED_DATE_TIME = CHOOSED_DATE_TIME.trim();
        if (amount.isEmpty()) {
            emptyValidation = "Please enter amount";
            return false;
        } else if (spConsultationForPos == 0) {
            emptyValidation = "Please choose claim Type";
            return false;
        }
        else if(details.isEmpty()){
            emptyValidation = "Please enter the details for claim";
            return false;
        }
        else if (claimFor.isEmpty()) {
            emptyValidation = "Please choose claim for";
            return false;
        } else if (CHOOSED_DATE_TIME.isEmpty()) {
            emptyValidation = "Please choose date and time";
            return false;
        } else if (imagesPaths.size() == 0 || imagesPaths.get(0).equals(String.valueOf(path))) {
            emptyValidation = "Attaching picture is mandatory";
            return false;
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(STORAGE_PERMISSION)
    private void requestPermission() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(baseActivity, perms)) {
            // if there is no server URL set
            EasyImage.openChooserWithGallery(this, "Choose source", 300);

        } else {
            EasyPermissions.requestPermissions(this, "We need to access Camera and Storage to save pictures", STORAGE_PERMISSION, perms);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
//        EasyImage.openChooserWithGallery(this, "Choose source", 300);
        requestPermission();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {}

    private void pickDateDialog() {
        Calendar now = Calendar.getInstance();
        new DatePickerDialog(baseActivity, (view, year, month, dayOfMonth) -> {
            view.callOnClick();
            pickTimeDialog(year, month, dayOfMonth);
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void pickTimeDialog(final int year, final int month, final int dayOfMonth) {
        Calendar now = Calendar.getInstance();
        new TimePickerDialog(baseActivity, (view, hour, minute) -> {
            view.callOnClick();
            // 2018-08-22T05:53:00.000Z
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth, hour, minute, 0);
            CHOOSED_DATE_TIME = TextUtils.getDateTimeString(calendar.getTime());
            CHOOSED_DATE_ONLY = TextUtils.formatDOBWithDashFileAClaim(calendar.getTime());
            CHOOSED_TIME_ONLY = TextUtils.formatTimeFileAClaim(calendar.getTime());
            etDateTime.setText(MessageFormat.format("{0} {1}", TextUtils.getDayOfWeek(calendar.getTime().getDay()), TextUtils.formatDateAndTimeForFileAClaim(calendar.getTime())));
        },
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
        ).show();
    }

    private void uploadFileAPI(int userId, File file) {
        getDisposer().add(
                baseActivity.RXAPI.uploadFile(userId,file)
                        .subscribe(s -> {
                            if(s.isSuccessful()){
                                String uploadedFileURL = s.body();
                                afterUploadFile(uploadedFileURL);
                            }else{
                                Toasty.error(Utils.getApp(),"Unable to Upload file yet try again").show();
                            }
                        }, LocalUtils::processAPIError)
        );
    }

    public void initImagesRecycler(List<String> list) {
        recycleViewAdapterImages = new RecycleViewAdapterImages(baseActivity, list,this);
        recycleViewAdapterImages.notifyDataSetChanged();
        mImagesRecyclerView.setLayoutManager(new LinearLayoutManager(baseActivity, LinearLayoutManager.HORIZONTAL, false));
        mImagesRecyclerView.setHasFixedSize(true);
        mImagesRecyclerView.setAdapter(recycleViewAdapterImages);
    }

    private void uploadClaimEvent(String eventType){
        try{
            if (baseActivity.userData.getId() != null && !baseActivity.userData.getId().isEmpty())
                FirebaseLogger.viewFirebaseLogEvent(eventType, baseActivity.userData.getId());
        }
        catch(Exception ignored){}
    }
}
