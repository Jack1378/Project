package com.example.lenovo_pc.myproject.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo_pc.myproject.R;

/**
 * 作者：李飞宇
 * 时间：2017/7/13 21:03
 * 功能：用户登录页面
 */

public class UsersLoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView go_back;
    private EditText UserName;
    private EditText UserPassword;
    private Button UserRegister;
    private TextView UserRegisterAccount;
    private TextView UserForgetPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 找到xml布局文件
     *
     * @return
     */
    @Override
    int setMyContentView() {
        return R.layout.user_register;
    }

    @Override
    void initView() {
        UserName = (EditText) findViewById(R.id.UserName);
        UserName.setOnClickListener(this);
        UserPassword = (EditText) findViewById(R.id.UserPassword);
        UserPassword.setOnClickListener(this);
        UserRegister = (Button) findViewById(R.id.UserRegister);
        UserRegister.setOnClickListener(this);
        UserRegisterAccount = (TextView) findViewById(R.id.UserRegisterAccount);
        UserRegisterAccount.setOnClickListener(this);
        UserForgetPassword = (TextView) findViewById(R.id.UserForgetPassword);
        UserForgetPassword.setOnClickListener(this);
    }

    @Override
    void initData() {

    }

    @Override
    void data_loading() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.UserRegister:
                //登录
                submit();

                break;
            case R.id.UserRegisterAccount:
                //注册 跳转到注册页面
                Intent intent = new Intent(UsersLoginActivity.this, RegisterAcytivity.class);
                startActivity(intent);
                break;
            case R.id.UserForgetPassword:
                //找回密码
                break;
        }
    }

    private void submit() {
        // validate
        String UserNameString = UserName.getText().toString().trim();
        if (TextUtils.isEmpty(UserNameString)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String UserPasswordString = UserPassword.getText().toString().trim();
        if (TextUtils.isEmpty(UserPasswordString)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
    }
}
