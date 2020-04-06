package com.augmentcare.patient.utils;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class GoogleSignInUtils {
    private GoogleSignInClient googleSignInClient;
    private Activity activityContext;
    private OnValueGot<GoogleSignInAccount> signInListner;
    
    public static GoogleSignInUtils getInstance(Activity activity,String googleWebClientID) {
        return new GoogleSignInUtils(activity, googleWebClientID);
    }
    private GoogleSignInUtils(Activity activity,String googleWebClientID) {
        activityContext = activity;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(googleWebClientID)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(activityContext, gso);
//        signOut(this::signIn);
    }
    public interface OnValueGot<T> {
        void gotIt(T value);
    }
    // [START onActivityResult]
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == Constants.REQUEST_GOOGLE_SIGNIN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = null;
            try {
                task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);
            } catch (Exception e) {
                e.printStackTrace();
                if(signInListner != null){
                    signInListner.gotIt(null);
                }
            }
        } else {
            if(signInListner != null){
                signInListner.gotIt(null);
            }
        }
    }
    // [END onActivityResult]
    // [START handleSignInResult]
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if(signInListner != null){
                signInListner.gotIt(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
            signInListner.gotIt(null);
        }
    }
    // [END handleSignInResult]
    // [START signIn]
    public void signInWithinFragment(Fragment contextOfCalling, OnValueGot<GoogleSignInAccount> got) {
        signInListner = got;
        Intent signInIntent = googleSignInClient.getSignInIntent();
        contextOfCalling.startActivityForResult(signInIntent, Constants.REQUEST_GOOGLE_SIGNIN);
    }
    // [START signIn]
    public void signInOnActivity(OnValueGot<GoogleSignInAccount> got) {
        signInListner = got;
        Intent signInIntent = googleSignInClient.getSignInIntent();
        activityContext.startActivityForResult(signInIntent, Constants.REQUEST_GOOGLE_SIGNIN);
    }
    // [END signIn]
    // [START signOut]
    public void signOut(OnValueGot<Boolean> onComplete) {
        googleSignInClient.signOut()
                .addOnFailureListener(activityContext, e -> {
                    e.printStackTrace();
                    onComplete.gotIt(false);
                })
                .addOnCompleteListener(activityContext, task -> {
                    // [START_EXCLUDE]
//                        updateUI(null);
                    // [END_EXCLUDE]
                    onComplete.gotIt(true);
                });
    }
    // [END signOut]
    // [START revokeAccess]
    public void revokeAccess(OnValueGot<Boolean> onRevoked) {
        googleSignInClient.revokeAccess()
                .addOnFailureListener(activityContext, e -> {
                    e.printStackTrace();
                    onRevoked.gotIt(false);
                })
                .addOnCompleteListener(activityContext, task -> {
                    // [START_EXCLUDE]
//                        updateUI(null);
                    // [END_EXCLUDE]
                    onRevoked.gotIt(true);
                });
    }
    // [END revokeAccess]
}