package com.gemvietnam.base.viper;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IRouter;
import com.gemvietnam.base.viper.interfaces.IView;

import android.app.Activity;

/**
 * Base implements for presenters
 * Created by neo on 14/03/2016.
 */
public abstract class Presenter<V extends IView, R extends IRouter, I extends IInteractor>
        implements IPresenter<R, I> {
    protected V mView;
    protected R mRouter;
    protected I mInteractor;

    public Presenter(V view) {
        mView = view;
        mInteractor = onCreateInteractor();
    }

    @Override
    public Activity getViewContext() {
        return mView.getViewContext();
    }


    @Override
    public void setRouter(R router) {
        mRouter = router;
    }
}
