package com.augmentcare.patient.activities;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.augmentcare.patient.R;

public class AboutActivity extends AppCompatActivity {

    

    String url = "";
    String title = "";
    TextView title_bar;
    WebView webView;
    ProgressBar progressBar;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        title_bar = findViewById(R.id.title_bar);
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progress);

        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        //webView.getSettings().setDisplayZoomControls(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                url = extras.getString("url");
                title = extras.getString("title");
                webView.loadUrl(url);
                title_bar.setText(title);
            }
        } catch (Exception ignored) {
        }
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

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
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    }

}
