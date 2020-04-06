package com.augmentcare.patient.activities;

import android.Manifest;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatSpinner;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.model.AArea;
import com.augmentcare.patient.model.ACity;
import com.augmentcare.patient.network.restApi.apimodels.Address;
import com.augmentcare.patient.network.restApi.apimodels.Area;
import com.augmentcare.patient.network.restApi.apimodels.AreasResponse;
import com.augmentcare.patient.network.restApi.apimodels.City;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class AddAddressActivity extends BaseActivity {

    @BindView(R.id.btnAdd)
    Button btnAddress;
    @BindView(R.id.spnrCity)
    AppCompatSpinner spnrCity;
    @BindView(R.id.spnrArea)
    AppCompatSpinner spnrArea;

    @BindView(R.id.etxtAddress1)
    AutoCompleteTextView etxtAddress1;
    @BindView(R.id.etxtAddress2)
    AutoCompleteTextView etxtAddress2;
    @BindView(R.id.contentFrame)
    View contentFrame;
    @BindView(R.id.btnPickLocation)
    ImageButton btnPickLocation;

    private List<String> areasForSpinner;
    List<City> cities;
    private List<String> citiesForSpinner;

    boolean isEditOnly = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);

        getUserInfo(userData -> {
            this.userData = userData;
        });

        isEditOnly = getIntent().getBooleanExtra("editOnly", false);
        if (isEditOnly) {
            btnAddress.setText("Save");
        }
        if (savedInstanceState == null) {
            getDisposer().add(
                    RXAPI.getAllAreas("pharmacy").subscribe(this::onGetAllAreas, LocalUtils::processAPIError)
            );
        }
        else{
            if (!savedInstanceState.containsKey("cities")) {
                getDisposer().add(
                        RXAPI.getAllAreas("pharmacy").subscribe(this::onGetAllAreas, LocalUtils::processAPIError)
                );
            } else {
                cities = savedInstanceState.getParcelableArrayList("cities");
            }
        }
        spnrCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                areasForSpinner = new ArrayList<>();

                for(int x=0 ; x < cities.get(i).getAreas().size() ; x++) {
                    areasForSpinner.add(cities.get(i).getAreas().get(x).getName());
                }

                if (areasForSpinner != null && areasForSpinner.size() > 0) {
                    spnrArea.setAdapter(new ArrayAdapter<>(AddAddressActivity.this, android.R.layout.simple_list_item_1, areasForSpinner));
                    spnrArea.setVisibility(View.VISIBLE);
                } else {
                    spnrArea.setAdapter(null);
                    spnrArea.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnrCity.getBackground().setColorFilter(getResources().getColor(R.color.colorLinkText), PorterDuff.Mode.SRC_ATOP);
        spnrArea.getBackground().setColorFilter(getResources().getColor(R.color.colorLinkText), PorterDuff.Mode.SRC_ATOP);
        spnrArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnAddress.setEnabled(false);
        btnAddress.setOnClickListener(view -> {
            if (validate()) {
                int city = spnrCity.getSelectedItemPosition();
                if (city >= 0 ){
                    int areaIndex = spnrArea.getSelectedItemPosition();
                    if (!isEditOnly){
                        int userId, areaId = 0, cityId;
                        String cityName, area = null, streetAddress1, streetAddress2;

                        userId = userData.getUserId();
                        cityName = cities.get(city).getName();

                        if (cities.get(city).getAreas() != null && cities.get(city).getAreas().size()>0) {
                            area = cities.get(city).getAreas().get(areaIndex).getName();
                            areaId = cities.get(city).getAreas().get(areaIndex).getId();
                        }

                        cityId = cities.get(city).getId();
                        streetAddress1 = etxtAddress1.getText().toString();
                        streetAddress2 = etxtAddress2.getText().toString();

                        getDisposer().add(
                                RXAPI.addUserAdress(userId, cityName, area, areaId, cityId, streetAddress1, streetAddress2)
                                        .subscribe(this::onAddUserAddress,LocalUtils::processAPIError)
                        );

                    }
                    else{
                        Intent intent = new Intent();
                        intent.putExtra("address1", etxtAddress1.getText().toString());
                        intent.putExtra("address2", etxtAddress2.getText().toString());
                        if (cities.get(city).getAreas() != null)
                            intent.putExtra("area", cities.get(city).getAreas().get(areaIndex).getName());
                        intent.putExtra("city", cities.get(city).getName());
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            } else {
                Toasty.error(AddAddressActivity.this, getString(R.string.enter_valid_address), Toast.LENGTH_LONG, false).show();
            }
        });
        btnPickLocation.setOnClickListener(view -> requestPermissions());


    }

    private void onAddUserAddress(Address address) {
        setResult(RESULT_OK);
        finish();
    }

    private void onGetAllAreas(AreasResponse areasResponse) {

        btnAddress.setEnabled(true);

        cities = new ArrayList<>();
        citiesForSpinner = new ArrayList<>();

        List<City> gotCities = areasResponse.getCities();

        if (gotCities != null && gotCities.size() > 0) {
            for(City city: gotCities){
                if(city.getName().toLowerCase().contains("lahore") )
                    cities.add(city);
                    citiesForSpinner.add(city.getName());
                }
            spnrCity.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citiesForSpinner));
        }
        else{
            Toasty.error(this, getString(R.string.failed_to_get_areas), Toast.LENGTH_LONG, false).show();
        }

    }

    @AfterPermissionGranted(233)
    private void requestPermissions() {

        String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {

            int status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(AddAddressActivity.this);
            if (status == ConnectionResult.SUCCESS) {
                try {
                    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                    startActivityForResult(builder.build(AddAddressActivity.this), 21);
                } catch (Exception e) {
                }
            } else {
                if (GoogleApiAvailability.getInstance().isUserResolvableError(status)) {
                    GoogleApiAvailability.getInstance().showErrorDialogFragment(AddAddressActivity.this, status, 23);
                }
            }
        }
        else{
            EasyPermissions.requestPermissions(this, "Need to access location for this", 233, perms);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 21) { //location
                Place place = PlacePicker.getPlace(getApplicationContext(), data);
            }
            if (requestCode == 23) {
                try {
                    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                    startActivityForResult(builder.build(AddAddressActivity.this), 21);
                } catch (Exception e) {
                }
            }
        }
    }

    private boolean validate() {
        return !etxtAddress1.getText().toString().trim().isEmpty() || !etxtAddress2.getText().toString().trim().isEmpty();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}