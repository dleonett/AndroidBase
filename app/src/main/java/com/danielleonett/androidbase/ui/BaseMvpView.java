package com.danielleonett.androidbase.ui;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * @author daniel.leonett
 *
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface BaseMvpView {

    Context getAppContext();

    void showLoading(@StringRes int resId);

    void showLoading(@StringRes int resId, Object... objects);

    void showLoading(String message);

    void hideLoading();

    void showToast(@StringRes int resId, Object... objects);

    void showToast(String message);

    void showLongToast(@StringRes int resId, Object... objects);

    void showLongToast(String message);

    void showGeneralSnackbar(@StringRes int resId);

    void showGeneralSnackbar(String message);

    void hideGeneralSnackbar();

    void showNoConnectivitySnackbar();

    void hideNoConnectivitySnackbar();

}