package com.augmentcare.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.notificationsModels.NotificationObject;
import com.augmentcare.patient.network.restApi.apimodels.notificationsModels.NotificationsItem;
import com.blankj.utilcode.util.StringUtils;

import java.util.List;

public class NotificationsRecyclerListAdapter extends RecyclerView.Adapter<NotificationsRecyclerListAdapter.ViewHolder> {

    private final List<NotificationsItem> mValues;
    private Context context;

    private OnItemClickListener mlistener;

    public interface OnItemClickListener {
        void onItemClick(int position, NotificationsItem item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mlistener = listener;
    }

    public NotificationsRecyclerListAdapter(List<NotificationsItem> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationsRecyclerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new NotificationsRecyclerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        String notificationType;
        String notifyText;
        NotificationObject notificationObj;

        holder.mItem = mValues.get(position);

        if (holder.mItem != null) {
            notificationType = holder.mItem.getNotification().getNotificationType();
            notificationObj = holder.mItem.getNotification().getNotificationObject();
            notifyText = holder.mItem.getNotification().getNotifyText();


            if (!notificationType.isEmpty()) {
                switch (notificationType) {
                    case "sicknote_created":
                        holder.ivIcon.setImageResource(R.drawable.ic_pill);
                        holder.txtTime.setText(notificationObj.getDay());

                        if (!notifyText.isEmpty())
                            holder.txtDescription.setText(notifyText);
                        break;

                    case "slot_confirmation":
                        holder.ivIcon.setImageResource(R.drawable.ic_type_aapointment);
                        holder.txtTime.setText(notificationObj.getDay());

                        if (!notifyText.isEmpty())
                            holder.txtDescription.setText(notifyText);
                        break;

                    case "prescription_data":
                        String description = notificationObj.getFirstName() + " " + notificationObj.getLastName()
                                + " has sent you Notes & Prescription";
                        holder.txtDescription.setText(description);
                        holder.ivIcon.setImageResource(R.drawable.ic_prescriptions);
                        holder.txtTime.setText(notificationObj.getDay());
                        break;

                    case "slot_rejection":
                    case "slot_request":
                        holder.ivIcon.setImageResource(R.drawable.ic_type_aapointment);
                        holder.txtTime.setText(notificationObj.getDay());

                        if (!notifyText.isEmpty())
                            holder.txtDescription.setText(notifyText);
                        else
                            holder.txtDescription.setText("");

                        break;

                    case "private_message":
                        holder.ivIcon.setImageResource(R.drawable.ic_chat_green);
                        String description2 = notificationObj.getFirstName() + " " +
                                notificationObj.getLastName() + " sent you a private message";
                        holder.txtDescription.setText(description2);
                        holder.txtTime.setText(notificationObj.getDay());
                        break;

                    case "claim_created":
                        holder.ivIcon.setImageResource(R.drawable.ic_claim);
                        holder.txtTime.setText(holder.mItem.getNotification().getNotificationObject().getDay());

                        if (!notificationObj.getName().isEmpty() && !notificationObj.getClaimType().isEmpty()) {
                            String description3 = notificationObj.getName() + "has submitted a " +
                                    notificationObj.getClaimType() + " claim";
                            holder.txtDescription.setText(description3);
                        } else
                            holder.txtDescription.setText("");
                        break;

                    case "claim_updated":
                        holder.ivIcon.setImageResource(R.drawable.ic_claim);
                        holder.txtTime.setText(notificationObj.getDay());

                        if (notificationObj.getName() != null && notificationObj.getClaimType() != null) {
                            String description4 = notificationObj.getName() + "has updated a " + notificationObj.getClaimType() + " claim";
                            holder.txtDescription.setText(description4);
                        } else
                            holder.txtDescription.setText("");
                        break;

                    case "dependent_added":
                        holder.ivIcon.setImageResource(R.drawable.ic_claim);
                        holder.txtTime.setText(notificationObj.getDay());

                        if (notificationObj.getName() != null) {
                            String description5 = notificationObj.getName() + "has added a dependent";
                            holder.txtDescription.setText(description5);
                        } else
                            holder.txtDescription.setText("");
                        break;

                    case "follow_up":
                        holder.ivIcon.setImageResource(R.drawable.ic_claim);
                        holder.txtTime.setText(notificationObj.getDay());

                        if (!notifyText.isEmpty())
                            holder.txtDescription.setText(notifyText);
                        else
                            holder.txtDescription.setText("");
                        break;

                    case "send_prescription":
                        holder.ivIcon.setImageResource(R.drawable.ic_prescriptions);
                        holder.txtTime.setText(notificationObj.getDay());

                        if (!notifyText.isEmpty())
                            holder.txtDescription.setText(notifyText);
                        else
                            holder.txtDescription.setText("");

                        break;

                    case "order_created":
                        holder.ivIcon.setImageResource(R.drawable.ic_order_lab_tests);
                        holder.txtTime.setText(holder.mItem.getNotification().getNotificationObject().getDay());

                        if (!holder.mItem.getNotification().getNotifyText().equals("") && holder.mItem != null)
                            holder.txtDescription.setText(holder.mItem.getNotification().getNotifyText());
                        else
                            holder.txtDescription.setText(R.string.lab_order_created);
                        break;

                    case "blood_sample_collected":
                        holder.ivIcon.setImageResource(R.drawable.ic_order_lab_tests);
                        holder.txtTime.setText(holder.mItem.getNotification().getNotificationObject().getDay());

                        if (!holder.mItem.getNotification().getNotifyText().equals("") && holder.mItem != null)
                            holder.txtDescription.setText(holder.mItem.getNotification().getNotifyText());
                        else
                            holder.txtDescription.setText(R.string.lab_sample_collected);
                        break;

                    case "lab_reports_available":
                        holder.ivIcon.setImageResource(R.drawable.ic_order_lab_tests);
                        holder.txtTime.setText(holder.mItem.getNotification().getNotificationObject().getDay());

                        if (!StringUtils.isEmpty(holder.mItem.getNotification().getNotifyText()) && holder.mItem != null)
                            holder.txtDescription.setText(holder.mItem.getNotification().getNotifyText());
                        else
                            holder.txtDescription.setText(R.string.lab_reports_available);
                        break;
                    default:
                        holder.ivIcon.setImageResource(R.drawable.ic_check_description);
                        holder.txtTime.setText(holder.mItem.getNotification().getNotificationObject().getDay());

                        if (!holder.mItem.getNotification().getNotifyText().equals("") && holder.mItem != null)
                            holder.txtDescription.setText(holder.mItem.getNotification().getNotifyText());
                        else
                            holder.txtDescription.setText("");
                        break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        final TextView txtDescription;
        public final TextView txtTime;
        public final ImageView ivIcon;
        public NotificationsItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtDescription = view.findViewById(R.id.txtDescription);
            txtTime = view.findViewById(R.id.txtTime);
            ivIcon = view.findViewById(R.id.ivIcon);

            view.setOnClickListener(v -> {
                if (mlistener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mlistener.onItemClick(position, mItem);
                    }
                }
            });
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + "";
        }
    }
}