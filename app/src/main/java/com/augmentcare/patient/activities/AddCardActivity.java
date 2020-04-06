package com.augmentcare.patient.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.ViewUtils;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.exception.CardException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;

import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class AddCardActivity extends BaseActivity implements View.OnClickListener, VolleyAPI.FragmentInteractionListener {

    @BindView(R.id.add_card_button)
    Button mAddCardButton;

    @BindView(R.id.name_card)
    EditText mCardNameEditText;

    @BindView(R.id.card_number)
    EditText mCardNumberEditText;

    @BindView(R.id.et_expiry_date)
    EditText mExpiryDateEditText;

    @BindView(R.id.et_cvc_number)
    EditText mCvvEditText;

    Stripe stripe;
    int cardExpMonth = 0, cardExpYear = 0;
    String cardNumber, cardCvvNumber, cardName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        ButterKnife.bind(this);

        VOLLEYAPI.withListner(this);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("Add Card");
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow);
        }
        stripe = new Stripe(AddCardActivity.this, BuildConfig.STRIPE_KEY);
        mAddCardButton.setOnClickListener(this);

        mCardNumberEditText.addTextChangedListener(new GenericTextWatcher(mCardNumberEditText));
        mExpiryDateEditText.addTextChangedListener(new GenericTextWatcher(mExpiryDateEditText));
    }

    private void addStripeInfo(String name, String cardNumber, int cardExpireMonth, int cardExpireYear, String cardCvvNumber) {

        Card card = new Card(cardNumber, cardExpireMonth, cardExpireYear, cardCvvNumber);
        card.setName(name);

        stripe.createToken(card, new TokenCallback() {
                    public void onSuccess(Token token) {
                        // Send token to your server
                        if (token != null) {
                            addToken(token.getId());
                        }

                        if (token.getLivemode() || true) {
                            Intent intent = new Intent();
                            intent.putExtra("stripeToken", token.getId());
                            setResult(RESULT_OK, intent);
                        } else {
                            if (AddCardActivity.this != null)
                                Toasty.error(AddCardActivity.this, R.string.invalid_card_credentials, Toast.LENGTH_LONG, false).show();
                        }
                    }

                    public void onError(Exception error) {
                        Log.e("cardErrors", error.getStackTrace() + "");
                        if (error instanceof CardException) {
                            if (error.getMessage() != null) {
                                Toasty.error(AddCardActivity.this, R.string.invalid_card_credentials, Toast.LENGTH_LONG, false).show();
                            }
                        }
                    }
                }
        );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_card_button:
                cardName = mCardNameEditText.getText().toString();
                cardNumber = mCardNumberEditText.getText().toString();
                cardCvvNumber = mCvvEditText.getText().toString();

                if (!mExpiryDateEditText.getText().toString().isEmpty()) {
                    StringTokenizer tokens = new StringTokenizer(mExpiryDateEditText.getText().toString(), "/");
                    cardExpMonth = Integer.parseInt(tokens.nextToken());
                    cardExpYear = Integer.parseInt(tokens.nextToken());
                }

                if (cardNumber.equalsIgnoreCase("")) {
                    showErrorMessage("Please enter Card Number.");
                } else if (cardExpMonth == 0) {
                    showErrorMessage("Please enter Expiry.");
                } else if (cardCvvNumber.equalsIgnoreCase("")) {
                    showErrorMessage("Please enter CVC.");
                } else if (cardName.equalsIgnoreCase("")) {
                    showErrorMessage("Please Enter Name On Card.");
                } else {
                    if (!cardName.isEmpty() && !cardNumber.isEmpty() && cardExpMonth != 0 && cardExpYear != 0 && !cardCvvNumber.isEmpty())
                    addStripeInfo(cardName, cardNumber, cardExpMonth, cardExpYear, cardCvvNumber);
                    labPaymentMethodAddEvent("credit_card");
                }
                break;
        }
    }

    private void showErrorMessage(String message) {
        ViewUtils.showOneButtonDialog(AddCardActivity.this, "Error", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

    }

    private void addToken(String token) {
        getDisposer().add(
                RXAPI.addCreditCard(token).subscribe(this::onAddCard, LocalUtils::processAPIError)
        );
    }

    private void onAddCard(CreditCard creditCard) {
        GenApiLogger.fireLogAddPaymentInfoEvent(creditCard);
        Toasty.success(AddCardActivity.this, "Card Added Successfully").show();
        finish();
    }

    @Override
    public void onFragmentInteraction(int what) {
    }

    @Override
    public void onFragmentInteraction(int what, Bundle bundle) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void labPaymentMethodAddEvent(String type) {
        GenApiLogger.fireLabPaymentMethodAddEvent(type);

    }

    private class GenericTextWatcher implements TextWatcher {
        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            switch (view.getId()) {
                case R.id.card_number:
                    String code = "";
                    if (text.length() == 4) {
                        mCardNumberEditText.setText(text + "-");
                        mCardNumberEditText.setSelection(mCardNumberEditText.getText().length());
                    } else if (text.length() == 9) {
                        mCardNumberEditText.setText(text + "-");
                        mCardNumberEditText.setSelection(mCardNumberEditText.getText().length());
                    } else if (text.length() == 14) {
                        mCardNumberEditText.setText(text + "-");
                        mCardNumberEditText.setSelection(mCardNumberEditText.getText().length());
                    } else if (text.length() == 19) {
                        mCardNumberEditText.requestFocus();
                    }
                    break;

                case R.id.et_expiry_date:
                    if (text.length() == 2) {
                        mExpiryDateEditText.setText(text + "/");
                        mExpiryDateEditText.setSelection(mExpiryDateEditText.getText().length());
                    } else if (text.length() == 7) {
                        mCvvEditText.requestFocus();
                    }
                    break;

                case R.id.et_cvc_number:
                    if (text.length() == 3) {
                    }
                    break;
            }
        }
    }
}