package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.common.base.BasePresenterImpl;
import com.gemvietnam.common.utils.ActivityUtils;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Account;
import com.gemvietnam.hocvalam.socialNetwork.screen.feeds.FeedsFragment;
import com.gemvietnam.hocvalam.socialNetwork.screen.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Login presenter
 * Created by neo on 7/19/2016.
 */
public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter, AccountAdapter.ItemListener {
    private AccountAdapter mAccountAdapter;

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void getAccounts() {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account("Account " + i));
        }

        mAccountAdapter.setAccounts(accounts);
        mAccountAdapter.notifyDataSetChanged();
    }

    @Override
    public AccountAdapter getAccountAdapter() {
        if (mAccountAdapter == null) {
            mAccountAdapter = createAccountAdapter();
        }

        return mAccountAdapter;
    }

    @Override
    public void onItemClicked(Account account) {
        ActivityUtils.startActivity(mView.getViewContext(), HomeActivity.class);
    }

    private AccountAdapter createAccountAdapter() {
        return new AccountAdapter(mView.getBaseActivity(), this);
    }


}
