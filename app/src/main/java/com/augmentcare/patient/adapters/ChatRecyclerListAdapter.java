package com.augmentcare.patient.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.model.ChatLine;
import com.augmentcare.patient.model.Doctor;
import com.augmentcare.patient.utils.TextUtils;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * {@link ChatRecyclerListAdapter} that can display a {@link Doctor} and makes a call to the
 * specified {@link OnRecyclerItemClickListener}.
 */
public class ChatRecyclerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ChatLine> mValues;
    private final OnRecyclerItemClickListener<ChatLine> mListener;
    private String myName;
    private String otherName;
    private String roleId;
    private ViewGroup parent;

    public ChatRecyclerListAdapter(List<ChatLine> items, String myName, String otherName, OnRecyclerItemClickListener<ChatLine> listener) {
        mValues = items;
        mListener = listener;
        this.myName = myName;
        this.otherName = otherName;
        roleId = MyApp.get().getRole().getId() + "";
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.parent = parent;
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_mine, parent, false);
            return new ChatRecyclerListAdapter.ViewHolderMine(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_other, parent, false);
            return new ChatRecyclerListAdapter.ViewHolderMine(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //if(getItemViewType(position) == 0) {
        final ViewHolderMine viewHolderMine;
        //if(holder instanceof ViewHolderMine)
        viewHolderMine = (ViewHolderMine) holder;
        //else
        //viewHolderMine = (ViewHolderMine) createViewHolder(parent,getItemViewType(position));
        holder = viewHolderMine;
        if (getItemViewType(position) == 0) {
            viewHolderMine.tvName.setText("me");
        } else {
            viewHolderMine.tvName.setText(otherName);
        }
        if (mValues.get(position).getMessage_type().equals("text")) {
            viewHolderMine.tvMessage.setVisibility(View.VISIBLE);
            viewHolderMine.ivAttachment.setVisibility(View.GONE);
            viewHolderMine.tvMessage.setText(mValues.get(position).getChat_text());
        } else {
            viewHolderMine.tvMessage.setVisibility(View.GONE);
            viewHolderMine.ivAttachment.setVisibility(View.VISIBLE);

            Glide.with(viewHolderMine.ivAttachment.getContext())
                    .load(mValues.get(position).getChat_text())
                    .error(R.drawable.profile_placeholder)
                    .placeholder(R.drawable.profile_placeholder)
                    .into(viewHolderMine.ivAttachment);

        }
        if(mValues.get(position).getCreated_at()!=null)
            viewHolderMine.tvDateAndTime.setText(TextUtils.formatDateAndTime(TextUtils.parseTime( mValues.get(position).getCreated_at())));
        viewHolderMine.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemClick(viewHolderMine.mItem,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mValues.get(position).getUser_role_id().equals(roleId) ? 0 : 1;
        //return 0;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public class ViewHolderMine extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvName;
        public final TextView tvMessage;
        public final TextView tvDateAndTime;
        public final ImageView ivTick;
        public final ImageView ivAttachment;
        public ChatLine mItem;


        public ViewHolderMine(View view) {
            super(view);
            mView = view;
            tvName = view.findViewById(R.id.tvName);
            tvMessage = view.findViewById(R.id.tvMessage);
            tvDateAndTime = view.findViewById(R.id.tvDateAndTime);
            ivTick = view.findViewById(R.id.ivTick);
            ivAttachment = view.findViewById(R.id.ivAttachment);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.getChat_text() + "'";
        }
    }

    public class ViewHolderOthers extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvName;
        public final TextView tvMessage;
        public final TextView tvDateAndTime;
        public final ImageView ivAttachment;
        public ChatLine mItem;


        public ViewHolderOthers(View view) {
            super(view);
            mView = view;
            tvName = view.findViewById(R.id.tvName);
            tvMessage = view.findViewById(R.id.tvMessage);
            tvDateAndTime = view.findViewById(R.id.tvDateAndTime);
            //ivTick = (ImageView) view.findViewById(R.id.ivTick);
            ivAttachment = view.findViewById(R.id.ivAttachment);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.getChat_text() + "'";
        }
    }
}
