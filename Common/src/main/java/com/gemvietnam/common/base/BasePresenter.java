package com.gemvietnam.common.base;

import android.app.Activity;

/**
 * Base Presenter
 * Created by neo on 2/5/2016.
 */
public interface BasePresenter {
    BaseView getView();
    Activity getViewContext();
}
