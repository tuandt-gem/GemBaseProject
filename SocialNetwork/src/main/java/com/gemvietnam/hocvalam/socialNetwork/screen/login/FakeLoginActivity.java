package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.common.base.BaseActivity;
import com.gemvietnam.common.utils.CollectionUtils;
import com.gemvietnam.hocvalam.socialNetwork.R;

import android.support.v7.widget.RecyclerView;

import butterknife.Bind;

/**
 * Fake login
 * Created by neo on 7/18/2016.
 */
public class FakeLoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {
    @Bind(R.id.rv)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_fake;
    }

    @Override
    public LoginContract.Presenter onCreatePresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void initLayout() {
        super.initLayout();

        CollectionUtils.setupVerticalRecyclerView(this, mRecyclerView);
        mRecyclerView.setAdapter(getPresenter().getAccountAdapter());

        // Fetch data
        getPresenter().getAccounts();
    }
}
