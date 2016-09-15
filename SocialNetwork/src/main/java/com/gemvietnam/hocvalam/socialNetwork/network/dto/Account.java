package com.gemvietnam.hocvalam.socialNetwork.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Account
 * Created by neo on 7/19/2016.
 */
public class Account {
    private static Account sInstance;

    @SerializedName("name")
    private String mName;

    public Account(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public static Account getInstance() {
        return sInstance;
    }

    public static void setInstance(Account account) {
        sInstance = account;
    }
}
