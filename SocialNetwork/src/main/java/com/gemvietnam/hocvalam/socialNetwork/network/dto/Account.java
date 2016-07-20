package com.gemvietnam.hocvalam.socialNetwork.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Account
 * Created by neo on 7/19/2016.
 */
public class Account {
    @SerializedName("name")
    private String mName;

    public Account(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
