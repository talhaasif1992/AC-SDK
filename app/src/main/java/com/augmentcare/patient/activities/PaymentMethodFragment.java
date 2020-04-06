package com.augmentcare.patient.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.Interface.ClickItemInterface;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.card_model.CardAdapter;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.stripe.android.Stripe;
import com.vicmikhailau.maskededittext.MaskedEditText;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class PaymentMethodFragment extends BaseFragment implements View.OnClickListener, ClickItemInterface {

    private View.OnClickListener payClick;
    private Boolean cardSelected = false;

    Stripe stripe;
    public static String paymentMethod, lastFourDigits = "", cardId = "";
    public static int position;

    Button btnMakePayment;

    MaskedEditText maskedEditText;
    EditText et_cvv_code;
    Spinner spinner_year, spinner_month;
    View rootView;
    private NavController navController;
    RecyclerView cards_list_rv;

    CardAdapter cardAdapter;
    String from;

    public PaymentMethodFragment() {
        this.from = "";
    }

    public PaymentMethodFragment(String from) {
        this.from = from;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_method_new, container, false);
        init_Me(view);
        return view;
    }

    @Override
    public void onResume() {
        getPatientCardsApiCall();
        super.onResume();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stripe = new Stripe(baseActivity, BuildConfig.STRIPE_KEY);

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Payment Methods");

        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        getCreditCardBinNumbers();
        getPatientCardsApiCall();

        btnMakePayment = view.findViewById(R.id.btn_make_payment);
        if (from.equals("BookAppointment")) {
            btnMakePayment.setVisibility(View.VISIBLE);
        }

        btnMakePayment.setOnClickListener(view1 -> {
            if (payClick != null) {
                if (cardSelected)
                    payClick.onClick(view1);
            }
        });


        view.findViewById(R.id.addPayment).setOnClickListener(v -> {
            Bundle b = new Bundle();
            if (from.equals("BookAppointment")) {
                b.putBoolean("isFromBookAppointment", true);
            } else {
                b.putBoolean("isFromBookAppointment", false);
            }
            b.putString("add_payment_via", "settings");
            navController.navigate(R.id.cardSelectionDialogue, b);

        });
    }

    private void init_Me(View view) {

        cards_list_rv = view.findViewById(R.id.cards_list_rv);
        maskedEditText = view.findViewById(R.id.et_card_number);
        et_cvv_code = view.findViewById(R.id.et_cvv_code);
//        spinner_year = view.findViewById(R.id.spinner_year);
//        spinner_month = view.findViewById(R.id.spinner_month);

    }

    private void showErrorMessage(String message) {
        ViewUtils.showOneButtonDialog(baseActivity, "Error", message, (dialogInterface, i) -> {
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                baseActivity.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
        if (strings != null) {
            creditCardBinNumbers.addAll(strings);
            MyApp.get().setCreditCardBinNumbers(creditCardBinNumbers);
        }
    }

    private void getPatientCardsApiCall() {
        getDisposer().add(
                baseActivity.RXAPI.getUserCards()
                        .subscribe(this::onGotCreditCards, LocalUtils::processAPIError)
        );
    }

    private void onGotCreditCards(List<CreditCard> cardList) {
        try {
            if (cardList.size() > 0) {
                if (from.equals("BookAppointment")) {
                    cardAdapter = new CardAdapter(cardList, baseActivity, this, 1);
                } else {
                    cardAdapter = new CardAdapter(cardList, baseActivity, this, 0);
                }

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(baseActivity);
                cards_list_rv.setHasFixedSize(true);
                cards_list_rv.setLayoutManager(mLayoutManager);
                cards_list_rv.setAdapter(cardAdapter);
                cards_list_rv.setVisibility(View.VISIBLE);
                //     txtNoPreviousCards.setVisibility(View.GONE);
            } else {
                // cards_list_rv.setVisibility(View.GONE);
                //   txtNoPreviousCards.setVisibility(View.VISIBLE);
            }

        } catch (Exception ignored) {
        }
    }

    private void deleteCardsApiCall(String cardId) {
        getDisposer().add(
                baseActivity.RXAPI.getDeleteCard(cardId).subscribe(
                        this::OnDeleteCreditCard, LocalUtils::processAPIError
                )
        );
    }

    private void OnDeleteCreditCard(Boolean result) {
        cardAdapter.notifyDataSetChanged();
        getPatientCardsApiCall();
    }

    @Override
    public void addClickItem(String id, String lastFourDigits1, String type) {
        try {
            cardSelected = true;
            cardId = id;
            lastFourDigits = lastFourDigits1;
            paymentMethod = type;
            PrefsHelper.get(baseActivity).remove(Constants.CASH_ON_DELIVERY);
            //Objects.requireNonNull(baseActivity).finish();
        } catch (Exception ignored) {
        }
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
        } catch (Exception ignored) {
        }
    }

    public void setOnMakePaymentClick(View.OnClickListener payClick) {
        this.payClick = payClick;
    }

    @Override
    public void onClick(View v) {
    }
}