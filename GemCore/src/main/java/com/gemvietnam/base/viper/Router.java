package com.gemvietnam.base.viper;

import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.base.viper.interfaces.IRouter;
import com.gemvietnam.base.viper.interfaces.IView;

/**
 * Base Router
 * Created by neo on 8/29/2016.
 */
public abstract class Router<V extends IView> implements IRouter<V> {
    protected V mView;
    protected ContainerView mContainerView;

    public Router(ContainerView containerView) {
        mContainerView = containerView;
        mView = onCreateView();
    }

    @Override
    public void present() {
        mContainerView.addView(mView);
    }

    @Override
    public V getView() {
        return mView;
    }
}
