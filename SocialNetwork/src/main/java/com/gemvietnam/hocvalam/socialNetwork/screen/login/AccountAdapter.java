package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.base.adapter.RecyclerBaseAdapter;
import com.gemvietnam.hocvalam.socialNetwork.model.Account;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.AccountDTO;
import com.gemvietnam.widget.BaseViewHolder;
import com.gemvietnam.hocvalam.socialNetwork.R;

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
class AccountAdapter extends RecyclerBaseAdapter<Account, AccountAdapter.ViewHolder> {
    private ItemListener mItemListener;

    AccountAdapter(Context context, ItemListener itemListener) {
        super(context);
        mItemListener = itemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflateView(parent, R.layout.item_account_fake));
    }

    class ViewHolder extends BaseViewHolder<Account> {
        @Bind(R.id.item_account_fake_name_tv)
        TextView mNameTv;

        ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindView(final Account account) {
            mNameTv.setText(account.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemListener != null) mItemListener.onItemClicked(account);
                }
            });
        }
    }

    interface ItemListener {
        void onItemClicked(Account accountDTO);
    }
}