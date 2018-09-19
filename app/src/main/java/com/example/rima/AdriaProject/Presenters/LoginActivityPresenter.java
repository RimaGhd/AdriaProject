package com.example.rima.AdriaProject.Presenters;

import com.example.rima.AdriaProject.Interfaces.LoginActivityView;
import com.example.rima.AdriaProject.Models.LoginActivityModel;
import com.facebook.CallbackManager;

/**
 * Created by rima on 19/09/2018.
 */

public class LoginActivityPresenter {

     LoginActivityView view;
     LoginActivityModel model;

     public LoginActivityPresenter(LoginActivityView view ){
         this.view=view;
         model=new LoginActivityModel();

    }

    public void LoginWithFacebook(CallbackManager callbackManager){
         model.LoginWithFacebook(callbackManager,this);
    }

    public  void success(){

         view.success();
    }

    public void cancel(){
        view.cancel();
    }

    public void error(){
        view.error();
    }
}
