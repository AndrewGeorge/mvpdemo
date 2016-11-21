package com.example.mvpdemo.view;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public interface LoginView {
    /**
     * 显示进度条
     * @param msg   进度条加载内容
     */
    void showLoding(String msg);
    /**
     * 隐藏进度条
     */
    void  hideLoding();
    /**
     * 显示登录的结果
     * @param result
     */
    void showResult(String result);
    /**
     * 显示加载错误
     * @param err 错误内容
     */
    void showErr(String err);
    /**
     * 获得界面上用户名的值
     * @return
     */
    String getUsername();
    /**
     * 获得界面上密码的值
     * @return
     */
    String getPassword();
}
