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

public class TermAndConditionActivity extends BaseActivity {
    @BindView(R.id.webView)
    WebView mOrderWebView;
    private String url = "https://www.augmentcare.com/terms-of-use/";
    View spinKit;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_lab_webview);
        ButterKnife.bind(this);
        spinKit = findViewById(R.id.layout_spin_kit);
        mOrderWebView.setWebViewClient(new MyBrowser());
        mOrderWebView.getSettings().setLoadsImagesAutomatically(true);
        mOrderWebView.getSettings().setJavaScriptEnabled(true);
        mOrderWebView.getSettings().setBuiltInZoomControls(true);
        mOrderWebView.getSettings().setDisplayZoomControls(false);
        mOrderWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mOrderWebView.loadUrl(url);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("Term and Condition");
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
                // app icon in action bar clicked; go home
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}