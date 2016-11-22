package com.example.mvpdemo.presenter;

import com.example.mvpdemo.model.CallBack;
import com.example.mvpdemo.model.UserModel;
import com.example.mvpdemo.view.LoginView;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class LoginPresenter {
    private UserModel userModel;
    private LoginView loginView;

    public LoginPresenter(UserModel userModel, LoginView loginView) {
        this.userModel=userModel;
        this.loginView=loginView;
    }
    //登录
    public void login(){
        loginView.showLoding("正在登录中....");
        userModel.login(loginView.getRequestData(), new CallBack() {

            @Override
            public void onSuccess(Object object) {
                loginView.showResult(object);
                loginView.hideLoding();
            }
            @Override
            public void onFilure(String fail) {
                loginView.hideLoding();
                loginView.showErr("登录失败");
            }
        });
    }

}
