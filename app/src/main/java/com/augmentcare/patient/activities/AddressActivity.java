package com.augmentcare.patient.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

import es.dmoral.toasty.Toasty;

public class AddressActivity extends BaseActivity {

    PlacesClient placesClient;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        String apiKey = "";
        apiKey = getString(R.string.gcm_places_api_key);
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }

        placesClient = Places.createClient(this);

        AutocompleteSupportFragment autocompleteSupportFragment = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteSupportFragment.setCountry("PAK");

        autocompleteSupportFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        autocompleteSupportFragment.setOnPlaceSelectedListener(new PlaceSelectionListener(){
            @Override
            public void onPlaceSelected(@NonNull Place place){
                Log.i("OnPlaceSelected","Place: " + place.getName() + ", " + place.getId());
//                final LatLng latLng = place.getLatLng();
//                if (latLng != null) {
//                    Log.i("PlacesApi", "onPlaceSelected: " + latLng.latitude + "\n" + latLng.longitude);
//                }
            }

            @Override
            public void onError(@NonNull Status status) {
                Toasty.warning(AddressActivity.this, "An error occured", Toast.LENGTH_LONG, false).show();
            }
        });
    }
}