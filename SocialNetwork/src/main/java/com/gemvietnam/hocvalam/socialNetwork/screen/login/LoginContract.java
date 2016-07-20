package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.common.base.BasePresenter;
import com.gemvietnam.common.base.BaseView;

import android.support.v7.widget.RecyclerView;

/**
 * This specifies the contract between the view and the presenter.
 * Created by neo on 7/19/2016.
 */
public interface LoginContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
        void getAccounts();

        AccountAdapter getAccountAdapter();
    }
}
