package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.likes;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;

import android.widget.TextView;

import butterknife.Bind;

/**
 * The FeedLikes Fragment
 */
public class FeedLikesFragment extends ViewFragment<FeedLikesContract.Presenter> implements FeedLikesContract.View {
  @Bind(R.id.text_view)
  TextView mTextView;

  public static FeedLikesFragment getInstance() {
    return new FeedLikesFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_feed_likes;
  }

  @Override
  public void setLikesCount(int count) {
    mTextView.setText(String.format(getString(R.string.format_count_likes), count));
  }
}
