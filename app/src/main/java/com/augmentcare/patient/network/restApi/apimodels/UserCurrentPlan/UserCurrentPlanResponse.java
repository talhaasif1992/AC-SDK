package com.augmentcare.patient.network.restApi.apimodels.UserCurrentPlan;


import com.google.gson.annotations.SerializedName;

public class UserCurrentPlanResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("status")
	private int status;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"UserCurrentPlanResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}