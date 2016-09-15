package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.utils.CollectionUtils;

import android.support.v7.widget.RecyclerView;

import butterknife.Bind;

/**
 * Feeds Activity
 * Created by neo on 7/19/2016.
 */
public class FeedsFragment extends ViewFragment<FeedsContract.Presenter>
        implements FeedsContract.View {
    @Bind(R.id.feed_recycler_view)
    RecyclerView mRecyclerView;

    public static FeedsFragment getInstance() {
        return new FeedsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_feeds;
    }

    @Override
    public FeedsContract.Presenter onCreatePresenter() {
        return new FeedsPresenter(this);
    }

    @Override
    public void initLayout() {
        CollectionUtils.setupVerticalRecyclerView(getActivity(), mRecyclerView);

        mRecyclerView.setAdapter(mPresenter.getFeedAdapter());

        mPresenter.getFeeds();
    }

    @Override
    public void loadFeeds(FeedAdapter feedAdapter) {
        mRecyclerView.setAdapter(feedAdapter);
    }
}
