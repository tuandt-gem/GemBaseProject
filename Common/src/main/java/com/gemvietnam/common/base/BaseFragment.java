package com.gemvietnam.common.base;

import com.gemvietnam.common.base.log.Logger;
import com.gemvietnam.common.utils.ContextUtils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Base Fragment
 * Created by neo on 3/22/2016.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView<P> {
    private P mPresenter;
    protected View mRootView;
    protected boolean mIsInitialized = false;

    public BaseFragment() {
        // Presenter for this view
        mPresenter = onCreatePresenter();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Presenter for this view
        if (mPresenter == null)
            mPresenter = onCreatePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (!mIsInitialized) {
            mRootView = inflater.inflate(getLayoutId(), container, false);

            // Inject views
            ButterKnife.bind(this, mRootView);
            Logger.e("current fragment: ", this + "");
            // Prepare layout
            initLayout();

            mIsInitialized = true;
        }
        return mRootView;
    }

    /**
     * Return layout resource id for activity
     */
    protected abstract int getLayoutId();


    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public Activity getViewContext() {
        return getActivity();
    }

    @Override
    public BaseActivity getBaseActivity() {
        if (getActivity() instanceof BaseActivity) {
            return (BaseActivity) getActivity();
        } else {
            return null;
        }
    }

    @Override
    public void onRequestError(String errorCode, String errorMessage) {
        if (ContextUtils.isValidContext(getBaseActivity())) {
            getBaseActivity().onRequestError(errorCode, errorMessage);
        }
    }

    @Override
    public void onRequestSuccess() {
        if (ContextUtils.isValidContext(getBaseActivity())) {
            getBaseActivity().onRequestSuccess();
        }
    }

    @Override
    public void showAlertDialog(String message) {
        if (ContextUtils.isValidContext(getBaseActivity())) {
            getBaseActivity().showAlertDialog(message);
        }
    }

    @Override
    public void showProgress() {
        if (getBaseActivity() != null) {
            getBaseActivity().showProgress();
        }
    }

    @Override
    public void hideProgress() {
        if (getBaseActivity() != null) {
            getBaseActivity().hideProgress();
        }
    }

    // Arbitrary value; set it to some reasonable default
//    private static final int DEFAULT_CHILD_ANIMATION_DURATION = 250;
//
//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        final Fragment parent = getParentFragment();
//
//        // Apply the workaround only if this is a child fragment, and the parent
//        // is being removed.
//        if (!enter && parent != null && parent.isRemoving()) {
//            // This is a workaround for the bug where child fragments disappear when
//            // the parent is removed (as all children are first removed from the parent)
//            // See https://code.google.com/p/android/issues/detail?id=55228
//            Animation doNothingAnim = new AlphaAnimation(1, 1);
//            doNothingAnim.setDuration(getNextAnimationDuration(parent, DEFAULT_CHILD_ANIMATION_DURATION));
//            return doNothingAnim;
//        } else {
//            return super.onCreateAnimation(transit, enter, nextAnim);
//        }
//    }

//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        return enter ? AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right_in) : AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right_out);
//    }

//    private static long getNextAnimationDuration(Fragment fragment, long defValue) {
//        try {
//            // Attempt to get the resource ID of the next animation that
//            // will be applied to the given fragment.
//            Field nextAnimField = Fragment.class.getDeclaredField("mNextAnim");
//            nextAnimField.setAccessible(true);
//            int nextAnimResource = nextAnimField.getInt(fragment);
//            Animation nextAnim = AnimationUtils.loadAnimation(fragment.getActivity(), nextAnimResource);
//
//            // ...and if it can be loaded, return that animation's duration
//            return (nextAnim == null) ? defValue : nextAnim.getDuration();
//        } catch (NoSuchFieldException | IllegalAccessException | Resources.NotFoundException ex) {
//            Logger.w("Unable to load next animation from parent." + ex.getMessage());
//            return defValue;
//        }
//    }
}
