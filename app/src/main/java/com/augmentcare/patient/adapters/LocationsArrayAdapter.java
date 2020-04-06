package com.augmentcare.patient.adapters;

import android.content.Context;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.augmentcare.patient.model.TimeSlot;

import java.util.List;

/**
 * Created by Qamar Ul Zaman on 10/10/2017.
 */

public class LocationsArrayAdapter extends ArrayAdapter<TimeSlot> {
    int resId;
    public LocationsArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<TimeSlot> objects) {
        super(context, resource, objects);
        resId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = null;
        if (convertView == null) {
            textView = (TextView) LayoutInflater.from(getContext()).inflate(resId,null);
        } else{
            textView = (TextView) convertView;
        }
        textView.setText(getItem(position).toString());
        return textView;
    }
}
