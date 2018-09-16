package com.danielleonett.androidbase.ui;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author daniel.leonett
 */

public abstract class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    private static final String TAG = BasePresenter.class.getSimpleName();

    private V mMvpView;
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onAttach(V mvpView) {
        Log.d(TAG, "onAttach()");

        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach()");

        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

}