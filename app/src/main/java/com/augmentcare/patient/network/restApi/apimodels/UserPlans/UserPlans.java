package com.augmentcare.patient.network.restApi.apimodels.UserPlans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPlans implements Parcelable {

	@SerializedName("card_id")
	private String stripeToken;

	@SerializedName("plan_id")
	private String planId;

	@SerializedName("coupon_code")
	private String couponCode;
	@SerializedName("jazz_account")
	@Expose
	private String jazzAccount;

	public UserPlans(Parcel in) {


		this.planId = ((String) in.readValue((Integer.class.getClassLoader())));
		this.stripeToken = ((String) in.readValue((String.class.getClassLoader())));
		this.couponCode = ((String) in.readValue((String.class.getClassLoader())));
		this.jazzAccount = ((String) in.readValue((String.class.getClassLoader())));


	}

	public UserPlans(String stripeToken, String planId,String couponCode,String jazzAccount) {
		this.stripeToken = stripeToken;
		this.planId = planId;
		this.couponCode = couponCode;
		this.jazzAccount = jazzAccount;
	}

	public UserPlans() {
	}

	public UserPlans withCouponCode(String couponCode) {
		this.couponCode = couponCode;
		return this;
	}
	public UserPlans withStripeToken(String token) {
		this.stripeToken = token;
		return this;
	}
	public UserPlans withId(String plan_id) {
		this.planId = plan_id;
		return this;
	}
	public UserPlans withJazzAccount(String jazzAccount) {
		this.jazzAccount = jazzAccount;
		return this;
	}
	public static final Creator<UserPlans> CREATOR = new Creator<UserPlans>() {
		@Override
		public UserPlans createFromParcel(Parcel in) {
			return new UserPlans(in);
		}

		@Override
		public UserPlans[] newArray(int size) {
			return new UserPlans[size];
		}
	};

	public String getJazzAccount() {
		return jazzAccount;
	}

	public void setJazzAccount(String jazzAccount) {
		this.jazzAccount = jazzAccount;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public void setStripeToken(String stripeToken){
		this.stripeToken = stripeToken;
	}

	public String getStripeToken(){
		return stripeToken;
	}

	public void setPlanId(String planId){
		this.planId = planId;
	}

	public String getPlanId(){
		return planId;
	}

	@Override
	public String toString() {
		return "UserPlans{" +
				"stripeToken='" + stripeToken + '\'' +
				", planId='" + planId + '\'' +
				", couponCode='" + couponCode + '\'' +
				", jazzAccount='" + jazzAccount + '\'' +
				'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(stripeToken);
		dest.writeValue(planId);
		dest.writeValue(couponCode);
		dest.writeValue(jazzAccount);

	}
}