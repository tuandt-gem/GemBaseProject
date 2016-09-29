package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.base.BaseActivity;
import com.gemvietnam.base.mapper.ModelMapper;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.model.Account;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.AccountDTO;
import com.gemvietnam.hocvalam.socialNetwork.screen.home.HomeActivity;
import com.gemvietnam.utils.ActivityUtils;
import com.gemvietnam.utils.RecyclerUtils;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Fake login
 * Created by neo on 7/18/2016.
 */
public class FakeLoginActivity extends BaseActivity implements AccountAdapter.ItemListener, OnMoreListener {
    private AccountAdapter mAccountAdapter;

    @Bind(R.id.srv)
    SuperRecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_fake;
    }


    @Override
    public void initLayout() {
        super.initLayout();

        RecyclerUtils.setupVerticalRecyclerView(this, mRecyclerView.getRecyclerView());
        mRecyclerView.setAdapter(getAccountAdapter());

        // Fetch data
        getAccounts();
        mRecyclerView.setOnMoreListener(this);
    }

    public void getAccounts() {
        List<AccountDTO> accountDTOs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accountDTOs.add(new AccountDTO("Account " + i));
        }
        List<Account> accounts = ModelMapper.mapList(accountDTOs, Account.class);

        mAccountAdapter.setItems(accounts);
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

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {

    }
}
