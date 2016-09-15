package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.base.BaseActivity;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Account;
import com.gemvietnam.hocvalam.socialNetwork.screen.home.HomeActivity;
import com.gemvietnam.utils.ActivityUtils;
import com.gemvietnam.utils.CollectionUtils;
import com.gemvietnam.hocvalam.socialNetwork.R;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Fake login
 * Created by neo on 7/18/2016.
 */
public class FakeLoginActivity extends BaseActivity implements AccountAdapter.ItemListener {
    private AccountAdapter mAccountAdapter;

    @Bind(R.id.rv)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_fake;
    }


    @Override
    public void initLayout() {
        super.initLayout();

        CollectionUtils.setupVerticalRecyclerView(this, mRecyclerView);
        mRecyclerView.setAdapter(getAccountAdapter());

        // Fetch data

        getAccounts();
    }

    public void getAccounts() {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account("Account " + i));
        }

        mAccountAdapter.setAccounts(accounts);
        mAccountAdapter.notifyDataSetChanged();
    }

    public AccountAdapter getAccountAdapter() {
        if (mAccountAdapter == null) {
            mAccountAdapter = createAccountAdapter();
        }

        return mAccountAdapter;
    }

    private AccountAdapter createAccountAdapter() {
        return new AccountAdapter(this, this);
    }

    @Override
    public void onItemClicked(Account account) {
        Account.setInstance(account);
        ActivityUtils.startActivity(this, HomeActivity.class);
    }
}
