
package com.augmentcare.patient.model.createClaimsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HrUser {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user_role_id")
    @Expose
    private Integer userRoleId;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("channel_key")
    @Expose
    private String channelKey;
    @SerializedName("email")
    @Expose
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
