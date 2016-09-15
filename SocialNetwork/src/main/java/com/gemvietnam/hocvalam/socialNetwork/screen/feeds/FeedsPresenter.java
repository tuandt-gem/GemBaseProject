package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Feed;

import java.util.ArrayList;
import java.util.List;

/**
 * Feeds Presenter
 * Created by neo on 7/19/2016.
 */
public class FeedsPresenter extends Presenter<FeedsContract.View, FeedsContract.Router,
        FeedsContract.Interactor> implements FeedsContract.Presenter {
    private FeedAdapter mFeedAdapter;
    private List<Feed> mFeeds = new ArrayList<>();

    public FeedsPresenter(FeedsContract.View view) {
        super(view);
    }

    /**
     * Get current {@link FeedAdapter}
     */
    @Override
    public FeedAdapter getFeedAdapter() {
        if (mFeedAdapter == null) {
            mFeedAdapter = createFeedAdapter();
        }

        return mFeedAdapter;
    }

    @Override
    public void getFeeds() {
        mInteractor.getFeeds();
    }

    @Override
    public void onFeedsLoaded(List<Feed> feeds) {
        mFeeds.clear();
        mFeeds.addAll(feeds);
        mView.loadFeeds(getFeedAdapter());
        getFeedAdapter().notifyDataSetChanged();
    }

    /**
     * Create new instance of {@link FeedAdapter}
     */
    private FeedAdapter createFeedAdapter() {
        return new FeedAdapter(mView.getViewContext(), mFeeds);
    }

    @Override
    public void start() {

    }

    @Override
    public FeedsContract.Interactor onCreateInteractor() {
        return new FeedsInteractor(this);
    }
}
