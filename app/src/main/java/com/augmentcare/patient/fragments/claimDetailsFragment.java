package com.augmentcare.patient.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseFragment;
import com.augmentcare.patient.network.restApi.apimodels.ClaimDetailsModel.ClaimDetailsModel;
import com.augmentcare.patient.network.restApi.apimodels.Message;
import com.augmentcare.patient.network.restApi.apimodels.UserClaims;
import com.augmentcare.patient.utils.FacebookLogger;
import com.augmentcare.patient.utils.FirebaseLogger;
import com.augmentcare.patient.utils.LocalUtils;
import com.augmentcare.patient.utils.PrefsHelper;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class claimDetailsFragment extends BaseFragment implements View.OnClickListener{

    private View rootView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.homeIv)
    ImageView ivHome;
    @BindView(R.id.tvAvailableAllowance)
    TextView tvAvailableAllowance;
    @BindView(R.id.tvStatus)
    TextView tvStatus;
    @BindView(R.id.lytAcceptedAmount)
    LinearLayout lytAcceptedAmount;
    @BindView(R.id.tvClaimFor)
    TextView tvClaimFor;
    @BindView(R.id.accept_amount_title_textview)
    TextView mAcceptAmountTitleTextView;
    @BindView(R.id.tvAcceptAmount)
    TextView mAcceptAmountTextView;
    @BindView(R.id.tvTransactiontype)
    TextView tvTransactiontype;
    @BindView(R.id.tvDateAndTime)
    TextView tvDateAndTime;
    @BindView(R.id.uploaded_files_button)
    RelativeLayout mUploadFileButton;
    @BindView(R.id.rlContentView)
    View contentFrame;

    @BindView(R.id.recylerViewUserClaims)
    RecyclerView recylerViewUserClaims;
    @BindView(R.id.llSendMessage)
    LinearLayout llSendMessage;
    @BindView(R.id.etMessage)
    EditText etMessage;

    private UserClaims.ReimbursementsEntity reimbursementsEntity;
    public ClaimDetailsModel claimDetail;
    private ClaimMessageAdapter claimMessageAdapter;
    private ArrayList<Message> messagesEntityArrayList;

    public claimDetailsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //rootView = inflater.inflate(R.layout.fragment_claim_details, container, false);
        rootView = inflater.inflate(R.layout.fragment_claim_details_new, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        loadArguments();
        initMe();
    }

    public void initMe(){
        chatSettings();
        toolbar.setNavigationOnClickListener(v -> {
            baseActivity.onBackPressed();
        });

        ivHome.setOnClickListener(view -> {
            safeNavigateTo(navController->{
                navController.navigate(R.id.dashboardFragment);
            });
        });

        String status = reimbursementsEntity.getStatus();

        if(!(status.isEmpty()) && status.contains("_")){
            status = status.replace("_", " ");
        }

        if (!reimbursementsEntity.getStatus().isEmpty() && reimbursementsEntity.getStatus().equals("partial")){
            lytAcceptedAmount.setVisibility(View.VISIBLE);
            //mAcceptAmountTitleTextView.setVisibility(View.VISIBLE);
            //mAcceptAmountTextView.setVisibility(View.VISIBLE);
            mAcceptAmountTextView.setText(String.valueOf(reimbursementsEntity.getFinalAmount()));
        }

        if(status.equalsIgnoreCase("pending") || status.equalsIgnoreCase("disputed")){
            tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_pending));
        }
        else if(status.equalsIgnoreCase("accepted") || status.equalsIgnoreCase("partial")){
            tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_approved));
        }
        else if(status.equalsIgnoreCase("rejected")){
            tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_rejected));
        }
        else if(status.equalsIgnoreCase("in progress")){
            tvStatus.setTextColor(ContextCompat.getColor(Utils.getApp(), R.color.color_claim_item_amount));
        }

        tvStatus.setText("" + status.toUpperCase());
        if (reimbursementsEntity.getTime() != null){
            //String dateTime = TextUtils.formatDateAndTimeForFileAClaim(TextUtils.parseTimeLocal(reimbursementsEntity.getTime()));
            String date_time = reimbursementsEntity.getTime();
            date_time = convertFormat(date_time,"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'","yyyy-MM-dd HH:mm a");
            tvDateAndTime.setText(date_time);
        }
        String transactionType = reimbursementsEntity.getTransactionType();
        if (!(transactionType.isEmpty()) && transactionType.contains("_")) {
            transactionType = transactionType.replace("_", " ");
        }
        tvTransactiontype.setText(transactionType);
        tvAvailableAllowance.setText("" + reimbursementsEntity.getAmount());

        if (reimbursementsEntity.getTransactionFor() == null) {
            tvClaimFor.setText( PrefsHelper.getUserInfo().getFirstName() + " " + PrefsHelper.getUserInfo().getLastName());
        }
        else{
            tvClaimFor.setText( reimbursementsEntity.getTransactionFor());
        }

        try{
            if (PrefsHelper.getUserInfo().getId() != null && !PrefsHelper.getUserInfo().getId().isEmpty())
                FirebaseLogger.viewFirebaseLogEvent("claim_start_conversation", PrefsHelper.getUserInfo().getId());
        }
        catch(Exception ignored){}

        mUploadFileButton.setOnClickListener(this);
    }

    private String convertFormat(String date,String currentFormat,String expectedFormat){
        return TimeUtils.date2String(TimeUtils.string2Date(date,currentFormat), expectedFormat);
    }

    public void chatSettings(){
        getClaimsApiCall();

        llSendMessage.setOnClickListener(v -> {
            if(!etMessage.getText().toString().isEmpty()) {
                sendClaimMesageApiCall();
            }
        });

        try{
            FacebookLogger.viewControllerLogEvent("claim_start_conversation", "claim_start_conversation", "ViewContent", "0", "");
        }catch(Exception e){}
    }

    public void getClaimsApiCall() {
        getDisposer().add(
                baseActivity.RXAPI.getClaimDetails(reimbursementsEntity.getClaimUid()).subscribe(this::getClaimDetails, LocalUtils::processAPIError)
        );
        try{
            FacebookLogger.viewControllerLogEvent("claim_start_conversation", "claim_start_conversation", "ViewContent", "0", "");
        }catch(Exception e){}
    }

    private void getClaimDetails(ClaimDetailsModel claimDetails) {
        if (claimDetails.getSuccess()) {
            claimDetail = claimDetails;
            if (claimDetail.getData() != null){
                messagesEntityArrayList = new ArrayList<>();
                messagesEntityArrayList.addAll(claimDetail.getData().getMessages());
                claimMessageAdapter = new ClaimMessageAdapter(messagesEntityArrayList);
                recylerViewUserClaims.setLayoutManager(new LinearLayoutManager(getContext()));
                recylerViewUserClaims.setAdapter(claimMessageAdapter);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void loadArguments(){
        Bundle b = getArguments();
        reimbursementsEntity = (UserClaims.ReimbursementsEntity) b.getSerializable("data");
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.uploaded_files_button:
                Bundle b = new Bundle();
                b.putParcelable("cartDetails",claimDetail);
                safeNavigateTo(navController -> {
                    navController.navigate(R.id.uploadClaimsImages,b);
                });
                break;
        }
    }

    public void sendClaimMesageApiCall() {
        getDisposer().add(
                baseActivity.RXAPI.sendClaimMessage(claimDetail.getData().getClaim().getId()+"" , etMessage.getText().toString())
                        .subscribe(
                                this::OnSendClaimMessage,
                                LocalUtils::processAPIError
                        )
        );
    }

    private void OnSendClaimMessage(Message message){
        if(message.getMessage()!=null && !message.getMessage().equals("")){
            recylerViewUserClaims.scrollToPosition(messagesEntityArrayList.size());
            etMessage.setText("");
            messagesEntityArrayList.add(message);
            recylerViewUserClaims.setAdapter(claimMessageAdapter);
            claimMessageAdapter.notifyDataSetChanged();
        }
    }

    public class ClaimMessageAdapter extends RecyclerView.Adapter {
        private static final int VIEW_TYPE_MESSAGE_SENT = 1;
        private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
        private ArrayList<Message> data;

        public ClaimMessageAdapter(ArrayList<Message> data) {
            this.data = data;
        }
        // Determines the appropriate ViewType according to the sender of the message.
        @Override
        public int getItemViewType(int position) {
            Message message = data.get(position);
            if (message.getUserId() == (PrefsHelper.getUserInfo().getUserId())) {
                // If the current user is the sender of the message
                return VIEW_TYPE_MESSAGE_SENT;
            } else {
                // If some other user sent the message
                return VIEW_TYPE_MESSAGE_RECEIVED;
            }
        }

        // Inflates the appropriate layout according to the ViewType.
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == VIEW_TYPE_MESSAGE_SENT) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_claim_message, parent, false);
                return new SentMessageHolder(view);
            } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other_user_claim_message, parent, false);
                return new ReceivedMessageHolder(view);
            }

            return null;
        }

        // Passes the message object to a ViewHolder so that the contents can be bound to UI.
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Message message = data.get(position);
            switch (holder.getItemViewType()) {
                case VIEW_TYPE_MESSAGE_SENT:
                    ((SentMessageHolder) holder).bind(message);
                    break;
                case VIEW_TYPE_MESSAGE_RECEIVED:
                    ((ReceivedMessageHolder) holder).bind(message);
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        private class SentMessageHolder extends RecyclerView.ViewHolder {
            TextView messageText, nameText;
            ImageView profileImage;

            SentMessageHolder(View itemView) {
                super(itemView);
                messageText = itemView.findViewById(R.id.text_message_body);
                nameText = itemView.findViewById(R.id.text_message_name);
                profileImage = itemView.findViewById(R.id.image_message_profile);
            }

            void bind(Message message) {
                messageText.setText(message.getMessage());
                nameText.setText(claimDetail.getData().getUserName().toUpperCase());
                String myPhoto = PrefsHelper.getUserInfo().getPhoto();
                if (myPhoto != null && !myPhoto.isEmpty())
                    Glide.with(claimDetailsFragment.this)
                            .load(myPhoto)
                            .apply(RequestOptions.circleCropTransform())
                            .error(R.drawable.profile_placeholder)
                            .placeholder(R.drawable.profile_placeholder)
                            .into(profileImage);
                else
                    Glide.with(Utils.getApp())
                            .load(R.drawable.ic_user)
                            .error(R.drawable.profile_placeholder)
                            .placeholder(R.drawable.profile_placeholder)
                            .into(profileImage);
            }
        }

        private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
            TextView messageText, nameText;
            ImageView profileImage;

            ReceivedMessageHolder(View itemView) {
                super(itemView);
                messageText = itemView.findViewById(R.id.text_message_body);
                nameText = itemView.findViewById(R.id.text_message_name);
                profileImage = itemView.findViewById(R.id.image_message_profile);
            }

            void bind(Message message){
                messageText.setText(message.getMessage());
                String userName = claimDetail.getData().getOtherUser().getFirstName() + " " + claimDetail.getData().getOtherUser().getLastName();
                nameText.setText((userName.toUpperCase()));
                if (claimDetail.getData().getOtherUser().getPhoto() != null && !claimDetail.getData().getOtherUser().getPhoto().isEmpty())
                    Glide.with(claimDetailsFragment.this)
                            .load(claimDetail.getData().getOtherUser().getPhoto())
                            .apply(RequestOptions.circleCropTransform())
                            .error(R.drawable.profile_placeholder)
                            .placeholder(R.drawable.profile_placeholder)
                            .into(profileImage);
                else
                    Glide.with(Utils.getApp())
                            .load(R.drawable.ic_user)
                            .error(R.drawable.profile_placeholder)
                            .placeholder(R.drawable.profile_placeholder)
                            .into(profileImage);
            }
        }
    }
}