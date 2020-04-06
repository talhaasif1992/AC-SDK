package com.augmentcare.patient.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.augmentcare.patient.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AvailableTimingSlotAdapter extends RecyclerView.Adapter<AvailableTimingSlotAdapter.ViewHolder>{
    private List<String> availableSlotList;
    private Context context;
    private OnItemClickListener mlistener;

    public interface OnItemClickListener{
        void onItemClick(TextView v, RecyclerView.Adapter adapter, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener = listener;
    }

    private String shiftType; // 0 - morning , 1 - afternoon, 2 - evening

    private int lastSelectedPos = -1;

    public String getShiftType() {
        return shiftType;
    }

    public void setLastSelectedPos(int lastSelectedPos) {
        this.lastSelectedPos = lastSelectedPos;
    }

    public AvailableTimingSlotAdapter(List<String> availableSlotList, Context context,String shiftType){
        this.availableSlotList = availableSlotList;
        this.context = context;
        this.shiftType = shiftType;
    }

    public void setAvailableSlotList(List<String> availableSlotList) {
        this.availableSlotList = availableSlotList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView slotTime;

        public ViewHolder(View itemView){
            super(itemView);

            slotTime = itemView.findViewById(R.id.time_slot_item);

            itemView.setOnClickListener(v -> {
                if(mlistener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        mlistener.onItemClick(slotTime, AvailableTimingSlotAdapter.this,position);
                        setUpSelectedItem(position);
                    }
                }
            });
        }
    }

    private void setUpSelectedItem(int selectedPos){
        lastSelectedPos = selectedPos;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public AvailableTimingSlotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_timing_slots, parent, false);
        ViewHolder vh = new AvailableTimingSlotAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try{
            final String currentItem = availableSlotList.get(position);
            holder.slotTime.setText(currentItem);

            if(lastSelectedPos == position){
                holder.slotTime.setBackground(ContextCompat.getDrawable(context, R.drawable.selected_slot_background));
                holder.slotTime.setTextColor((Color.parseColor("#FFFFFF")));
            }else{
                holder.slotTime.setBackground(ContextCompat.getDrawable(context, R.drawable.border_gray));
                holder.slotTime.setTextColor(Color.parseColor("#a9a9a9"));
            }

        }
        catch (Exception ignored) { }
    }

    @Override
    public int getItemCount() {
        return availableSlotList.size();
    }

    public void clearAdapter(){
        availableSlotList.clear();
        notifyDataSetChanged();
    }
}