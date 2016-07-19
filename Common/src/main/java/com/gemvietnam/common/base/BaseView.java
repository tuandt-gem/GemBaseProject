package com.gemvietnam.common.base;

import android.app.Activity;

/**
 * Base View
 * Created by neo on 2/5/2016.
 */
public interface BaseView<P extends BasePresenter> {
    void showProgress();

    void hideProgress();

    void initLayout();

    void showAlertDialog(String message);

    P getPresenter();

    P onCreatePresenter();

    BaseActivity getBaseActivity();

    void onRequestError(String errorCode, String errorMessage);

    void onRequestSuccess();

    Activity getViewContext();
}
