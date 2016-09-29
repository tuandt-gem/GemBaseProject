package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.ViewModel;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;

/**
 * The Detail ViewModel
 */

class DetailViewModel extends ViewModel<DetailContract.View> implements DetailContract.ViewModel {
    private Feed mFeed;

    DetailViewModel(DetailContract.View view) {
        super(view);
    }

    @Override
    public void setFeed(Feed feed) {
        mFeed = feed;
    }

    @Override
    public String getContent() {
        return mFeed.getContent();
    }

    @Override
    public String getAvatarUrl() {
        return mFeed.getAvatar();
    }

    @Override
    public String getTitle() {
        return mFeed.getName();
    }
}
