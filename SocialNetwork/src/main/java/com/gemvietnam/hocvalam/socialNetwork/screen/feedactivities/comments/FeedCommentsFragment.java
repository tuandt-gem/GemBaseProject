package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.comments;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;

import android.widget.TextView;

import butterknife.Bind;

/**
 * The FeedComments Fragment
 */
public class FeedCommentsFragment extends ViewFragment<FeedCommentsContract.Presenter> implements FeedCommentsContract.View {
  @Bind(R.id.text_view)
  TextView mTextView;

  public static FeedCommentsFragment getInstance() {
    return new FeedCommentsFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_feed_comments;
  }

  @Override
  public void setCommentsCount(int count) {
    mTextView.setText(String.format(getString(R.string.format_count_comments), count));
  }
}
