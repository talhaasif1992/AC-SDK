package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.BuildConfig;
import com.augmentcare.patient.Interface.ClickItemInterface;
import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.card_model.CardAdapter;
import com.augmentcare.patient.network.restApi.apimodels.CreditCard;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.augmentcare.patient.network.restApi.apimodels.UserInfoUpdateRequest;
import com.augmentcare.patient.network.restApi.apimodels.UserLogin;
import com.augmentcare.patient.utils.AdjustSDKUtils;
import com.augmentcare.patient.utils.AnalyticsUtils;
import com.augmentcare.patient.utils.Constants;
import com.augmentcare.patient.utils.FirebaseEvents;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.NavGraphUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.Stripe;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import static com.augmentcare.patient.notifications.NotificationHelper.firebaseEvent;

public class SubscriptionPaymentFragment extends BaseFragment implements ClickItemInterface{

    private View rootView;
    String name, currency;
    int price;
    String plan_id;
    TextView packageNameTV, priceTV, currencyTV;
    Button buttonPrice;
    Stripe stripe;
    ImageView editBtn;

    @BindView(R.id.lyt_creditCard_btn)
    LinearLayout lytCreditCardBtn;
    @BindView(R.id.lyt_jazzCash_btn)
    LinearLayout lytJazzCashBtn;

    NavController navController;
    CardView creditCardBtn, jazzCashBtn;
    List<CreditCard> cardListAPI;
    String cardSelect;

    RecyclerView cards_list_rv;
    CardAdapter cardAdapter;
    View empty_space;

    // #TODO need to merge coupon code with subscription based payments also!!!!
    private String couponCode = "";

    public SubscriptionPaymentFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_subscription_payment_fragement, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        getPatientCardsApiCall();
        super.onResume();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((HomeScreenActivity) baseActivity).setToolbarTitle("Subscription Payment");
        initMe(view);

        navController = Navigation.findNavController(baseActivity, R.id.nav_host_fragment);

        Bundle b = getArguments();
        if (b != null) {
            plan_id = b.getString("plan_id");
        }

        stripe = new Stripe(baseActivity, BuildConfig.STRIPE_KEY);

        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.getString("name", null);
            currency = bundle.getString("currency", null);
            price = (int) bundle.getDouble("price", 0.0);
        }

        packageNameTV.setText(name);
        priceTV.setText("" + price);
        currencyTV.setText("- " + currency);
        buttonPrice.setText("Pay PKR " + price);

        getCreditCardBinNumbers();
        getPatientCardsApiCall();

        buttonPrice.setOnClickListener(v ->{
            if (cardSelect != null) {
                processPaymentAPI(cardSelect, couponCode);
            } else {
                Toast.makeText(baseActivity, "Please select code", Toast.LENGTH_LONG).show();
            }
        });

        view.findViewById(R.id.cl_btn_add_a_payment_method).setOnClickListener(v -> {
            Bundle b1 = new Bundle();
            b1.putString("add_payment_via", "subscription");
            b1.putString("plan_id",plan_id);
            navController.navigate(R.id.cardSelectionDialogue, b1);
        });

        view.findViewById(R.id.editBtn).setOnClickListener(v -> navController.popBackStack());

        creditCardBtn.setOnClickListener(v -> {
            lytCreditCardBtn.setBackgroundResource(R.drawable.plans_bg_border);
            lytJazzCashBtn.setBackgroundResource(0);
            cards_list_rv.setVisibility(View.VISIBLE);
        });

//        jazzCashBtn.setOnClickListener(v -> {
//            lytJazzCashBtn.setBackgroundResource(R.drawable.plans_bg_border);
//            lytCreditCardBtn.setBackgroundResource(0);
//            cards_list_rv.setVisibility(View.INVISIBLE);
//            Bundle b1 = new Bundle();
//            b1.putInt("plan_id", Integer.parseInt(plan_id));
//            navController.navigate(R.id.enterJazzCashNumberFragment, b1);


//                getDisposer().add(
//                        baseActivity.RXAPI.setPromo("green-clinics")
//                                .subscribe(sent -> {
//                                  //  afterPaymentProcess(sent);
//
//                                    Toast.makeText(baseActivity,""+sent,Toast.LENGTH_LONG).show();
//
//                                }, e -> {
//                                    try {
//                                        Toasty.error(baseActivity, e.getMessage().replace("\"", ""), Toast.LENGTH_LONG, false).show();
//                                    } catch (Exception ignored) {
//                                        Toasty.error(baseActivity, "Error! Please try again later. If issue persists contact administrator.", Toast.LENGTH_LONG, false).show();
//                                    }
//                                })
//                );


