package com.augmentcare.patient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.adapters.NotificationsRecyclerListAdapter;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.ResponseData;
import com.augmentcare.patient.network.restApi.apimodels.notificationsModels.NotificationResponseModel;
import com.augmentcare.patient.network.restApi.apimodels.notificationsModels.NotificationsItem;
import com.augmentcare.patient.utils.GenApiLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import static android.app.Activity.RESULT_OK;

public class NotificationsFragment extends BaseFragment implements NotificationsRecyclerListAdapter.OnItemClickListener{

    @BindView(R.id.recylerViewNotifications)
    RecyclerView recylerViewNotifications;
    @BindView(R.id.btnClose)
    View btnClose;
    @BindView(R.id.txtCount)
    TextView txtCount;
    @BindView(R.id.txtNoNotifications)
    TextView txtNoNotifications;
    private ArrayList<NotificationsItem> notifications;
    private ArrayList<NotificationsItem> statusArrayList;
    private View view;
    NavController navController;
    NotificationsRecyclerListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_notifications, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        PrefsHelper.setNotificationCount(0);


        navController = Navigation.findNavController(view);
        ((HomeScreenActivity)baseActivity).setToolbarTitle("Notifications");
        recylerViewNotifications.setLayoutManager(new LinearLayoutManager(baseActivity));
//        Intent intent = baseActivity.getIntent();
//        String user_role_id = intent.getStringExtra("user_role_id");
        if (NetworkUtils.isConnected()) {
            getDisposer().add(
                    baseActivity.RXAPI.getNOtifications(MyApp.get().getRole().getId()).subscribe(this::onGetNotifications, LocalUtils::processAPIError)
            );
            getDisposer().add(
                    baseActivity.RXAPI.resetCounter(MyApp.get().getRole().getId()).subscribe(this::onResetCounter, LocalUtils::processAPIError)
            );
            //  getAllNotification(MyApp.get().getRole().getId());
        }
        else{
            Toasty.warning(baseActivity, R.string.error_check_internet, Toast.LENGTH_LONG, false).show();
        }
        btnClose.setOnClickListener(view1 -> baseActivity.onBackPressed());

        GenApiLogger.fireNotificationEvent();
    }
    private void onResetCounter(ResponseData<Void> response) {
        if (response != null && response.isSuccess()){
            baseActivity.setResult(RESULT_OK);
        }
    }
    private void onGetNotifications(NotificationResponseModel response) {
        if (response.getNotifications() != null){
            notifications = new ArrayList<>();
            statusArrayList = new ArrayList<>();
            List<NotificationsItem> notificationsList = response.getNotifications();
            for (int i = 0; i < notificationsList.size(); i++) {
                notifications.add(notificationsList.get(i));
                statusArrayList.add(notificationsList.get(i));
            }
            if (notificationsList.size() > 0) {
                mAdapter = new NotificationsRecyclerListAdapter(notifications, getContext());
                recylerViewNotifications.setAdapter(mAdapter);
                mAdapter.setOnItemClickListener(this);
                mAdapter.notifyDataSetChanged();
            } else {
                txtNoNotifications.setVisibility(View.VISIBLE);
            }
            if (response.getNotificationCounter() != null) {
                int notificationCount = response.getNotificationCounter().getOfflineCounter();
                if (notificationCount != 0) {
                    txtCount.setText(String.valueOf(notificationCount));
                    txtCount.setVisibility(View.VISIBLE);
                    if (notificationCount > 99) {
                        txtCount.setText("99+");
                    }
                } else {
                    txtCount.setVisibility(View.GONE);
                }
            }
        } else {
            txtNoNotifications.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemClick(int position,NotificationsItem item) {
        String notificationType = item.getNotification().getNotificationType();
        if(!notificationType.isEmpty()) {
            switch (notificationType) {
                case "sicknote_created":
                case "prescription_data":
                case "follow_up":
                case "send_prescription":
                    navController.navigate(
                            NotificationsFragmentDirections
                                    .actionNotificationsFragmentToAppointmentDetailsFragment(item.getSlot().getId())
                    );
                    break;
                case "slot_confirmation":
                case "slot_request":
                    navController.navigate(
                            NotificationsFragmentDirections
                                    .actionNotificationsFragmentToConsultationPreviewDialogFragment(item.getSlot().getId()+"")
                                    .setIsFromNotificationFragment(true)
                    );
                    break;
                case "slot_rejection":
                    break;
                case "private_message":
                    navController.navigate(
                            NotificationsFragmentDirections
                                    .actionNotificationsFragmentToChatActivity()
                    );
                    break;
                case "claim_updated":
                case "claim_created":
                    navController.navigate(
                            NotificationsFragmentDirections.actionNotificationsFragmentToMyClaimsFragment()
                    );
                    break;
                case "dependent_added":
                    navController.navigate(
                            NotificationsFragmentDirections.actionNotificationsFragmentToDependentFragment()
                    );
                    break;
            }
        }
    }
}