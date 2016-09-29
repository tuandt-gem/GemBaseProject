package com.gemvietnam.hocvalam.socialNetwork.model;

import com.google.gson.annotations.SerializedName;

/**
 * AccountDTO
 * Created by neo on 7/19/2016.
 */
public class Account {
    private static Account sInstance;

    private String mName;

    public Account() {}

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

    public static Account getInstance() {
        return sInstance;
    }

    public static void setInstance(Account accountDTO) {
        sInstance = accountDTO;
    }
}
