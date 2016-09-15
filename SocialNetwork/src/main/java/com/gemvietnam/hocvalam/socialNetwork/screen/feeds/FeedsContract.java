package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IRouter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Feed;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 * Created by neo on 7/19/2016.
 */
public interface FeedsContract {

    interface Interactor extends IInteractor {

        void getFeeds();
    }

    interface View extends PresentView<Presenter> {
        void loadFeeds(FeedAdapter feedAdapter);
    }

    interface Presenter extends IPresenter<Router, Interactor> {
        FeedAdapter getFeedAdapter();

        void getFeeds();

        void onFeedsLoaded(List<Feed> feeds);
    }

    interface Router extends IRouter<View> {

    }
}
