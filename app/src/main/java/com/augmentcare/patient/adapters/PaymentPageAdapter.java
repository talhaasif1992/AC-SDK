package com.augmentcare.patient.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class PaymentPageAdapter extends FragmentPagerAdapter {
    int numOfTabs;
    List<Fragment> fragmentList;

    public PaymentPageAdapter(@NonNull FragmentManager fm, int numOfTabs, List<Fragment> fragmentList) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                return fragmentList.get(0);
            case 1:
                return fragmentList.get(1);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
