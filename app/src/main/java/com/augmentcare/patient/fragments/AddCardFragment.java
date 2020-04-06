package com.augmentcare.patient.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.AdjustSDKUtils;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.augmentcare.patient.utils.ViewUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.exception.CardException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.vicmikhailau.maskededittext.MaskedEditText;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;

import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

import static android.app.Activity.RESULT_OK;
import static com.augmentcare.patient.notifications.NotificationHelper.firebaseEvent;

public class AddCardFragment extends BaseFragment {

    private Button mAddCardButton;
    private EditText mCardNameEditText;
    private MaskedEditText mCardNumberEditText;
    private Spinner mExpiryDateMonth;
    private Spinner mExpiryDateYear;
    private EditText mCvvEditText;
    private EditText promoCodeET;
    private ImageView tv_scan_card;
    private Stripe stripe;
    private String cardNumber;
    private String cardCvvNumber;
    private int month = 0;
    private int year = 0;
    private int option;
    private CardView promoView;
    private CardView visaView;
    private static final int REQUEST_CODE_SCAN_CARD = 1;

    View rootView;
    private NavController navController;
    private AddCardFragmentArgs args;

    public AddCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_add_card, container, false);
        ButterKnife.bind(rootView, baseActivity);

//        #TODO change promo logo

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMe(view);
    }

    private void verifyPromoCode(String promoCode, OnValueGot<Boolean> got) {
        getDisposer().add(
                baseActivity.RXAPI.verifyPromoCode(
                        promoCode,
                        PrefsHelper.get(baseActivity).getString(Constants.KEY_PLAN_ID, "")
                ).subscribe(
                        got::gotIt,
                        e -> {
                            LocalUtils.processAPIError(e);
                            got.gotIt(false);
                        })
        );
    }

    private void initMe(View view) {
        mCardNumberEditText = view.findViewById(R.id.et_card_number);
        mCvvEditText = view.findViewById(R.id.et_cvv_code);
        mExpiryDateYear = view.findViewById(R.id.yearSpinner);
        mExpiryDateMonth = view.findViewById(R.id.spinner_month);
        mAddCardButton = view.findViewById(R.id.add_a_payment_method);
        promoView = view.findViewById(R.id.promoView);
        visaView = view.findViewById(R.id.visaView);
        promoCodeET = view.findViewById(R.id.promoCodeET);
        tv_scan_card = view.findViewById(R.id.tv_scan_card);

        loadArgs();



        baseActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);
        stripe = new Stripe(baseActivity, BuildConfig.STRIPE_KEY);

        mAddCardButton.setOnClickListener(v -> {
            if (args.getAddCardFlagToggle()) {
                if (isValid()) {
                    baseActivity.showLoader();
                    addStripeInfo(cardNumber, month, year, cardCvvNumber);
                }
            } else {
                if (!promoCodeET.getText().toString().isEmpty()) {
                    verifyPromoCode(
                            promoCodeET.getText().toString(),
                            valid -> {
                                if (valid) {
                                    processPaymentAPI("", promoCodeET.getText().toString());
                                } else {
                                    Toasty.error(Utils.getApp(), "Not a valid promo code").show();
                                }
                            }
                    );
                } else {
                    Toast.makeText(baseActivity, "Please Enter Promo Code", Toast.LENGTH_LONG).show();
                }
            }
        });
        tv_scan_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   scanCard();
                onScanPress(v);
            }
        });
    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = AddCardFragmentArgs.fromBundle(getArguments());

            if (args.getAddCardFlagToggle()) {
                ((HomeScreenActivity) baseActivity).setToolbarTitle("Add Card");
                ((HomeScreenActivity) baseActivity).showHideBackToolbar(true);
                promoView.setVisibility(View.GONE);
                visaView.setVisibility(View.VISIBLE);
                mAddCardButton.setText("Add Card");


            } else {
                ((HomeScreenActivity) baseActivity).setToolbarTitle("Add Promo Code");
                ((HomeScreenActivity) baseActivity).showHideBackToolbar(true);
                mAddCardButton.setText("Add Promo");
                promoView.setVisibility(View.VISIBLE);
                visaView.setVisibility(View.GONE);


            }

        }

    }

    private void addStripeInfo(String cardNumber, int cardExpireMonth, int cardExpireYear, String cardCvvNumber) {

        Card card = new Card(cardNumber, cardExpireMonth, cardExpireYear, cardCvvNumber);
        card.setName(cardNumber);

        stripe.createToken(card, new TokenCallback() {
                    public void onSuccess(Token token) {
                        // Send token to your server
                        if (token != null) {
                            addToken(token.getId());
                        }

                        if (token.getLivemode() || true) {
                            Intent intent = new Intent();
                            intent.putExtra("stripeToken", token.getId());
                            baseActivity.setResult(RESULT_OK, intent);

                        } else {
                            if (baseActivity != null) {
                                Toasty.error(baseActivity, R.string.invalid_card_credentials, Toast.LENGTH_LONG, false).show();
                                baseActivity.stopLoader();
                            }
                        }
                    }

                    public void onError(Exception error) {
                        Log.e("cardErrors", error.getStackTrace() + "");
                        if (error instanceof CardException) {
                            if (error.getMessage() != null) {
                                baseActivity.stopLoader();
                                Toasty.error(baseActivity, R.string.invalid_card_credentials, Toast.LENGTH_LONG, false).show();
                            }
                        }
                    }
                }
        );
    }

    public boolean isValid() {
        cardNumber = mCardNumberEditText.getUnMaskedText();
        cardCvvNumber = mCvvEditText.getText().toString();


        if (cardNumber.isEmpty()) {
            showErrorMessage("Please enter Card Number.");

        } else if (mExpiryDateMonth.getSelectedItemPosition() == 0) {
            showErrorMessage("Please Select Month.");
        } else if (mExpiryDateYear.getSelectedItemPosition() == 0) {
            showErrorMessage("Please Select Year.");
        } else if (cardCvvNumber.equalsIgnoreCase("")) {
            showErrorMessage("Please enter CVC.");
        } else {
            month = Integer.parseInt(mExpiryDateMonth.getSelectedItem().toString());
            year = Integer.parseInt(mExpiryDateYear.getSelectedItem().toString());

            if (!cardNumber.isEmpty() && !cardCvvNumber.isEmpty()) {
                //   addStripeInfo(cardName, cardNumber, cardExpMonth, cardExpYear, cardCvvNumber);
                GenApiLogger.fireLabPaymentMethodAddEvent("credit_card");
                return true;
            }
        }
        return false;

    }

    private void showErrorMessage(String message) {
        ViewUtils.showOneButtonDialog(baseActivity, "Error", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

    }

    private void addToken(String token) {
        getDisposer().add(
                baseActivity.RXAPI.addCreditCard(token).subscribe(this::onAddCard, LocalUtils::processAPIError)
        );
    }

    private void addPromoCode(String promo) {
        if (promo.equals(getString(R.string.bank_alfalah_promo_code))) {
            getDisposer().add(
                    baseActivity.RXAPI.setPromo(promo)
                            .subscribe(sent -> {
                                navController.navigate(R.id.bankAlfalahPaymentSuccessFragment);
                            }, e -> {
                                try {
                                    Toasty.error(baseActivity, e.getMessage().replace("\"", ""), Toast.LENGTH_LONG, false).show();
                                } catch (Exception ignored) {
                                    Toasty.error(baseActivity, "Error! Please try again later. If issue persists contact administrator.", Toast.LENGTH_LONG, false).show();
                                }


                            }));
        } else {
            Toasty.error(baseActivity, "Invalid Promo Code", Toasty.LENGTH_LONG).show();
        }
    }

    private void onAddCard(com.augmentcare.patient.network.restApi.apimodels.CreditCard creditCard) {
        baseActivity.stopLoader();
        Toasty.success(baseActivity, "Card Added Successfully").show();
        navController.popBackStack();


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



    public void onScanPress(View v) {
        Intent scanIntent = new Intent(baseActivity, CardIOActivity.class);

        // customize these values to suit your needs.
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false); // default: false

        // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
        startActivityForResult(scanIntent, REQUEST_CODE_SCAN_CARD);
    }

    private void processPaymentAPI(String token, String couponCode) {
        AnalyticsUtils.logEvent(baseActivity, FirebaseEvents.PLAN_CARD_ENTERED, null);
        getDisposer().add(
                baseActivity.RXAPI.purchasePlan(
                        token,
                        PrefsHelper.get(baseActivity).getString(Constants.KEY_PLAN_ID, ""),
                        couponCode
                )
                        .subscribe(userLogin -> {
                            afterPaymentProcess(userLogin, couponCode);
                        }, e -> {
                            try {
                                Toasty.error(baseActivity, e.getMessage().replace("\"", ""), Toast.LENGTH_LONG, false).show();
                            } catch (Exception ignored) {
                                Toasty.error(baseActivity, "Error! Please try again later. If issue persists contact administrator.", Toast.LENGTH_LONG, false).show();
                            }

                        })
        );
    }

    private void afterPaymentProcess(UserLogin model, String couponApplied) {
        if (model.getRoles().size() > 0) {
            AnalyticsUtils.logEvent(Utils.getApp(), FirebaseEvents.PLAN_PURCHASED, null);
            firebaseEvent(baseActivity, "subscription_buy_plan");
            firebaseEvent(baseActivity, "StartTrial_100");
            AdjustSDKUtils.adjustRevenueEvent(getString(R.string.adjust_subscription_purchased), 0);

            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_ON_PLAN, model.isIsOnPlan());
            PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_FROM_ORGANIZATION, model.isFromOrganization());

            if (LocalUtils.isThisUserType(model,"HR")) {
                updateUser();
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_HR, true);
                return;
            }

            PrefsHelper.get(baseActivity).putString(Constants.KEY_ROLES, model.getRoles().toString());
            PrefsHelper.get(baseActivity).putString(Constants.KEY_CHANNEL, model.getChannel());

            if (model.isIsDependent()) {
                PrefsHelper.get(baseActivity).putString(Constants.KEY_DEPENDENTS, model.getDependents().toString());
            }

            if (model.getOrganization() != null) {
                PrefsHelper.get(baseActivity).putString(Constants.KEY_ORGANIZATION, model.getOrganization().toString());
                MyApp.get().setOrganization(model.getOrganization());
            }

            if (model.getPolicy() != null) {
                PrefsHelper.get(baseActivity).putString(Constants.KEY_POLICY, model.getPolicy().toString());
            }

            if (baseActivity.getPackageName().contains("patient")) {
                if (!LocalUtils.isThisUserType(model,"DOCTOR")) {
                    PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);

                    if (couponApplied.equals(getString(R.string.bank_alfalah_promo_code))) {
                        getDisposer().add(
                                baseActivity.RXAPI.setPromo(couponApplied)
                                        .subscribe(sent -> {
                                            navController.navigate(R.id.bankAlfalahPaymentSuccessFragment);
                                        }, e -> {
                                            try {
                                                Toasty.error(baseActivity, e.getMessage().replace("\"", ""), Toast.LENGTH_LONG, false).show();
                                            } catch (Exception ignored) {
                                                Toasty.error(baseActivity, "Error! Please try again later. If issue persists contact administrator.", Toast.LENGTH_LONG, false).show();
                                            }
                                        }));
                    } else {
//                        PrefsHelper.setOnPlan(true);
//                        PrefsHelper.setUserPlan(Integer.valueOf(PrefsHelper.get(baseActivity).getString(Constants.KEY_PLAN_ID, "")));
                        navController.navigate(R.id.paymentSuccessfullFragment);
                    }
                    if (!BuildConfig.DEBUG)
                        FirebaseAnalytics.getInstance(baseActivity).setUserProperty(FirebaseEvents.SIGNIN_PROP, String.valueOf(true));
                }
            }

        } else {
            AnalyticsUtils.logEvent(baseActivity, FirebaseEvents.PLAN_PUR_FAILED, null);
            Toasty.error(baseActivity, "Failed to subscribe !", Toast.LENGTH_LONG, false).show();
            firebaseEvent(baseActivity, "subscription_payment_fail");
        }
    }

    private void updateUser() {

        getDisposer().add(
                baseActivity.RXAPI.updateUserProfile(
                        new UserInfoUpdateRequest()
                                .withHistory(true)
                                .withId(NumberUtils.toInt(baseActivity.userData.getId()))
                                .withUserType("patient")
                ).subscribe(userInfo -> {
                    UserDataLogin userLoggedIn = baseActivity.userData;
                    userLoggedIn.setUserType(userInfo.getUserType());
                    if (baseActivity.userData != null) {
                        PrefsHelper.setUserInfo(userLoggedIn);
                    } else {
                        PrefsHelper.get(baseActivity).clear();
                        if (!NavGraphUtils.getMe(navController).isLastDest(R.id.loginFragment)) {
                            Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                            navController.navigate(R.id.action_global_loginFragment);
                        }
                    }
//                    if(userLoggedIn != null) {
//                        PrefsHelper.setUserInfo(userLoggedIn);
//                    }else{
//
//                    }

                    //attemptLogin();
//                    Toast.makeText(baseActivity,"API Called",Toast.LENGTH_LONG).show();
                }, e -> {
                    LogUtils.e(e);
                    if (NetworkUtils.isConnected()) {
                        Toasty.error(baseActivity, R.string.error_message_failed_to_login, Toast.LENGTH_LONG, false).show();
                    } else {
                        Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
                    }
                })
        );
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SCAN_CARD) {
            String resultDisplayStr;
            if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
                CreditCard scanResult = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);

                // Never log a raw card number. Avoid displaying it, but if necessary use getFormattedCardNumber()
                resultDisplayStr = "Card Number: " + scanResult.getFormattedCardNumber() + "\n";

                mCardNumberEditText.setText(scanResult.getFormattedCardNumber());
                year = scanResult.expiryYear;
                year = year % 100;
                month = scanResult.expiryMonth;
                if (month < 10) {
                    mExpiryDateMonth.setSelection(getMonthPos("0" + month));
                } else {
                    mExpiryDateMonth.setSelection(getMonthPos("" + month));

                }
                mExpiryDateYear.setSelection(getYearPos("" + year));


                // Do something with the raw number, e.g.:
                // myService.setCardNumber( scanResult.cardNumber );
                //   Toasty.info(baseActivity,scanResult.getFormattedCardNumber(),Toasty.LENGTH_LONG).show();


            } else {
                resultDisplayStr = "Scan was canceled.";
            }
            // do something with resultDisplayStr, maybe display it in a textView
            // resultTextView.setText(resultDisplayStr);
        }
        // else handle other activity results
    }


    private int getMonthPos(String category) {

        return Arrays.asList((getResources().getStringArray(R.array.months_date))).indexOf(category);

    }

    private int getYearPos(String category) {

        return Arrays.asList((getResources().getStringArray(R.array.years))).indexOf(category);

    }

}
