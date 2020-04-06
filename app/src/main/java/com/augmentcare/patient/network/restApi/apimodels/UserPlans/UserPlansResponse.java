package com.augmentcare.patient.network.restApi.apimodels.UserPlans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserPlansResponse implements Parcelable {

	@SerializedName("user_plans")
	private UserPlans userPlans;

	public UserPlansResponse() {
	}

	protected UserPlansResponse(Parcel in) {
		userPlans = in.readParcelable(UserPlans.class.getClassLoader());
	}

	public static final Creator<UserPlansResponse> CREATOR = new Creator<UserPlansResponse>() {
		@Override
		public UserPlansResponse createFromParcel(Parcel in) {
			return new UserPlansResponse(in);
		}

		@Override
		public UserPlansResponse[] newArray(int size) {
			return new UserPlansResponse[size];
		}
	};

	public void setUserPlans(UserPlans userPlans){
		this.userPlans = userPlans;
	}
	public UserPlansResponse withUserPlans(UserPlans userPlans){
		this.userPlans = userPlans;
		return this;
	}

	public UserPlans getUserPlans(){
		return userPlans;
	}

	@Override
 	public String toString(){
		return 
			"UserPlansResponse{" + 
			"user_plans = '" + userPlans + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(userPlans, flags);
	}
}