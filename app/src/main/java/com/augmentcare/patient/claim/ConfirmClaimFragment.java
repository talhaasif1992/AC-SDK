package com.augmentcare.patient.claim;


import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.customviews.DependentsView;
import com.augmentcare.patient.model.createClaimsModel.CreateClaims;
import com.augmentcare.patient.network.restApi.apimodels.CreatedClaimResponse;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.TextUtils;
import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class ConfirmClaimFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks, View.OnClickListener {

    @BindView(R.id.spConsultationFor)
    Spinner spTransactionType;
    @BindView(R.id.etDateTime1)
    EditText etDateTime;
    @BindView(R.id.etAmount)
    EditText etAmount;
    @BindView(R.id.etClaimType)
    EditText etClaimType;
    @BindView(R.id.etClaimFor)
    EditText etClaimFor;
    @BindView(R.id.etDetails)
    TextView etDetails;
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
    DependentsView dep_view;

    @BindView(R.id.rlContentView)
    CardView contentFrame;


    private static final int STORAGE_PERMISSION = 322;
    private String uploadedFileURL = "";
    private int CURRENT_IMAGE_SELECTION = 0;
    private List<String> imagesPaths;
    private static ProgressDialog progressDialog;
    public static String TAG = "FileAClaimFragment";

    private String CHOOSED_DATE_TIME = "";
    private String CHOOSED_DATE_ONLY = "";
    private String CHOOSED_TIME_ONLY = "";
    private String emptyValidation = "";
    private ArrayAdapter<String> transactionTypeAdapter;
    private String[] transaction_type = {"Claim For", "Consultation", "Lab Test", "Medicine", "Other"};
    String[] transaction_type_server = {"Claim For", "consultation", "lab_test", "medicine", "other"};
    private ComfirmRecycleViewAdapterImages recycleViewAdapterImages;
    private int counter = 0;
    int clickCount = 0;
    private String amount;
    private String consultation_with;
    private String speciality;
    private String location;
    private String organization_id;
    private String details;
    private String transaction_for;
    private String claim_type;
    private String dependentName;
    private String dependentId;
    private String timeChoose;
    private String time;
    private String user_id;
    private String date;
    private String transactionType;
    private ArrayList<String> mImagesArrayList;
    CreateClaims createClaims;
    private View rootView;
    private NavController mainNav;
    private ConfirmClaimFragmentArgs args;

    public ConfirmClaimFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_claim_confirm_summary, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt() {
        loadArgs();

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Claim Confirmation");

        mainNav = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        KeyboardUtils.hideSoftInput(baseActivity);
        etDateTime.setFocusableInTouchMode(false);
        etDateTime.setFreezesText(true);
        mImagesArrayList = new ArrayList<>();
        try {
            imagesPaths = Arrays.asList(args.getImagesList());
            etAmount.setText(amount);
            etClaimType.setText(transactionType);
            etClaimFor.setText(dependentName);
            etDateTime.setText(time);
            etDetails.setText(details);
            int path = R.drawable.ic_claim_pick_image;
            for (int i = 0; i < imagesPaths.size(); i++) {
                Log.wtf("imagesPath", imagesPaths + "");
                if (!imagesPaths.get(i).equals(String.valueOf(path))) {
                    mImagesArrayList.add(imagesPaths.get(i) + "");
                }
            }
        } catch (Exception ignored) {
        }
        initImagesRecycler(mImagesArrayList);
        transactionTypeAdapter = new ArrayAdapter<String>(baseActivity, R.layout.item_spinner_dropdown_claim, transaction_type) {
            @Override
            public boolean isEnabled(int position) {
                // Disable the first item from Spinner
                // First item will be use for hint
                return position != 0;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(getResources().getColor(R.color.colorGrayDark));
                } else {
                    tv.setTextColor(getResources().getColor(R.color.colorBlueButton));
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
        ClickUtils.applySingleDebouncing(btnFileAClaim, this);

        dep_view.setClickable(false);

        dep_view.onDependentsLoaded(() -> {
            dep_view.selectDependentByID(Long.valueOf(dependentId));
        });

    }


    private void loadArgs() {
        if (getArguments() != null) {
            args = ConfirmClaimFragmentArgs.fromBundle(getArguments());
            amount = args.getAmount();
            consultation_with = args.getConsultationWith();
            speciality = args.getSpeciality();
            location = args.getLocation();
            organization_id = args.getOrganizationId() + "";
            transaction_for = args.getTransactionFor();
            claim_type = args.getClaimType();
            user_id = args.getUserId() + "";
            time = args.getTime();
            timeChoose = args.getTimeChoose();
            dependentId = args.getDependentId();
            dependentName = args.getDependentName();
            details = args.getDetails();
            date = args.getDate();
            transactionType = args.getTransactionType();
            imagesPaths = Arrays.asList(args.getImagesList());
        }
    }

    /**
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFileAClaim:
                if (emptyValidation()) {
                    //createClaimApiCall();
                    createClaimApiCallRX();
                } else {
                    Toast.makeText(baseActivity, emptyValidation, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.etDateTime1:
                pickDateDialog();
                break;
            case R.id.llBox1:
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

    private void createClaimApiCallRX() {

        String msgs = "";
        String dependentId = "";

        if (this.dependentId != null && !this.dependentId.isEmpty()) {
            dependentId = this.dependentId;
        }

        List<String> urls = new ArrayList<>();
        int path = R.drawable.ic_claim_pick_image;
        for (int i = 0; i < imagesPaths.size(); i++) {
            if (!imagesPaths.get(i).isEmpty() && !imagesPaths.get(i).equals(String.valueOf(path)))
                urls.add(imagesPaths.get(i));
        }

        getDisposer().add(
                baseActivity.RXAPI.createClaim(
                        (int) Float.parseFloat(amount), "",
                        "Nothing",
                        "",
                        date,
                        timeChoose,
                        MyApp.get().getOrganization().getId(),
                        transactionType, Integer.toString(baseActivity.userData.getUserId()), baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName(),
                        "reimbursement", urls, dependentId).subscribe(this::onCreateClaimApiCallRx, LocalUtils::processAPIError)
        );
    }

    private void onCreateClaimApiCallRx(CreatedClaimResponse createdClaimResponse) {

        mainNav.navigate(
                ConfirmClaimFragmentDirections.actionConfirmClaimFragmentToClaimSuccessFragment(
                        createdClaimResponse.getClaim().getTransactionType(),
                        dependentName
                ).setAmount(createdClaimResponse.getClaim().getAmount())
                .setClaimDetails(details)
        );
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

    private void afterUploadFile(String uploadedFileURL) {
        if (imagesPaths.size() > 0 && counter <= 4) {
            imagesPaths.set(counter, uploadedFileURL);
            counter = counter + 1;
            initImagesRecycler(imagesPaths);
        } else {
            imagesPaths.add(uploadedFileURL);
            initImagesRecycler(imagesPaths);
        }
    }

    private boolean emptyValidation() {
        String amount = etAmount.getText().toString().trim();
        String detail = etDetails.getText().toString().trim();
        int spConsultationForPos = spTransactionType.getSelectedItemPosition();
        CHOOSED_DATE_TIME = CHOOSED_DATE_TIME.trim();
        if (amount.isEmpty()) {
            emptyValidation = "Please enter amount";
            return false;
        }
        return true;
    }

    /**
     *
     */

    /**
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     *
     */
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

    /**
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        requestPermission();
    }

    /**
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    /**
     *
     */
    private void pickDateDialog() {
        Calendar now = Calendar.getInstance();
        new DatePickerDialog(
                baseActivity,
                (view, year, month, dayOfMonth) -> {
                    view.callOnClick();
                    pickTimeDialog(year, month, dayOfMonth);
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void pickTimeDialog(final int year, final int month, final int dayOfMonth) {
        Calendar now = Calendar.getInstance();
        new TimePickerDialog(baseActivity, (view, hour, minute) -> {
            view.callOnClick();
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

    /**
     * @param list
     */

    public void initImagesRecycler(List<String> list) {
        recycleViewAdapterImages = new ComfirmRecycleViewAdapterImages(baseActivity, list);
        recycleViewAdapterImages.notifyDataSetChanged();
        mImagesRecyclerView.setLayoutManager(new LinearLayoutManager(baseActivity, LinearLayoutManager.HORIZONTAL, false));
        mImagesRecyclerView.setHasFixedSize(true);
        mImagesRecyclerView.setAdapter(recycleViewAdapterImages);
    }
}