package com.augmentcare.patient.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.augmentcare.patient.R;

import java.util.List;

import com.augmentcare.patient.bottomsheets.AppointmentTypesBottomSheet;
import com.augmentcare.patient.network.restApi.apimodels.MedicalPractice;

import org.jetbrains.annotations.NotNull;

public class AppointmentTypeAdapter extends RecyclerView.Adapter<AppointmentTypeAdapter.ViewHolder>
{
    private List<MedicalPractice> medicalPracticeList;
    private Context context;
    private OnItemClickListener mlistener;

    public interface OnItemClickListener{ void onRadioButtonClick(String medicalPracticeName, int medicalPracticeId); }
    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener = listener;
    }

    public AppointmentTypeAdapter(List<MedicalPractice> medicalPracticeList, Context context){
        this.medicalPracticeList = medicalPracticeList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public RadioButton mSlotLocationRadioButton;

        public ViewHolder(View itemView){
            super(itemView);
            mSlotLocationRadioButton = itemView.findViewById(R.id.location_radio_button);

            mSlotLocationRadioButton.setOnCheckedChangeListener((compoundButton, b) -> {
                if(mlistener != null){
                    mlistener.onRadioButtonClick(medicalPracticeList.get(getAdapterPosition()).getName(), medicalPracticeList.get(getAdapterPosition()).getId());
                }
            });
        }
    }

    @NotNull
    @Override
    public AppointmentTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_slot_location, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AppointmentTypeAdapter.ViewHolder holder, int position){
        holder.mSlotLocationRadioButton.setText(medicalPracticeList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return medicalPracticeList.size();
    }
}