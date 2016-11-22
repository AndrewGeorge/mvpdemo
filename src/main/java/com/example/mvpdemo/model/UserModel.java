package com.example.mvpdemo.model;

import android.os.Handler;
import android.os.Looper;

import com.example.mvpdemo.Bean.BaseRequest;
import com.example.mvpdemo.Bean.LoginResponseData;
import com.example.mvpdemo.ServiceAPI.LoginRequestServiceAPI;
import com.example.mvpdemo.utils.FormateParamsUils;
import com.example.mvpdemo.utils.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class UserModel {
    private Handler handler=new Handler(Looper.getMainLooper());
    public void login(final BaseRequest requestData,final CallBack callBack) {
        Retrofit retrofit = RetrofitBuilder.buildRetrofit();
        LoginRequestServiceAPI requestServes=retrofit.create(LoginRequestServiceAPI.class);
        Call<LoginResponseData> call = requestServes.userLogin(requestData.getOpt(), FormateParamsUils.getParam(requestData));
        call.enqueue(new Callback<LoginResponseData>() {
            @Override
            public void onResponse(Call<LoginResponseData> call,final  Response<LoginResponseData> response) {
                if (response.isSuccessful()){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(response.body());
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<LoginResponseData> call, Throwable t) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFilure("访问失败。。。。。。");
                    }
                });
            }
        });
    }
}
