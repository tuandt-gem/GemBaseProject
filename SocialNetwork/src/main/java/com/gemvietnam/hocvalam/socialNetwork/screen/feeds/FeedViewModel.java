package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.ViewModel;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;

import java.util.List;

/**
 * FeedDTO ViewModel
 * Created by neo on 9/26/2016.
 */

class FeedViewModel extends ViewModel<FeedsContract.View> implements FeedsContract.ViewModel {
    private List<Feed> mFeeds;
    private FeedAdapter mFeedAdapter;

    FeedViewModel(FeedsContract.View view) {
        super(view);
    }

    @Override
    public FeedViewModel setFeeds(List<Feed> feeds) {
        init(feeds);
        return this;
    }

    private void init(List<Feed> feeds) {
        mFeeds = feeds;

    }

    @Override
    public FeedAdapter getFeedAdapter() {
        if (mFeedAdapter == null) {
            mFeedAdapter = createFeedAdapter();
        }

        return mFeedAdapter;
    }

    @Override
    public List<Feed> getFeeds() {
        return mFeeds;
    }

    /**
     * Create new instance of {@link FeedAdapter}
     */
    private FeedAdapter createFeedAdapter() {
        return new FeedAdapter(mView.getViewContext(), mFeeds)
                .setOnItemAction(mView);
    }
}
