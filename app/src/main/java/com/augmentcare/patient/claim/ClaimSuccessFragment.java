package com.augmentcare.patient.claim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClaimSuccessFragment extends BaseFragment implements View.OnClickListener{
    String claim_type, claim_for, claim_details;
    Integer amount;
    @BindView(R.id.claim_amount_textview)
    TextView mAmountTextView;
    @BindView(R.id.claim_type_textview)
    TextView mClaimTypeTextView;
    @BindView(R.id.claim_for_textview)
    TextView mClaimForTextView;
    @BindView(R.id.claim_details_textview)
    TextView mClaimDetailsTextView;
    @BindView(R.id.home_relative_layout)
    RelativeLayout mHomeLinearLayout;
    private View rootView;
    private ClaimSuccessFragmentArgs args;
    private NavController mainNav;

    public ClaimSuccessFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_claim_success_new, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initIt();
    }

    private void initIt() {
        loadArgs();

        mainNav = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);

        amount = args.getAmount();
        claim_type = args.getClaimType();
        claim_for = args.getClaimFor();
        claim_details = args.getClaimDetails();
        mAmountTextView.setText(amount+"");
        mClaimTypeTextView.setText(claim_type+"");
        mClaimForTextView.setText(claim_for+"");
        mClaimDetailsTextView.setText(claim_details+"");
        mHomeLinearLayout.setOnClickListener(this);
    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = ClaimSuccessFragmentArgs.fromBundle(getArguments());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_relative_layout:
                baseActivity.onBackPressed();
                break;
        }
    }

}
