package com.augmentcare.patient.activities;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TNCActivity extends BaseActivity {
    @BindView(R.id.tvTNC)
    TextView tvTNC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tnc);
        ButterKnife.bind(this);
     if(getSupportActionBar()!=null) {
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black);
     }
        tvTNC.setText(Html.fromHtml(getString(R.string.TNC)));
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
