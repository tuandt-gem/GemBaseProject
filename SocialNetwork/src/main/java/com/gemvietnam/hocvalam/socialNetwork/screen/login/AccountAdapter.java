package com.gemvietnam.hocvalam.socialNetwork.screen.login;

import com.gemvietnam.base.adapter.RecyclerBaseAdapter;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Account;
import com.gemvietnam.widget.BaseViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;


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
    public void bindView(final Account account, final int position) {
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
    void onItemClicked(Account account);
  }
}