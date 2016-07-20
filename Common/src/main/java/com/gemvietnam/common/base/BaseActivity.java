package com.gemvietnam.common.base;

import com.gemvietnam.common.R;
import com.gemvietnam.common.utils.ActivityUtils;
import com.gemvietnam.common.utils.DialogUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import butterknife.ButterKnife;

/**
 * Base activity
 * Created by neo on 2/5/2016.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView<T> {
    private T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
        setContentView(getLayoutId());
        // Inject views
        ButterKnife.bind(this);

        // Presenter for this view
        mPresenter = onCreatePresenter();

        // Prepare layout
        initLayout();

    }

    @Override
    public T getPresenter() {
        return mPresenter;
    }

    @Override
    public void initLayout() {
    }

    @Override
    public void showAlertDialog(String message) {
        DialogUtils.showErrorAlert(this, message);
    }

    @Override
    public void showProgress() {
        DialogUtils.showProgressDialog(this);
    }

    @Override
    public void hideProgress() {
        DialogUtils.dismissProgressDialog();
    }

    @Override
    public void onRequestError(String errorCode, String errorMessage) {
        DialogUtils.showErrorAlert(this, errorMessage);
        hideProgress();
    }

    @Override
    public void onRequestSuccess() {
        hideProgress();
    }

    @Override
    public Activity getViewContext() {
        return this;
    }

    @Override
    public BaseActivity getBaseActivity() {
        return this;
    }

    /**
     * Return layout resource id for activity
     */
    protected abstract int getLayoutId();

    /**
     * Hide keyboard of current focus view
     */
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
    }

    /**
     * Show keyboard for {@link EditText}
     */
    public void showKeyboard(EditText editText) {
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public void addFragment(int containerId, BaseFragment fragment, boolean addToBackStack, String tag) {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, containerId, addToBackStack, tag);
    }

    public void addFragment(int containerId, BaseFragment fragment, boolean addToBackStack) {
        addFragment(containerId, fragment, addToBackStack, fragment.getClass().getSimpleName());
    }

    public void addFragment(int containerId, BaseFragment fragment) {
        addFragment(containerId, fragment, false, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentManager manager = getSupportFragmentManager();
        if (manager != null) {
            for (Fragment fragment : manager.getFragments()) {
                if (fragment != null) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }
}
