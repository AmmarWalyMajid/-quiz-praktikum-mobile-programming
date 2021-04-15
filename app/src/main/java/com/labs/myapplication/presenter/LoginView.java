package com.labs.myapplication.presenter;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
