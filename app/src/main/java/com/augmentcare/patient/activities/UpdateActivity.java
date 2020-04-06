package com.augmentcare.patient.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.utils.Constants;
import com.google.gson.JsonObject;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class UpdateActivity extends AppCompatActivity
{
    TextView txtMessage;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        txtMessage = findViewById(R.id.txtMessage);
        btnUpdate = findViewById(R.id.btnUpdate);

        String data = getIntent().getStringExtra(Constants.KEY_DATA);
        JsonObject jsonObject = MyApp.getGson().fromJson(data, JsonObject.class);
        txtMessage.setText(Html.fromHtml(jsonObject.get("message").getAsString()));
        btnUpdate.setOnClickListener(view -> launchMarket());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow);

    }

    private void launchMarket()
    {
        String packageName = UpdateActivity.this.getPackageName();
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try
        {
            UpdateActivity.this.startActivity(myAppLinkToMarket);
        }
        catch (ActivityNotFoundException e)
        {
            Toasty.error(UpdateActivity.this, "Unable to load app details page at the moment. Please try again later ! ",
                    Toast.LENGTH_LONG, false).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}