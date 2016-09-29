package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;
import com.gemvietnam.utils.RecyclerUtils;

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
    public void initLayout() {
        RecyclerUtils.setupVerticalRecyclerView(getActivity(), mRecyclerView);
    }

    @Override
    public void loadFeeds(FeedsContract.ViewModel viewModel) {
        if (mRecyclerView.getAdapter() == null) {
            mRecyclerView.setAdapter(viewModel.getFeedAdapter());
        } else {
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClicked(Feed feed) {
        mPresenter.viewDetail(feed);
    }
}
