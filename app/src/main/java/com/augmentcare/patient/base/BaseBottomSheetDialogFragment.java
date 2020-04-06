package com.augmentcare.patient.base;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.augmentcare.patient.Interface.OnValueGot;
import com.augmentcare.patient.network.restApi.apimodels.UserDataLogin;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import io.reactivex.disposables.CompositeDisposable;

public class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment {
    protected BaseActivity baseActivity;
    public CompositeDisposable COMPOSITE_DISPOSE;
//    public final VolleyAPI VOLLEYAPI = new VolleyAPI();

    public CompositeDisposable getDisposer() {
        if (COMPOSITE_DISPOSE == null) {
            COMPOSITE_DISPOSE = new CompositeDisposable();
        }
        return COMPOSITE_DISPOSE;
    }

    public void getUserInfo(OnValueGot<UserDataLogin> got) {
        baseActivity.getUserInfo(got);
    }

    protected void safeNavigateTo(OnValueGot<NavController> got){
        NavController navController = NavHostFragment.findNavController(this);
        got.gotIt(navController);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        baseActivity = (BaseActivity) getActivity();
        initMe();
    }

    private void initMe() {
        getUserInfo(userData->{
            baseActivity.userData = userData;
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        if (baseActivity instanceof BaseActivity) {
            try {
                baseActivity.setupUI(getView(),false);
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
        super.onStart();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        baseActivity.clearApiStack();
    }

    public void clearApiStack() {
        getDisposer().clear();
    }

//    /**
//     * Could handle back press.
//     * @return true if back press was handled
//     */
//    public boolean onBackPressed() {
//        return false;
//    }

    @Override
    public void onDestroyView() {
        clearApiStack();

//        safeNavigateTo(n -> {});
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        try {
//            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
//            childFragmentManager.setAccessible(true);
//            childFragmentManager.set(this, null);
//        }catch(Exception e){
//            e.printStackTrace();
//        }

    }

    /*public void setFont(View view) {
        //((BaseActivity)baseActivity).setFont(view);
	}*/
}
