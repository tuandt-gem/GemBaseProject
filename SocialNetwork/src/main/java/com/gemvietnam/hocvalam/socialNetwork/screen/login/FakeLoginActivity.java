package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.common.base.BaseActivity;
import com.gemvietnam.common.base.BasePresenter;
import com.gemvietnam.common.view.BaseViewHolder;
import com.gemvietnam.hocvalam.R;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by neo on 7/18/2016.
 */
public class FakeLoginActivity extends BaseActivity {
    @Bind(R.id.rv)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_fake;
    }

    @Override
    public BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public BaseActivity getBaseActivity() {
        return this;
    }

    @Override
    public void initLayout() {
        super.initLayout();

        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account("Account " + i));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setClipToPadding(false);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(new AccountAdapter(accounts));
    }

    class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
        private List<Account> mAccounts;

        private AccountAdapter(List<Account> accounts) {
            mAccounts = accounts;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(FakeLoginActivity.this).inflate(R.layout.item_account_fake, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Account account = getItem(position);

            holder.mNameTv.setText(account.getName());
        }

        Account getItem(int position) {
            return mAccounts.get(position);
        }

        @Override
        public int getItemCount() {
            return mAccounts.size();
        }

        class ViewHolder extends BaseViewHolder {
            @Bind(R.id.item_account_fake_name_tv)
            TextView mNameTv;

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    class Account {
        String mName;

        public Account(String name) {
            mName = name;
        }

        public String getName() {
            return mName;
        }

    }
}
