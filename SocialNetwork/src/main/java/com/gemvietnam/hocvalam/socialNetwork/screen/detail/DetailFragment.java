package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;
import com.gemvietnam.utils.image.ImageUtils;

import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;

/**
 * The Detail Fragment
 */
public class DetailFragment extends ViewFragment<DetailContract.Presenter> implements DetailContract.View {
    @Bind(R.id.avatar_iv)
    ImageView mAvatar;
    @Bind(R.id.title_tv)
    TextView mTitleTv;
    @Bind(R.id.content_tv)
    TextView mContentTv;

    public static DetailFragment getInstance() {
        return new DetailFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    public void viewFeedDetail(Feed feed) {
        mTitleTv.setText(feed.getName());
        mContentTv.setText(feed.getContent());
        ImageUtils.loadImage(getActivity(), feed.getAvatar(), mAvatar);
    }
}
