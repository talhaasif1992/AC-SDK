package com.augmentcare.patient.activities;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PmdcWebViewActivity extends BaseActivity {
    @BindView(R.id.webView)
    WebView mPmdcWebView;
    private String url = "http://pmc.gov.pk/search_record.html?regNo=";
    View spinKit;
    String doctorName, pmdcNumber;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_lab_webview);
        ButterKnife.bind(this);
        spinKit = findViewById(R.id.layout_spin_kit);
        mPmdcWebView.setWebViewClient(new MyBrowser());
        mPmdcWebView.getSettings().setLoadsImagesAutomatically(true);
        mPmdcWebView.getSettings().setJavaScriptEnabled(true);
        mPmdcWebView.getSettings().setBuiltInZoomControls(true);
        mPmdcWebView.getSettings().setDisplayZoomControls(true);
        mPmdcWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                pmdcNumber = extras.getString("pmdc_number");
                doctorName = extras.getString("doctor_name");
                mPmdcWebView.loadUrl(url + pmdcNumber);
            }
        } catch (Exception ignored) {
        }
        mPmdcWebView.getSettings().setLoadWithOverviewMode(true);
        mPmdcWebView.getSettings().setUseWideViewPort(true);
     if(getSupportActionBar()!=null) {
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setHomeButtonEnabled(true);
         getSupportActionBar().setTitle(doctorName);
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
            spinKit.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            spinKit.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}