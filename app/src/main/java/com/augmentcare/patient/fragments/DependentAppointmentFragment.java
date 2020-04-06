//package com.augmentcare.patient.activities;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.GridView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.augmentcare.patient.R;
//import com.augmentcare.patient.adapters.DependentGridAdapter;
//import com.augmentcare.patient.base.BaseActivity;
//import com.augmentcare.patient.network.restApi.apimodels.Dependent;
//import com.augmentcare.patient.utils.LocalUtils;
//import com.augmentcare.patient.utils.PrefsHelper;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class DependentAppointmentFragment extends Fragment implements View.OnClickListener {
//    public final static String NAME_DEP_RETURN_EXTRA = "NAME_DEP_RETURN_EXTRA_DependentAppointmentActivity";
//    public final static String ID_DEP_RETURN_EXTRA = "ID_DEP_RETURN_EXTRA_DependentAppointmentActivity";
//
//    @BindView(R.id.dependentGV)
//    GridView mDependentGridView;
//
//    @BindView(R.id.btnManageDependent)
//    Button mManageDependentButton;
//
//
//    List<Dependent> dependents;
//    String claimFor = "";
//    private View rootView;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        rootView = inflater.inflate(R.layout.layout_file_a_claim, container, false);
//        ButterKnife.bind(this, rootView);
//        return rootView;
//
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        initIt();
//    }
//
//    private void initIt() {
//
//        mDependentGridView.setOnItemClickListener((parent, v, position, id) ->
//        {
//            if (claimFor != null && !claimFor.isEmpty() && claimFor.equalsIgnoreCase("Claim")) {
//                result(position);
//            } else if (claimFor != null && !claimFor.isEmpty() && claimFor.equalsIgnoreCase("instantAppointment")) {
//                result(position);
//            } else if (claimFor != null && !claimFor.isEmpty() && claimFor.equalsIgnoreCase("Explore")) {
//                result(position);
//            } else if (claimFor != null && !claimFor.isEmpty() && claimFor.equalsIgnoreCase("Medicine")) {
//                result(position);
//            } else if (claimFor != null && !claimFor.isEmpty() && claimFor.equalsIgnoreCase("Labs")) {
//                result(position);
//            }
//        });
//
//        mManageDependentButton.setOnClickListener(this);
//        getDependentsApiCall();
//        try {
//            Bundle extras = getIntent().getExtras();
//
//            if (extras != null) {
//                claimFor = extras.getString("NavigationFlag");
//            }
//        } catch (Exception ignored) {
//        }
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_dependent_appointment);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            onBackPressed();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.btnManageDependent) {
//            startActivity(new Intent(this, DependentActivity.class));
//        }
//    }
//
//    private void result(int position) {
//        Intent returnIntent = new Intent();
//        returnIntent.putExtra(NAME_DEP_RETURN_EXTRA, dependents.get(position).getName());
//
//        if (dependents.get(position).getId() != null) {
//            returnIntent.putExtra(ID_DEP_RETURN_EXTRA, dependents.get(position).getId().toString());
//        }
//
//        setResult(Activity.RESULT_OK, returnIntent);
//        finish();
//    }
//
//    private void getDependentsApiCall() {
//        getDisposer().add(
//                RXAPI.getAllDependent().subscribe(s -> {
//                    dependents = s;
//                    Dependent dependant = new Dependent()
//                            .withName(baseActivity.userData.getFirstName() + " " + baseActivity.userData.getLastName())
//                            .withPhoto(baseActivity.userData.getPhoto());
//                    dependents.add(0, dependant);
//
//                    if (dependents.size() > 0) {
//                        mDependentGridView.setAdapter(new DependentGridAdapter(this, dependents));
//                    }
//                }, LocalUtils::processAPIError)
//        );
//    }
//
//}