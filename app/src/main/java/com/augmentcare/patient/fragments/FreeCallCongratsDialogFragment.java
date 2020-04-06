package com.augmentcare.patient.fragments;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseDialogFragment;
import com.augmentcare.patient.utils.PrefsHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FreeCallCongratsDialogFragment extends BaseDialogFragment {
    private View rootView;

    @BindView(R.id.tv_congrats)
    TextView tvCongratsUser;
    @BindView(R.id.tv_you_are_going_to_make_your_first_free_call)
    TextView tvNote;

    NavController navController;

    public FreeCallCongratsDialogFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_free_call_congrats_dialog, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(baseActivity,R.id.nav_host_fragment);
        setCancelable(false);

        if(getArguments()!=null){
            FreeCallCongratsDialogFragmentArgs args = FreeCallCongratsDialogFragmentArgs.fromBundle(getArguments());
            if(args!=null && args.getCallType().equals("book")){
                tvCongratsUser.setTextColor(Color.parseColor("#ff669900"));
                tvCongratsUser.setText("Congratulations, "+PrefsHelper.getUserInfo().getFirstName() +" "+ PrefsHelper.getUserInfo().getLastName());
                tvNote.setText("You are going to Book your First Free Consultation with Instant Doctor");
            }
            else if(args!=null && args.getCallType().equals("call")){
                tvCongratsUser.setTextColor(Color.parseColor("#ff669900"));
                tvCongratsUser.setText("Congratulations, "+PrefsHelper.getUserInfo().getFirstName() +" "+ PrefsHelper.getUserInfo().getLastName());
                tvNote.setText("You are going to have your First Free Consultation with Instant Doctor");
            }
            else if(args!=null && args.getCallType().equals("sorry")){
                tvCongratsUser.setTextColor(Color.parseColor("#ffcc0000"));
                tvCongratsUser.setText("Sorry, "+PrefsHelper.getUserInfo().getFirstName()+" "+PrefsHelper.getUserInfo().getLastName());
                tvNote.setText("You already have your First Free Consultation. Now You have to buy a Plan to make further consultations.");
            }
        }
        MyApp.HANDLER.postDelayed(()->{
            navController.popBackStack();
        },5000);
    }
}