//        });
    }

    private void processPaymentAPI(String token, String couponCode) {
        AnalyticsUtils.logEvent(baseActivity, FirebaseEvents.PLAN_CARD_ENTERED, null);
        getDisposer().add(
                baseActivity.RXAPI.purchasePlan(token, plan_id, couponCode)
                        .subscribe(this::afterPaymentProcess, e -> {
                            try {
                                Toasty.error(baseActivity, e.getMessage().replace("\"", ""), Toast.LENGTH_LONG, false).show();
                            } catch (Exception ignored) {
                                Toasty.error(baseActivity, "Error! Please try again later. If issue persists contact administrator.", Toast.LENGTH_LONG, false).show();
                            }


                        })
        );
    }

    private void afterPaymentProcess(UserLogin model) {
        if (model.getRoles().size() > 0) {
            AnalyticsUtils.logEvent(baseActivity, FirebaseEvents.PLAN_PURCHASED, null);
            firebaseEvent(baseActivity,"subscription_buy_plan");
            firebaseEvent(baseActivity,name);
            AdjustSDKUtils.adjustRevenueEvent(getString(R.string.adjust_subscription_purchased), price);


            if (model.isIsOnPlan()) {
                MyApp.isReloadConsultations = true;
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_ON_PLAN, model.isIsOnPlan());
            } else {
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_ON_PLAN, false);
            }

            if (model.isFromOrganization()) {
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_FROM_ORGANIZATION, model.isFromOrganization());
            } else {
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_FROM_ORGANIZATION, false);
            }

            if (LocalUtils.isThisUserType("HR")) {
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
//                com.augmentcare.patient.network.restApi.apimodels.Organization org = GsonUtils.getGson().fromJson(dataObject.get(Constants.KEY_ORGANIZATION).getAsJsonObject(),
//                        Organization.class);
                MyApp.get().setOrganization(model.getOrganization());
            }

            if (model.getPolicy() != null) {
                PrefsHelper.get(baseActivity).putString(Constants.KEY_POLICY, model.getPolicy().toString());
            }

            if (LocalUtils.isThisUserType("PATIENT")) {
                PrefsHelper.get(baseActivity).putBoolean(Constants.KEY_IS_LOGIN, true);

                if (couponCode.equals(getString(R.string.bank_alfalah_promo_code))) {
                    getDisposer().add(
                            baseActivity.RXAPI.setPromo(couponCode)
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
                    updateUser();
                    PrefsHelper.setUserPlan(plan_id);
                    PrefsHelper.setOnPlan(true);
                    navController.navigate(R.id.paymentSuccessfullFragment);
                }
                if (!BuildConfig.DEBUG)
                    FirebaseAnalytics.getInstance(baseActivity).setUserProperty(FirebaseEvents.SIGNIN_PROP, String.valueOf(true));
            }


        }else{
            AnalyticsUtils.logEvent(baseActivity, FirebaseEvents.PLAN_PUR_FAILED, null);
            Toasty.error(baseActivity, "Failed to subscribe !", Toast.LENGTH_LONG, false).show();
            firebaseEvent(baseActivity,"subscription_payment_fail");
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
                    if(baseActivity.userData!=null) {
                        PrefsHelper.setUserInfo(userLoggedIn);
                    }
                    else{
                        PrefsHelper.get(baseActivity).clear();
                        if(!NavGraphUtils.getMe(navController).isLastDest(R.id.loginFragment)) {
                            Toasty.error(Utils.getApp(), "Something went wrong please login in again...").show();
                            navController.navigate(R.id.action_global_loginFragment);
                        }
                    }

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

    private void initMe(View view){
        packageNameTV = view.findViewById(R.id.packageNameTV);
        priceTV = view.findViewById(R.id.priceTV);
        currencyTV = view.findViewById(R.id.currencyTV);
        buttonPrice = view.findViewById(R.id.buttonPrice);
        creditCardBtn = view.findViewById(R.id.creditCardBtn);
        jazzCashBtn = view.findViewById(R.id.jazzCashBtn);
        cards_list_rv = view.findViewById(R.id.cards_list_rv);
        editBtn = view.findViewById(R.id.editBtn);
        empty_space = view.findViewById(R.id.empty_space1);
    }

    private void getCreditCardBinNumbers(){
        if (MyApp.get().getCreditCardBinNumbers() == null || MyApp.get().getCreditCardBinNumbers().size() <= 0) {
            getDisposer().add(
                    baseActivity.RXAPI.getBindNumbersForAlfalahClients()
                            .subscribe(this::onGetBindNumbersForAlfalahClients, LocalUtils::processAPIError)
            );
        }
    }

    private void onGetBindNumbersForAlfalahClients(List<String> strings){
        ArrayList<String> creditCardBinNumbers = new ArrayList<>();
        if (strings != null) {
            creditCardBinNumbers.addAll(strings);
            MyApp.get().setCreditCardBinNumbers(creditCardBinNumbers);
        }
    }

    private void getPatientCardsApiCall(){
        getDisposer().add(
                baseActivity.RXAPI.getUserCards()
                        .subscribe(this::onGotCreditCards, LocalUtils::processAPIError)
        );
    }

    private void onGotCreditCards(List<CreditCard> cardList){
        try {
            cardListAPI = cardList;

            if (cardList.size() > 0) {
                empty_space.setVisibility(View.GONE);
                cardAdapter = new CardAdapter(cardList, baseActivity, this, 1);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(baseActivity);
                cards_list_rv.setHasFixedSize(true);
                cards_list_rv.setLayoutManager(mLayoutManager);
                cards_list_rv.setAdapter(cardAdapter);
                cards_list_rv.setVisibility(View.VISIBLE);
                //     txtNoPreviousCards.setVisibility(View.GONE);
            } else {
                empty_space.setVisibility(View.VISIBLE);

                cards_list_rv.setVisibility(View.GONE);
                //   txtNoPreviousCards.setVisibility(View.VISIBLE);
            }

        }catch(Exception ignored){}
    }

    @Override
    public void addClickItem(String id, String description, String type) {
        cardSelect = id;
    }

    @Override
    public void deleteItem(String Id){}
}