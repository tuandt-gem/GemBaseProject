package com.gemvietnam.hocvalam.socialNetwork.screen.newpost;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;

/**
 * The NewPost Fragment
 */
public class NewPostFragment extends ViewFragment<NewPostContract.Presenter> implements NewPostContract.View {

  public static NewPostFragment getInstance() {
    return new NewPostFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_new_post;
  }
}
