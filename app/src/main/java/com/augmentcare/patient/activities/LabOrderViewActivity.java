package com.augmentcare.patient.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LabOrderViewActivity extends BaseActivity {
    @BindView(R.id.webView)
    WebView mOrderWebView;
    private String url;
    ProgressDialog progressBar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_lab_webview);
        ButterKnife.bind(this);
        try {
            Bundle extras = getIntent().getExtras();
            url = null;
            if (extras != null) {
                url = extras.getString("url");
            }
        } catch (Exception ignored) {
        }
        mOrderWebView.setWebViewClient(new MyBrowser());
        mOrderWebView.getSettings().setLoadsImagesAutomatically(true);
        mOrderWebView.getSettings().setJavaScriptEnabled(true);
        mOrderWebView.getSettings().setBuiltInZoomControls(true);
        mOrderWebView.getSettings().setDisplayZoomControls(false);
        mOrderWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        if (url.contains(".pdf")) {
            mOrderWebView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + url);
        } else {
            mOrderWebView.loadUrl(url);
        }
     if(getSupportActionBar()!=null) {
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setHomeButtonEnabled(true);
         getSupportActionBar().setTitle("Report");
         getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow);
     }
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar = ViewUtils.showProgressDialog(LabOrderViewActivity.this, "Loading...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            ViewUtils.dismissProgressDialog(LabOrderViewActivity.this, progressBar);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_download_lab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                finish();
                return true;
            case R.id.action_share:
                shareReport();
                return true;
            case R.id.action_download:
                isWriteStoragePermissionGranted();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareReport() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share Lab Report");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(sharingIntent, "Sharing Option"));
    }

    public boolean isWriteStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                downloadFile(Uri.parse(url));
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                return false;
            }
        } else {
            downloadFile(Uri.parse(url));
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 2:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //resume tasks needing this permission
                    downloadFile(Uri.parse(url));
                }
                break;
        }
    }

    /**
     * @param uri
     */
    private void downloadFile(Uri uri) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI |
                DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("AugmentCare");
        request.setDescription("Android Data download using DownloadManager.");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, url + ".pdf");
        request.setMimeType("*/*");
        downloadManager.enqueue(request);
    }
}