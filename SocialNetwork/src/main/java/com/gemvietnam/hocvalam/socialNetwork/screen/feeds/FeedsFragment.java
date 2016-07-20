package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.common.base.BaseFragment;
import com.gemvietnam.common.utils.CollectionUtils;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import android.support.v7.widget.RecyclerView;

import butterknife.Bind;

/**
 * Feeds Activity
 * Created by neo on 7/19/2016.
 */
public class FeedsFragment extends BaseFragment<FeedsContract.Presenter> implements FeedsContract.View {
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

        mRecyclerView.setAdapter(getPresenter().getFeedAdapter());

        getPresenter().getFeeds();
    }

    @Override
    public void loadFeeds(FeedAdapter feedAdapter) {
        mRecyclerView.setAdapter(feedAdapter);
    }
}
