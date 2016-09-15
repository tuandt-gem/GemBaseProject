package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.view.BaseViewHolder;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Account;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Accounts adapter
 * Created by neo on 7/19/2016.
 */
public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    private List<Account> mAccounts = new ArrayList<>();
    private Context mContext;
    private ItemListener mItemListener;

    public AccountAdapter(Context context, ItemListener itemListener) {
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_account_fake, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Account account = getItem(position);

        holder.mNameTv.setText(account.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemListener != null) mItemListener.onItemClicked(account);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAccounts.size();
    }

    public Account getItem(int position) {
        return mAccounts.get(position);
    }

    public void setAccounts(List<Account> accounts) {
        mAccounts.clear();
        mAccounts.addAll(checkNotNull(accounts));
    }

    class ViewHolder extends BaseViewHolder {
        @Bind(R.id.item_account_fake_name_tv)
        TextView mNameTv;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface ItemListener {
        void onItemClicked(Account account);
    }
}