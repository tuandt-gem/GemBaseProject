package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.Bind;

/**
 * The FeedActivities Fragment
 */
public class FeedActivitiesFragment extends ViewFragment<FeedActivitiesContract.Presenter> implements FeedActivitiesContract.View {
  @Bind(R.id.tab_layout)
  TabLayout mTabLayout;
  @Bind(R.id.view_pager)
  ViewPager mViewPager;

  public static FeedActivitiesFragment getInstance() {
    return new FeedActivitiesFragment();
  }

  @Override
  public void initLayout() {
    super.initLayout();

    mViewPager.setAdapter(mPresenter.getFeedActivitiesAdapter());
    mViewPager.setOffscreenPageLimit(FeedActivitiesAdapter.PAGE_SIZE);
    mTabLayout.setupWithViewPager(mViewPager);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_feed_activities;
  }
}
