package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.OnDeleteDependentCall;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.DependentsAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class DependentFragment extends BaseFragment implements View.OnClickListener, OnDeleteDependentCall {
    @BindView(R.id.dependent_recyclerview)
    RecyclerView mDependentRecyclerView;

    @BindView(R.id.txtNoResults)
    TextView mNoResultsTextView;

    @BindView(R.id.add_member_button)
    Button mAddMemberButton;

    private NavController navController;

    View rootView;

    private RecyclerView.LayoutManager mLayoutManager;
    List<Dependent> dependents;
    DependentsAdapter dependentsAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_manage_family_list, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMe();
    }

    private void initMe() {

        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        ((HomeScreenActivity) baseActivity).setToolbarTitle("My Family");
        mAddMemberButton = rootView.findViewById(R.id.add_member_button);
        mAddMemberButton.setOnClickListener(this);

        dependentsAdapter = new DependentsAdapter(new ArrayList<>(), baseActivity, DependentFragment.this);
        mLayoutManager = new LinearLayoutManager(baseActivity);
        mDependentRecyclerView.setHasFixedSize(true);
        mDependentRecyclerView.setLayoutManager(mLayoutManager);
        mDependentRecyclerView.setAdapter(dependentsAdapter);

        getDependentsApiCall();

        GenApiLogger.fireManageDependent(baseActivity);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_member_button:
                navController.navigate(DependentFragmentDirections.actionDependentFragmentToAddDependentMemberFragment());
                break;
        }
    }

    private void getDependentsApiCall() {
        getDisposer().add(
                baseActivity.RXAPI.getAllDependent().subscribe(deps -> {
                    dependents = deps;
                    dependentsAdapter.setDependents(dependents);

                    if (dependents.size() > 0) {
                        mNoResultsTextView.setVisibility(View.GONE);
                    } else {
                        mNoResultsTextView.setVisibility(View.VISIBLE);
                    }
                }, LocalUtils::processAPIError)
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                baseActivity.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onDeleteDependent(Boolean aboolean) {
        if (aboolean) {
            Toasty.success(baseActivity, "Dependent Deleted Successfully").show();
            dependentsAdapter.notifyDataSetChanged();
            getDependentsApiCall();
        }
    }

    @Override
    public void deleteItem(int Id) {
        getDisposer().add(
                baseActivity.RXAPI.deleteDependent(Id).subscribe(this::onDeleteDependent, LocalUtils::processAPIError)
        );
    }
}