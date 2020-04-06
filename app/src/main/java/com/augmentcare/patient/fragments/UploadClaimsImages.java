package com.augmentcare.patient.fragments;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.UploadImagesAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.model.UploadImageModel;
import com.augmentcare.patient.network.restApi.apimodels.ClaimDetail;
import com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel.ClaimDetailsModel;
import com.augmentcare.patient.network.restApi.apimodels.ErrorResponse;
import com.augmentcare.patient.network.volleyApi.RequestFactory;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class UploadClaimsImages extends BaseFragment implements View.OnClickListener, EasyPermissions.PermissionCallbacks{

    private View rootView;

    @BindView(R.id.uploaded_images_recyclerview)
    RecyclerView mUploadedImagesRecyclerView;
    UploadImagesAdapter uploadImagesAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ClaimDetailsModel claimDetail;
    private static final int STORAGE_PERMISSION = 322;
    private ProgressDialog dialogeUpdateProfilePictur;
    private String uploadedFileURL;
    UploadImageModel uploadImageModel;

    public UploadClaimsImages(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.activity_uploaded_claims, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initMe();
    }

    public void initMe(){
        ((HomeScreenActivity)baseActivity).setToolbarTitle("Uploaded Files");
        if(getArguments()!=null){
            Bundle b = getArguments();
            claimDetail = b.getParcelable("cartDetails");
            if(claimDetail!= null){
                mUploadedImagesRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                uploadImagesAdapter = new UploadImagesAdapter(claimDetail.getData().getUploadedFiles(), getContext());
                mLayoutManager = new LinearLayoutManager(getContext());
                mUploadedImagesRecyclerView.setLayoutManager(mLayoutManager);
                mUploadedImagesRecyclerView.setAdapter(uploadImagesAdapter);
            }
            else{
                Toasty.error(getContext(), "Images Not Loaded Yet").show();
            }
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                safeNavigateTo(navController -> {
                    navController.popBackStack(R.id.dashboardFragment, false);
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @AfterPermissionGranted(STORAGE_PERMISSION)
    private void requestPermission() {
        String[] perms = {android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(getContext(), perms)){
            EasyImage.openChooserWithGallery(this, "Choose source", 300);
        } else {
            EasyPermissions.requestPermissions(this, "We need to access Camera and Storage to save pictures", STORAGE_PERMISSION, perms);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        EasyImage.openChooserWithGallery(this, "Choose source", 300);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, baseActivity, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
            }

            @Override
            public void onImagesPicked(List<File> imagesFiles, EasyImage.ImageSource source, int type) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("path", imagesFiles.get(0).getAbsolutePath());
                jsonObject.addProperty("id", PrefsHelper.getUserInfo().getUserId());
                new UploadFileTask().execute(imagesFiles.get(0).getAbsolutePath(), String.valueOf(PrefsHelper.getUserInfo().getUserId()));
            }
        });
    }

    public class UploadFileTask extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialogeUpdateProfilePictur = ProgressDialog.show(getContext(), "", "Updating image...", true);
            dialogeUpdateProfilePictur.setCancelable(false);
            dialogeUpdateProfilePictur.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String serverResponse = "";
            String fileName = strings[0]; // source file
            HttpURLConnection conn = null;
            DataOutputStream dos = null;
            String lineEnd = "\r\n";
            String twoHyphens = "--";
            String boundary = "*****";
            int bytesRead, bytesAvailable, bufferSize;
            byte[] buffer;
            int maxBufferSize = 1 * 1024 * 1024;
            File sourceFile = new File(fileName);
            if (!sourceFile.isFile()) {
            } else {
                try {
                    // open a URL connection to the Servlet
                    FileInputStream fileInputStream = new FileInputStream(sourceFile);
                    URL url = new URL(BuildConfig.SOCKET_URL + RequestFactory.UPLOAD_PIC + strings[1]);
                    // Open a HTTP  connection to  the URL
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true); // Allow Inputs
                    conn.setDoOutput(true); // Allow Outputs
                    conn.setUseCaches(false); // Don't use a Cached Copy
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Connection", "Keep-Alive");
                    conn.setRequestProperty("ENCTYPE", "multipart/form-data");
                    conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                    conn.setRequestProperty("uploaded_file", fileName);
                    dos = new DataOutputStream(conn.getOutputStream());
                    dos.writeBytes(twoHyphens + boundary + lineEnd);
                    dos.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + fileName + "\"" + lineEnd);
                    dos.writeBytes(lineEnd);
                    // create a buffer of  maximum size
                    bytesAvailable = fileInputStream.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    buffer = new byte[bufferSize];
                    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                    while (bytesRead > 0) {
                        dos.write(buffer, 0, bufferSize);
                        bytesAvailable = fileInputStream.available();
                        bufferSize = Math.min(bytesAvailable, maxBufferSize);
                        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                    }
                    // send multipart form data necesssary after file data...
                    dos.writeBytes(lineEnd);
                    dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
                    // Responses from the server (code and message)
                    int code = conn.getResponseCode();
                    serverResponse = conn.getResponseMessage();
                    try {
                        StringBuilder builder = new StringBuilder();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String output;
                        while ((output = reader.readLine()) != null) {
                            builder.append(output);
                        }
                        if (builder != null) {
                            JsonObject object = new JsonObject();
                            object.addProperty("code", code);
                            object.addProperty("data", builder.toString());
                            serverResponse = object.toString();
                        }
                    } catch (Exception ignored) {
                    }
                    //close the streams //
                    fileInputStream.close();
                    dos.flush();
                    dos.close();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    JsonObject object = new JsonObject();
                    object.addProperty("code", -1);
                    object.addProperty("data", "Unknown Error");
                    serverResponse = object.toString();
                }
            }
            return serverResponse;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JsonObject object = GsonUtils.getGson().fromJson(s, JsonObject.class);
                if (object.get("code").getAsInt() == HttpURLConnection.HTTP_OK) {
                    uploadedFileURL = object.get("data").getAsString();
                    uploadImageModel = new UploadImageModel();
                }
                List<String> urls = new ArrayList<>();
                urls.add(uploadedFileURL);

                getDisposer().add(
                        baseActivity.RXAPI.getClaimByUser(Integer.parseInt(claimDetail.getData().getClaim().getClaimUid()) , urls)
                                .subscribe(this::getUploadClaimsImage, LocalUtils::processAPIError)
                );

//                JsonObject jsonObject = new JsonObject();
//                jsonObject.addProperty("id", claimDetail.getData().getClaim().getClaimUid());
//                jsonObject.add("uploaded_files", urls);
//                baseActivity.VOLLEYAPI.addRequest(baseActivity, VolleyAPI.TYPE_UPLOAD_CLAIMS_IMAGE , jsonObject , this);
            }
            catch (Exception ignored){}
        }

        private void getUploadClaimsImage(ErrorResponse errorResponse) {
            if(errorResponse.isSuccess()){
                Toasty.success(baseActivity, "Profile Updated");
                claimDetail.getData().getUploadedFiles().add(uploadedFileURL);
                mUploadedImagesRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                uploadImagesAdapter = new UploadImagesAdapter(claimDetail.getData().getUploadedFiles(), getContext());
                mLayoutManager = new LinearLayoutManager(getContext());
                mUploadedImagesRecyclerView.setLayoutManager(mLayoutManager);
                mUploadedImagesRecyclerView.setAdapter(uploadImagesAdapter);
            }
            if(dialogeUpdateProfilePictur != null) {
                dialogeUpdateProfilePictur.dismiss();
            }
        }
    }
}