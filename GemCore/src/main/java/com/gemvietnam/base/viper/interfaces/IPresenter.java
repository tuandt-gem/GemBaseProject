package com.gemvietnam.base.viper.interfaces;

import android.app.Activity;

/**
 * Base Presenter
 * Created by neo on 2/5/2016.
 */
public interface IPresenter<R extends IRouter, I extends IInteractor> {
    Activity getViewContext();
    void start();
    void setRouter(R router);
    I onCreateInteractor();
}
