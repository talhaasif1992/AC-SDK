package com.augmentcare.patient.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.augmentcare.patient.R;
import com.augmentcare.patient.base.BaseActivity;
import com.augmentcare.patient.fragments.CashOnDelieveryFragment;
import com.augmentcare.patient.fragments.CreditCardFragment;
import com.augmentcare.patient.network.volleyApi.VolleyAPI;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends BaseActivity implements VolleyAPI.FragmentInteractionListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String typeNavigation = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_lab);
        viewPager = findViewById(R.id.viewpager_payment);
        setupViewPager(viewPager);
        tabLayout = findViewById(R.id.tabs_payment);
        tabLayout.setupWithViewPager(viewPager);

        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                typeNavigation = extras.getString("typeNavigation");
            }

            if (typeNavigation != null && typeNavigation.equalsIgnoreCase("home")) {
                setupViewPagerHome(viewPager);
                setupTabIconsHome();
            } else {
                setupViewPager(viewPager);
                setupTabIcons();
            }
        } catch (Exception ignored) {
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CashOnDelieveryFragment(), getString(R.string.cash_on_delivery));
        adapter.addFrag(new CreditCardFragment(), getString(R.string.credit_card));
        viewPager.setAdapter(adapter);
    }

    private void setupViewPagerHome(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CreditCardFragment(), getString(R.string.credit_card));
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_text, null);
        tabOne.setText(getString(R.string.cash_on_delivery));
        tabOne.setGravity(Gravity.CENTER_HORIZONTAL);
        Drawable img = ContextCompat.getDrawable(PaymentActivity.this, R.drawable.cash_blue);
        img.setBounds(0, 0, 50, 50);
        tabOne.setCompoundDrawables(null, img, null, null);
//        tabOne.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.cash_blue, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_text, null);
        tabTwo.setText(getString(R.string.credit_card));
        tabTwo.setGravity(Gravity.CENTER_HORIZONTAL);
        Drawable img1 = ContextCompat.getDrawable(PaymentActivity.this, R.drawable.credit_card_blue);
        img1.setBounds(0, 0, 50, 50);
        tabTwo.setCompoundDrawables(null, img1, null, null);
        tabLayout.getTabAt(1).setCustomView(tabTwo);
    }

    private void setupTabIconsHome() {
        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_text, null);
        tabTwo.setText(getString(R.string.credit_card));
        tabTwo.setGravity(Gravity.CENTER_HORIZONTAL);
        Drawable img1 = ContextCompat.getDrawable(PaymentActivity.this, R.drawable.credit_card_blue);
        img1.setBounds(0, 0, 50, 50);
        tabTwo.setCompoundDrawables(null, img1, null, null);
        tabLayout.getTabAt(0).setCustomView(tabTwo);
    }

    @Override
    public void onFragmentInteraction(int what) {
    }

    @Override
    public void onFragmentInteraction(int what, Bundle bundle) {
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}