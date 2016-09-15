package com.gemvietnam.base.viper;

import com.gemvietnam.base.BaseActivity;
import com.gemvietnam.base.BaseFragment;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.common.R;
import com.gemvietnam.utils.ContextUtils;
import com.gemvietnam.utils.DialogUtils;
import com.gemvietnam.utils.NetworkUtils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragments that stand for View
 * Created by neo on 9/15/2016.
 */
public abstract class ViewFragment <P extends IPresenter> extends BaseFragment implements
        PresentView<P> {
    protected P mPresenter;
    protected boolean mIsInitialized = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Presenter for this view
        if (mPresenter == null)
            mPresenter = onCreatePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (!mIsInitialized) {
            mRootView = super.onCreateView(inflater, container, savedInstanceState);

            // Prepare layout
            if (getArguments() != null) {
                parseArgs(getArguments());
            }

            initLayout();

            mIsInitialized = true;
        }

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!mStartOnAnimationEnded) {
            startPresent();
        }
    }

    @Override
    protected void startPresent() {
        mPresenter.start();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void initLayout() {

    }

    @Override
    public void showAlertDialog(String message) {

    }

    @Override
    public BaseActivity getBaseActivity() {
        if (getActivity() instanceof BaseActivity) {
            return (BaseActivity) getActivity();
        } else {
            return null;
        }
    }

    @Override
    public void onRequestError(String errorCode, String errorMessage) {
        if (ContextUtils.isValidContext(getBaseActivity())) {
            getBaseActivity().onRequestError(errorCode, errorMessage);
        }
    }

    @Override
    public void onNetworkError(boolean shouldShowPopup) {
        if (!NetworkUtils.isNoNetworkAvailable(getActivity(), shouldShowPopup)) {
            DialogUtils.showErrorAlert(getActivity(), getString(R.string.msg_network_lost));
        }
    }

    @Override
    public void onRequestSuccess() {
        if (ContextUtils.isValidContext(getBaseActivity())) {
            getBaseActivity().onRequestSuccess();
        }
    }

    @Override
    public Activity getViewContext() {
        return getActivity();
    }

    /**
     * Parse Arguments that sent to this fragment
     * Override if needed
     *
     * @param args sent to this fragment
     */
    protected void parseArgs(Bundle args) {}
}
