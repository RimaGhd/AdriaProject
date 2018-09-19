package com.example.rima.AdriaProject.Models;

import com.example.rima.AdriaProject.Presenters.LoginActivityPresenter;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

/**
 * Created by rima on 19/09/2018.
 */

public class LoginActivityModel {


    public void LoginWithFacebook(CallbackManager callbackManager, final LoginActivityPresenter presenter) {


        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // if the user successfully loged in we will send him to the albums screen
              presenter.success();
            }

            @Override
            public void onCancel() {
                presenter.cancel();
            }

            @Override
            public void onError(FacebookException exception) {
                presenter.error();
            }
        });
    }
}
