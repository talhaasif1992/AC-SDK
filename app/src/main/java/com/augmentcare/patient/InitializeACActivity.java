package com.augmentcare.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.augmentcare.patient.activities.HomeScreenActivity;

public class InitializeACActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize_a_c);
        //InitAC(this);
    }
    public void InitAC(Context context){
        startActivity(new Intent(context, HomeScreenActivity.class));
    }
}
