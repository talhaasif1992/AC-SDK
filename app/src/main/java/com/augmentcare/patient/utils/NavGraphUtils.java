package com.augmentcare.patient.utils;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;

public class NavGraphUtils {

    @NonNull
    private NavController navController;

    private NavGraphUtils(@NonNull NavController navController) {
        this.navController = navController;
    }

    public static NavGraphUtils getMe(@NonNull NavController navController) {
        return new NavGraphUtils(navController);
    }

    public void popToRoot() {
        navController.popBackStack(
                navController.getGraph().getStartDestination(),
                false
        );
    }

    /**
     * Pop all entries from navigation backstack until you reach desired destination
     * Note: provided destination will not be popped
     *
     * @param fragID
     */
    public void popUntil(@IdRes int fragID) {
        navController.popBackStack(fragID, false);
    }

    public boolean isAlreadyInNav(@IdRes int navFragID) {
        try {
            NavBackStackEntry entry = navController.getBackStackEntry(navFragID);
            return true;
        } catch (Exception e) {
            if (navController.getCurrentDestination() != null &&
                    navController.getCurrentDestination().getId() == navFragID)
                return true;
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLastDest(@IdRes int navFragID) {
        return navController.getCurrentDestination() != null &&
                navController.getCurrentDestination().getId() == navFragID;
    }
}
