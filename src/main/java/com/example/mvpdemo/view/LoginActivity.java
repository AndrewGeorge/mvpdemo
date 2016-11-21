package com.example.mvpdemo.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.UserModel;
import com.example.mvpdemo.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/11/21 0021.
 */

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {


    @InjectView(R.id.username)
    EditText password_et;

    @InjectView(R.id.password)
    EditText username_et;

    @InjectView(R.id.login)
    Button login;

    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        initData();
        initView();
    }

    private void initData() {
        loginPresenter = new LoginPresenter(new UserModel(), this);
    }

    private void initView() {
        progressDialog=new ProgressDialog(this);
        login.setOnClickListener(this);
    }

    @Override
    public void showLoding(String msg) {
        progressDialog.setMessage(msg);
        if(!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void hideLoding() {
        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return username_et.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password_et.getText().toString().trim();
    }

    private void login() {
        loginPresenter.login();
    }

    @Override
    protected void onDestroy() {
        if (loginPresenter != null) {
            loginPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                login();
                break;
        }
    }
}
