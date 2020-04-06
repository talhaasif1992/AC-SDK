package com.augmentcare.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.network.restApi.apimodels.Dependent;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class DependentGridAdapter extends BaseAdapter {
    private Context context;
    private List<Dependent> dependantList;
    private TextView t;

    public DependentGridAdapter(Context context, List<Dependent> dependantList) {
        this.context = context;
        this.dependantList = dependantList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {
            gridView = new View(context);
            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.cell_dependent_appointment, null);
            // set value into textview
            CircularImageView ivdocImage = gridView.findViewById(R.id.imgIV);
            TextView textView = gridView.findViewById(R.id.dependentNameTV);
            TextView textViewReltionship = gridView.findViewById(R.id.relationshipTV);
            textView.setText(dependantList.get(position).getName());
            if (dependantList.get(position).getRelationWithPrimary() != null) {
                textViewReltionship.setText(dependantList.get(position).getRelationWithPrimary());
            } else {
                textViewReltionship.setText(R.string.self);
            }
            if (dependantList.get(position).getPhoto() != null) {
                Glide.with(context)
                        .load(dependantList.get(position).getPhoto())
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .apply(RequestOptions.circleCropTransform())
                        .into(ivdocImage);
            }

        } else {
            gridView = convertView;
        }
        return gridView;
    }

    private void clickedButton(TextView tv) {
        int num = Integer.parseInt(tv.getText().toString());
        ++num;
        tv.setText(Integer.toString(num));
    }

    private void clickedButtonm(TextView tv) {
        int num = Integer.parseInt(tv.getText().toString());
        if (num > 0) {
            --num;
            tv.setText(Integer.toString(num));
        }
    }

    @Override
    public int getCount() {
        return dependantList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class MyOnClickListener implements View.OnClickListener {
        public final TextView tv;

        public MyOnClickListener(TextView tv) {
            this.tv = tv;
        }

        @Override
        public void onClick(View v) {
            clickedButton(tv);
        }
    }

    class MyOnClickListenerm implements View.OnClickListener {
        public final TextView tv;

        public MyOnClickListenerm(TextView tv) {
            this.tv = tv;
        }

        @Override
        public void onClick(View v) {
            clickedButtonm(tv);
        }
    }
}