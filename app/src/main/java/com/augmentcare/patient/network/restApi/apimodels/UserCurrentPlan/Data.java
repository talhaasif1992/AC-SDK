package com.augmentcare.patient.network.restApi.apimodels.UserCurrentPlan;


import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("user_plans")
	private UserPlans userPlans;

	public void setUserPlans(UserPlans userPlans){
		this.userPlans = userPlans;
	}

	public UserPlans getUserPlans(){
		return userPlans;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"user_plans = '" + userPlans + '\'' + 
			"}";
		}
}