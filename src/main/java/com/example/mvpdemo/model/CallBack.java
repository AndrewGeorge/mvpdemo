package com.example.mvpdemo.model;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public interface CallBack {
    /**
     * model处理逻辑：成功回调
     */
    void onSuccess();
    /**
     * model处理逻辑：失败回调
     */
    void onFilure(String fail);
}
