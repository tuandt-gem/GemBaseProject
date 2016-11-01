package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities;

import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;
import com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.comments.FeedCommentsPresenter;
import com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.likes.FeedLikesPresenter;
import com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.shares.FeedSharesPresenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Feed Activities Adapter
 * Created by NEO on 10/31/2016.
 */

public class FeedActivitiesAdapter extends FragmentStatePagerAdapter {
  public static final int PAGE_SIZE = 3;
  private Context mContext;
  private Feed mFeed;

  public FeedActivitiesAdapter(FragmentManager fm, Context context, Feed feed) {
    super(fm);
    mContext = context;
    mFeed = feed;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return new FeedLikesPresenter(null)
            .setFeed(mFeed)
            .getFragment();
      case 1:
        return new FeedCommentsPresenter(null)
            .setFeed(mFeed)
            .getFragment();
      case 2:
        return new FeedSharesPresenter(null)
            .setFeed(mFeed)
            .getFragment();
    }
    return null;
  }

  @Override
  public int getCount() {
    return PAGE_SIZE;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return mContext.getString(R.string.title_likes);
      case 1:
        return mContext.getString(R.string.title_comments);
      case 2:
        return mContext.getString(R.string.title_shares);
      default:
        return "";
    }
  }
}
