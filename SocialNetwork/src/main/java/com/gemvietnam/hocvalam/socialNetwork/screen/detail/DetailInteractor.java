package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.Interactor;

/**
 * The Detail interactor
 */
class DetailInteractor extends Interactor<DetailContract.Presenter>
        implements DetailContract.Interactor {

    DetailInteractor(DetailContract.Presenter presenter) {
        super(presenter);
    }
}
