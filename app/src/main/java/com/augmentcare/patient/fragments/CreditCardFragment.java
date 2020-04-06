package com.augmentcare.patient.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.Interface.ClickItemInterface;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.AddCardActivity;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.CreditCardAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.NetworkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class CreditCardFragment extends BaseFragment implements View.OnClickListener, ClickItemInterface {

    LinearLayout mAddCardLinearLayout;
    CreditCardAdapter mCreditCardAdapter;
    RecyclerView mCreditCardRecyclerView;
    List<CreditCard> cardModelArrayList;
    Button btnMakePayment;
    public static String paymentMethod, lastFourDigits = "", cardId = "";
    public static int position;
    String typeNavigation = "default";
    TextView txtNoPreviousCards;
    private View.OnClickListener payClick;
    private Boolean cardSelected = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit_card, container, false);
        mAddCardLinearLayout = view.findViewById(R.id.add_card_linearlayout);
        mCreditCardRecyclerView = view.findViewById(R.id.creditCardRecyclerView);
        txtNoPreviousCards = view.findViewById(R.id.txtNoPreviousCards);
        btnMakePayment = view.findViewById(R.id.btn_make_payment);
        btnMakePayment.setVisibility(View.VISIBLE);
        mAddCardLinearLayout.setOnClickListener(this);

        if(getArguments()!=null){
            CreditCardFragmentArgs args = CreditCardFragmentArgs.fromBundle(getArguments());
            if(args.getIsFromSettings()){
                ((HomeScreenActivity)baseActivity).setToolbarTitle("Payment Methods");
                btnMakePayment.setVisibility(View.GONE);
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mAddCardLinearLayout.getLayoutParams();
                params.setMarginStart(280);
                params.setMarginEnd(280);
                mAddCardLinearLayout.setLayoutParams(params);
            }
        }

        getCreditCardBinNumbers();
        getPatientCardsApiCall();
        
        btnMakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(payClick != null){
                    if(cardSelected)
                    payClick.onClick(view);
                }
            }
        });

        try {
            Bundle extras = baseActivity.getIntent().getExtras();
            if (extras != null) {
                typeNavigation = extras.getString("typeNavigation");
            }
        } catch (Exception ignored) {
        }
        return view;
    }

    private void getCreditCardBinNumbers() {
        if (MyApp.get().getCreditCardBinNumbers() == null || MyApp.get().getCreditCardBinNumbers().size() <= 0) {
            getDisposer().add(
                    baseActivity.RXAPI.getBindNumbersForAlfalahClients()
                            .subscribe(this::onGetBindNumbersForAlfalahClients, LocalUtils::processAPIError)
            );
        }
    }

    private void onGetBindNumbersForAlfalahClients(List<String> strings) {
            ArrayList<String> creditCardBinNumbers = new ArrayList<>();
            if (strings!=null){
                creditCardBinNumbers.addAll(strings);
                MyApp.get().setCreditCardBinNumbers(creditCardBinNumbers);
            }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_card_linearlayout) {
            startActivity(new Intent(baseActivity, AddCardActivity.class));
        }
    }

    private void getPatientCardsApiCall() {
        getDisposer().add(
                baseActivity.RXAPI.getUserCards()
                .subscribe(this::onGotCreditCards, LocalUtils::processAPIError)
        );
    }

    private void onGotCreditCards(List<CreditCard> cardList){
        try{
                cardModelArrayList = cardList;

                if (cardModelArrayList.size() > 0) {
                    if (typeNavigation != null && typeNavigation.equalsIgnoreCase("home")) {
                        mCreditCardAdapter = new CreditCardAdapter(cardModelArrayList, baseActivity, this, position, "home");
                    } else {
                        mCreditCardAdapter = new CreditCardAdapter(cardModelArrayList, baseActivity, this, position, "default");
                    }
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(baseActivity);
                    mCreditCardRecyclerView.setHasFixedSize(true);
                    mCreditCardRecyclerView.setLayoutManager(mLayoutManager);
                    mCreditCardRecyclerView.setAdapter(mCreditCardAdapter);
                    mCreditCardRecyclerView.setVisibility(View.VISIBLE);
                    txtNoPreviousCards.setVisibility(View.GONE);
                } else {
                    mCreditCardRecyclerView.setVisibility(View.GONE);
                    txtNoPreviousCards.setVisibility(View.VISIBLE);
                }

        } catch(Exception ignored){}
    }

    private void deleteCardsApiCall(String cardId){
        getDisposer().add(
                baseActivity.RXAPI.getDeleteCard(cardId).subscribe(
                        this::OnDeleteCreditCard, LocalUtils::processAPIError
                )
        );
    }

    private void OnDeleteCreditCard(Boolean result){
        mCreditCardAdapter.notifyDataSetChanged();
        getPatientCardsApiCall();
    }

    @Override
    public void addClickItem(String id1, String lastFourDigits1, String type) {
        try{
            cardSelected = true;
                cardId = id1;
                lastFourDigits = lastFourDigits1;
                paymentMethod = type;
                PrefsHelper.get(baseActivity).remove(Constants.CASH_ON_DELIVERY);
                //Objects.requireNonNull(baseActivity).finish();
        } catch(Exception ignored){}
    }

    @Override
    public void deleteItem(String Id) {
        try {
            if (NetworkUtils.isConnected()) {
                ViewUtils.showDialogWithButtons(baseActivity,
                        "Warning", "Are you sure you want to delete this card?",
                        "No", "Yes", (dialogInterface, i) -> {
                            if (i == DialogInterface.BUTTON_POSITIVE) {
                                deleteCardsApiCall(Id);
                            }
                        });
            } else {
                Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
            }
        } catch (Exception ignored){}
    }

    @Override
    public void onResume() {
        getPatientCardsApiCall();
        super.onResume();
    }

    public void setOnMakePaymentClick(View.OnClickListener payClick){
        this.payClick = payClick;
    }
}