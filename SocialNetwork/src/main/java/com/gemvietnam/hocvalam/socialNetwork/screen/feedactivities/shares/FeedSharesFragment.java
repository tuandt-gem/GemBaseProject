package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.shares;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;

import android.widget.TextView;

import butterknife.Bind;

/**
 * The FeedShares Fragment
 */
public class FeedSharesFragment extends ViewFragment<FeedSharesContract.Presenter> implements FeedSharesContract.View {
  @Bind(R.id.text_view)
  TextView mTextView;

  public static FeedSharesFragment getInstance() {
    return new FeedSharesFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_feed_shares;
  }

  @Override
  public void setSharesCount(int count) {
    mTextView.setText(String.format(getString(R.string.format_count_shares), count));
  }
}
