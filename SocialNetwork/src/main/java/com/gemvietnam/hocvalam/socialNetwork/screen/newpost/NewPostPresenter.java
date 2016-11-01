package com.gemvietnam.hocvalam.socialNetwork.screen.newpost;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The NewPost Presenter
 */
public class NewPostPresenter extends Presenter<NewPostContract.View, NewPostContract.Interactor>
    implements NewPostContract.Presenter {

  public NewPostPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public NewPostContract.View onCreateView() {
    return NewPostFragment.getInstance();
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public NewPostContract.Interactor onCreateInteractor() {
    return new NewPostInteractor(this);
  }
}
