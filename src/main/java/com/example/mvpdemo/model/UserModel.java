package com.example.mvpdemo.model;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class UserModel {
    private Handler handler=new Handler(Looper.getMainLooper());
    //处理登录事件
    public void login(final String username,final  String password,final  CallBack callBack){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                if(username.equals("123")&&password.equals("123"))
                    callBack.onSuccess();
                else
                    callBack.onFilure("帐号或者密码错误");

            }
        },2000);
    }
}
