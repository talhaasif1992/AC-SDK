package com.augmentcare.patient.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseBottomSheetDialogFragment;

import java.util.Objects;

public class CardSelectionDialogue extends BaseBottomSheetDialogFragment implements View.OnClickListener {

    View rootView;

    LinearLayout jazz_cash, visa_card, promo_option;
    Boolean fromBookAppointment = false;
    int plan_id;
    String viaSettings = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_card_selection_dialogue, container, false);
        init_Me(rootView);
        return rootView;
    }

    private void init_Me(View view){

        if(getArguments()!=null){
            Bundle b = getArguments();
            fromBookAppointment = b.getBoolean("isFromBookAppointment");
            viaSettings = b.getString("add_payment_via");
            if(b.getString("plan_id") != null) {
                plan_id = Integer.parseInt(Objects.requireNonNull(b.getString("plan_id")));
            }
        }
        jazz_cash = view.findViewById(R.id.jazz_cash_option);
        visa_card = view.findViewById(R.id.visa_card_option);
        promo_option = view.findViewById(R.id.promo_option);

        if (fromBookAppointment) {
            jazz_cash.setVisibility(View.GONE);
            promo_option.setVisibility(View.GONE);
        }
        if(viaSettings.equals("settings")){
            jazz_cash.setVisibility(View.GONE);
        }

        jazz_cash.setOnClickListener(this);
        visa_card.setOnClickListener(this);
        promo_option.setOnClickListener(this);
    }
//
//    public void jazzCashPay(int selectedPlanID, String jazzCashAccountNumber) {
//        getDisposer().add(
//                baseActivity.RXAPI.jazzCashPayPlan(selectedPlanID,jazzCashAccountNumber)
//                .subscribe(userLogin -> {
//                    PrefsHelper.setLoggedInUser(userLogin);
//
//                    //
//                }, e -> {
//                    LocalUtils.processAPIError(e);
//                })
//        );
//    }

    public void showJazzCashPaymentDialog(){

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        Bundle b = new Bundle();
        switch (v.getId()) {
            case R.id.jazz_cash_option:
                b.putInt("plan_id", plan_id);

                safeNavigateTo(NavController::popBackStack);

                safeNavigateTo(navController->{
                    navController.navigate(R.id.enterJazzCashNumberFragment, b);
                });

                break;
            case R.id.visa_card_option:
                safeNavigateTo(navController -> {
                    navController.navigate(
                            CardSelectionDialogueDirections
                                    .actionCardSelectionDialogueToAddCardFragment()
                            .setAddCardFlagToggle(true)
                    );
                });
                break;
            case R.id.promo_option:
                safeNavigateTo(navController -> {
                    navController.navigate(
                            CardSelectionDialogueDirections
                                    .actionCardSelectionDialogueToAddCardFragment()
                                    .setAddCardFlagToggle(false)
                    );
                });

                break;
        }
    }
}
