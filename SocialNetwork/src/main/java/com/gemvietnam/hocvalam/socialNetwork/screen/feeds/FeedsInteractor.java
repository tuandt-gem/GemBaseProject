package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.Interactor;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;
import com.gemvietnam.base.mapper.ModelMapper;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.FeedDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Feeds interactor
 * Created by neo on 9/15/2016.
 */
class FeedsInteractor extends Interactor<FeedsContract.Presenter> implements FeedsContract
        .Interactor {

    FeedsInteractor(FeedsContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getFeeds() {
        List<FeedDTO> feedDTOs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            feedDTOs.add(FeedDTO.getInstance());
        }

        // Map DTO to Model
        List<Feed> feeds = ModelMapper.mapList(feedDTOs, Feed.class);

        mPresenter.onFeedsLoaded(feeds);
    }
}
