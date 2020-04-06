package com.augmentcare.patient.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.Interface.OnRecyclerItemClickListener;
import com.augmentcare.patient.model.AAdress;
import com.augmentcare.patient.model.Doctor;

import java.util.List;

/**
 * {@link AddressesRecyclerListAdapter} that can display a {@link Doctor} and makes a call to the
 * specified {@link OnRecyclerItemClickListener}.
 */
public class AddressesRecyclerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<AAdress> mValues;
    private final OnRecyclerItemClickListener<AAdress> mListener;

    private ViewGroup parent;
    private int selectedIndex = -1;

    public AddressesRecyclerListAdapter(List<AAdress> items, OnRecyclerItemClickListener<AAdress> listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.parent = parent;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_address, parent, false);
        return new ViewHolderMine(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //if(getItemViewType(position) == 0) {
        final ViewHolderMine viewHolderMine;
        //if(holder instanceof ViewHolderMine)
        viewHolderMine = (ViewHolderMine) holder;
        viewHolderMine.mItem = mValues.get(position);
        viewHolderMine.txtDesctiption.setText(mValues.get(position).getFullAddress());
        viewHolderMine.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemClick(viewHolderMine.mItem, position);
                    selectedIndex = position;

                }
            }
        });

        if (position == selectedIndex) {
            viewHolderMine.vSelection.setBackgroundResource(R.drawable.dot_selected);
        } else {
            viewHolderMine.vSelection.setBackgroundResource(R.drawable.dot_simple);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolderMine extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtDesctiption;
        public final View vSelection;
        public AAdress mItem;


        public ViewHolderMine(View view) {
            super(view);
            mView = view.findViewById(R.id.root_view);
            txtDesctiption = view.findViewById(android.R.id.text1);
            vSelection = view.findViewById(R.id.vSelection);

        }

    }

    public void setSelectedIndex(int index) {
        selectedIndex = index;
    }

}
