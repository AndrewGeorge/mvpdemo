package com.example.mvpdemo.Bean;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class LoginRequest extends BaseRequest {
    String tel;
    String password;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
