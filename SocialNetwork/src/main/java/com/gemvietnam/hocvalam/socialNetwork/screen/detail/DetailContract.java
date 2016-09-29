package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IRouter;
import com.gemvietnam.base.viper.interfaces.IViewModel;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;

/**
 * The Detail Contract
 */
interface DetailContract {

    interface Interactor extends IInteractor<Presenter> {
    }

    interface View extends PresentView<Presenter> {
        void viewFeedDetail(DetailContract.ViewModel detailViewModel);
    }

    interface Presenter extends IPresenter<Router, ViewModel, View, Interactor> {
        void setFeed(Feed feed);
    }

    interface Router extends IRouter {
    }

    interface ViewModel extends IViewModel<View> {
        void setFeed(Feed feed);

        String getContent();

        String getAvatarUrl();

        String getTitle();
    }
}



