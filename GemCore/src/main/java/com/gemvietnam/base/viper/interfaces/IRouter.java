package com.gemvietnam.base.viper.interfaces;


/**
 * Base Router
 * Created by neo on 8/29/2016.
 */
public interface IRouter<V extends IView> {
    void present();

    V getView();

    V onCreateView();
}
