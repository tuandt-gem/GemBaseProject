package com.gemvietnam.hocvalam.socialNetwork.data.remote.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Account
 * Created by neo on 7/19/2016.
 */
public class Account {
    @SerializedName("name")
    private String mName;

    public Account(){};

    public Account(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public Account setName(String name) {
        mName = name;
        return this;
    }
}
