package com.augmentcare.patient.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.augmentcare.patient.MyApp;
import com.augmentcare.patient.R;
import com.augmentcare.patient.activities.HomeScreenActivity;
import com.augmentcare.patient.base.BaseFragment;
import com.blankj.utilcode.util.StringUtils;

import es.dmoral.toasty.Toasty;

public class UpdateFragment extends BaseFragment {
    TextView txtMessage;
    Button btnUpdate;
    private View rootView;
    private UpdateFragmentArgs args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_update, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((HomeScreenActivity) baseActivity).setToolbarTitle("App Update");

        initMe();
    }

    private void initMe() {
        loadArgs();

        txtMessage = rootView.findViewById(R.id.txtMessage);
        btnUpdate = rootView.findViewById(R.id.btnUpdate);

        String html = StringUtils.null2Length0(args.getHtmltext());
        txtMessage.setText(Html.fromHtml(html));
        btnUpdate.setOnClickListener(view -> launchMarket());

        if(args.getEnforced()){
           setBackPress(true);
        }
        else{
            setBackPress(true);
        }

    }

    private void loadArgs() {
        if (getArguments() != null) {
            args = UpdateFragmentArgs.fromBundle(getArguments());
        }
    }


    private void launchMarket() {
        String packageName = baseActivity.getPackageName();
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            UpdateFragment.this.startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toasty.error(MyApp.get(), "Unable to load app details page at the moment. Please try again later ! ", Toast.LENGTH_LONG, false).show();
        }
    }

}