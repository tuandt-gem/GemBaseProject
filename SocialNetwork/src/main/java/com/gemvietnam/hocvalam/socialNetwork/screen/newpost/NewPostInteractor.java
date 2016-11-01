package com.gemvietnam.hocvalam.socialNetwork.screen.newpost;

import com.gemvietnam.base.viper.Interactor;

/**
 * The NewPost interactor
 */
class NewPostInteractor extends Interactor<NewPostContract.Presenter>
    implements NewPostContract.Interactor {

  NewPostInteractor(NewPostContract.Presenter presenter) {
    super(presenter);
  }
}
