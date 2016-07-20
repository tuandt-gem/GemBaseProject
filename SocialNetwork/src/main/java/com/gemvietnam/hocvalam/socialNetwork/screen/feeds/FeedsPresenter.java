package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.common.base.BasePresenterImpl;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Feed;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Feeds Presenter
 * Created by neo on 7/19/2016.
 */
public class FeedsPresenter extends BasePresenterImpl<FeedsContract.View> implements FeedsContract.Presenter {
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
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
                List<Feed> feeds = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    feeds.add(Feed.getInstance());
                }

                mFeeds.clear();
                mFeeds.addAll(feeds);
                mView.loadFeeds(getFeedAdapter());
                getFeedAdapter().notifyDataSetChanged();

//            }
//        }, 3000);
    }

    /**
     * Create new instance of {@link FeedAdapter}
     */
    private FeedAdapter createFeedAdapter() {
        return new FeedAdapter(mView.getViewContext(), mFeeds);
    }
}
