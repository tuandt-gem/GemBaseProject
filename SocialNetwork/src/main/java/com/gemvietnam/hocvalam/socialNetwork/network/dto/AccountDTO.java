package com.gemvietnam.hocvalam.socialNetwork.network.dto;

import com.google.gson.annotations.SerializedName;

/**
 * AccountDTO
 * Created by neo on 7/19/2016.
 */
public class AccountDTO {
    @SerializedName("name")
    private String mName;

    public AccountDTO(){};

    public AccountDTO(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public AccountDTO setName(String name) {
        mName = name;
        return this;
    }
}
