package com.augmentcare.patient.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewClaimImageActivity extends BaseActivity {

    @BindView(R.id.upload_images)
    ImageView mUploadClaimImageView;

    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_image);
        ButterKnife.bind(this);
     if(getSupportActionBar()!=null) {
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setHomeButtonEnabled(true);
         getSupportActionBar().setTitle("Uploaded Files");
         getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow);
     }
        try {
            Bundle extras = getIntent().getExtras();
            url = null;
            if (extras != null) {
                url = extras.getString("url");
                if (url != null) {
                    Glide.with(ViewClaimImageActivity.this).load(url).apply(RequestOptions.fitCenterTransform()).into(mUploadClaimImageView);
                }
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * @param item
     */
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
