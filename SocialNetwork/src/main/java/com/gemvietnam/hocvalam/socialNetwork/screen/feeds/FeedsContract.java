package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IRouter;
import com.gemvietnam.base.viper.interfaces.IViewModel;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 * Created by neo on 7/19/2016.
 */
interface FeedsContract {

    interface Interactor extends IInteractor<Presenter> {
        void getFeeds();
    }

    interface View extends PresentView<Presenter>,FeedAdapter.OnItemAction {
        void loadFeeds(ViewModel viewModel);

        void onItemClicked(Feed feed);
    }

    interface Presenter extends IPresenter<Router, ViewModel, View, Interactor> {
        void onFeedsLoaded(List<Feed> feeds);

        void viewDetail(Feed feed);
    }

    interface Router extends IRouter {
        void viewDetail(Feed feed);
    }

    interface ViewModel extends IViewModel<View> {
        FeedAdapter getFeedAdapter();
        ViewModel setFeeds(List<Feed> feeds);
        List<Feed> getFeeds();
    }
}
