package com.gemvietnam.hocvalam.socialNetwork.network.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Common response DTO
 * Created by neo on 12/15/14.
 */
public class ResponseDTO<DTO> implements Serializable {
    private String responseCode;

    @SerializedName("data")
    private DTO result;

    private String message;

    @SerializedName("captcha")
    private int mCaptcha;

    public ResponseDTO() {
    }

    public DTO getResult() {
        return result;
    }

    public void setResult(DTO result) {
        this.result = result;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCaptcha() {
        return mCaptcha;
    }

    public void setCaptcha(int captcha) {
        mCaptcha = captcha;
    }
}

