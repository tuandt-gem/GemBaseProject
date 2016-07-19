package com.gemvietnam.hocvalam.socialNetwork.network.callback;


import com.gemvietnam.hocvalam.R;
import com.gemvietnam.hocvalam.socialNetwork.SocialNetworkApp;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.ResponseDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Base callback for all services
 * Created by neo on 2/15/2016.
 */
public abstract class BaseCallback<T> implements Callback<ResponseDTO<T>> {
    public static final String NETWORK_ERROR = "999";

    @Override
    public void onResponse(Call<ResponseDTO<T>> call, Response<ResponseDTO<T>> response) {
        // Get body of request
        ResponseDTO<T> body = null;
        String responseCode = NETWORK_ERROR;
        String message = "";

        if (response.isSuccessful()) {
            body = response.body();
            responseCode = body.getResponseCode();
            message = body.getMessage();
        }

        if (body == null) {
            try {
                onError(NETWORK_ERROR, getServerMsg());
            } catch (IllegalStateException | NullPointerException ex) {
                ex.printStackTrace();
            }
            return;
        }

        // If not success

        if (!ResponseCode.SUCCESS.equals(responseCode)) {
            try {
                onError(responseCode, message);
            } catch (IllegalStateException | NullPointerException ex) {
                ex.printStackTrace();
            }
            return;
        }

        // Request success
        try {
            onResponse(body.getResult());
        } catch (IllegalStateException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<ResponseDTO<T>> call, Throwable t) {
        try {
            onError(NETWORK_ERROR, getServerMsg());
        } catch (IllegalStateException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private String getServerMsg() {
        return SocialNetworkApp.getInstance().getString(R.string.msg_server_error);
    }

    public abstract void onError(String errorCode, String errorMessage);

    public abstract void onResponse(T data);


    interface ResponseCode {
        String SUCCESS = "200";
//        String LOCK_USER = "888";
    }
}
