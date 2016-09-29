package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.R;
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
    public void viewFeedDetail(DetailContract.ViewModel detailViewModel) {
        mTitleTv.setText(detailViewModel.getTitle());
        mContentTv.setText(detailViewModel.getContent());
        ImageUtils.loadImage(getActivity(), detailViewModel.getAvatarUrl(), mAvatar);
    }
}
