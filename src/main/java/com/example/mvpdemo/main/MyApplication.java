package com.example.mvpdemo.main;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class MyApplication extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        this.mContext=this;
        super.onCreate();
    }
}
