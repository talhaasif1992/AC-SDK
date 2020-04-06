package com.augmentcare.patient.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.augmentcare.patient.R;
import com.augmentcare.patient.model.DependentType;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Qamar Ul Zaman on 21/02/2018.
 */

public class RelationshipsAdapter extends ArrayAdapter<DependentType>{


    public RelationshipsAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view  = super.getView(position, convertView, parent);
        ImageView ivRelationship = view.findViewById(R.id.ivIcon);
        ivRelationship.setVisibility(View.VISIBLE);
        /*{"mother":0,"father":1,"wife":2,"husband":3,"son":4,"daughter":5,"sibling":6}*/
        switch (getItem(position).getId().replace(".0","")){
            case "0":
                Glide.with(Utils.getApp())
                        .load(R.drawable.ic_mother)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ivRelationship);
                break;
            case "1":
                Glide.with(Utils.getApp())
                        .load(R.drawable.ic_father)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ivRelationship);
                break;
            case "2":
                Glide.with(Utils.getApp())
                        .load(R.drawable.ic_wife)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ivRelationship);
                break;
            case "3":
                Glide.with(Utils.getApp())
                        .load(R.drawable.ic_husband)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ivRelationship);
                break;
            case "4":
                Glide.with(Utils.getApp())
                        .load(R.drawable.ic_son)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ivRelationship);
                break;
            case "5":
                Glide.with(Utils.getApp())
                        .load(R.drawable.ic_daughter)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ivRelationship);
                break;
            case "6":
                Glide.with(Utils.getApp())
                        .load(R.drawable.ic_sibling)
                        .error(R.drawable.profile_placeholder)
                        .placeholder(R.drawable.profile_placeholder)
                        .into(ivRelationship);
                break;
        }
        //ivRelationship.setImageResource();
        return view;
    }
}
