package com.gemvietnam.hocvalam.socialNetwork.screen.home;

import com.gemvietnam.common.base.BaseActivity;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.screen.feeds.FeedsFragment;

/**
 * Home Activity
 * Created by neo on 7/19/2016.
 */
public class HomeActivity extends BaseActivity<HomeContract.Presenter> implements HomeContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeContract.Presenter onCreatePresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void initLayout() {
        super.initLayout();
        addFeedsFragment();
    }

    private void addFeedsFragment() {
        addFragment(R.id.home_frame, FeedsFragment.getInstance());
    }
}
