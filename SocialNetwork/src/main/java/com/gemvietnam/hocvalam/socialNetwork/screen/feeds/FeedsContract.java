package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.common.base.BasePresenter;
import com.gemvietnam.common.base.BaseView;
import com.gemvietnam.hocvalam.socialNetwork.screen.login.LoginContract;

/**
 * This specifies the contract between the view and the presenter.
 * Created by neo on 7/19/2016.
 */
public interface FeedsContract {

    interface View extends BaseView<FeedsContract.Presenter> {

        void loadFeeds(FeedAdapter feedAdapter);
    }

    interface Presenter extends BasePresenter {

        FeedAdapter getFeedAdapter();

        void getFeeds();
    }
}
