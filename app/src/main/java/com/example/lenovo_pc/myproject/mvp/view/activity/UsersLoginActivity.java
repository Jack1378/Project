package com.example.lenovo_pc.myproject.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.LoginBean;
import com.example.lenovo_pc.myproject.mvp.model.bean.NewsData;
import com.example.lenovo_pc.myproject.mvp.presenter.MainPresenter;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

import java.util.List;
import java.util.logging.Handler;

/**
 * 作者：李飞宇
 * 时间：2017/7/13 21:03
 * 功能：用户登录页面
 */

public class UsersLoginActivity extends BaseActivity implements View.OnClickListener, IMainView<LoginBean> {
    private static final String TAG = "UsersLoginActivity";
    //登录的接口
    private String url = "http://169.254.116.130/mobile/index.php?act=login";
    private ImageView go_back;
    private EditText UserName;
    private EditText UserPassword;
    private Button UserRegister;
    private TextView UserRegisterAccount;
    private TextView UserForgetPassword;
    private String userNameString;
    private String userPasswordString;
    private LoginBean loginBean1;
    private int code1;

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
                MainPresenter presenter = new MainPresenter();
                presenter.attachView(this);
                presenter.load_post_Login(url, LoginBean.class, userNameString, userPasswordString);

                break;
            case R.id.UserRegisterAccount:
                //注册 跳转到注册页面
                Intent intent2 = new Intent(UsersLoginActivity.this, RegisterAcytivity.class);
                startActivity(intent2);
                break;
            case R.id.UserForgetPassword:
                //找回密码
                break;
        }
    }

    private void submit() {
        // validate
        userNameString = UserName.getText().toString().trim();
        if (TextUtils.isEmpty(userNameString)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        userPasswordString = UserPassword.getText().toString().trim();
        if (TextUtils.isEmpty(userPasswordString)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
    }

    @Override
    public void SucceedCallBack(LoginBean loginBean,int i) {
        loginBean1 = loginBean;
        Log.e(TAG, "SucceedCallBack: " + code1);
        Log.e(TAG, "SucceedCallBack: " + loginBean.toString());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (loginBean1 != null) {
                    code1 = loginBean1.getCode();
                    if (code1 == 200) {
                        Toast.makeText(UsersLoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        //登录成功后跳转到主页面
                        Intent intent = new Intent(UsersLoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(UsersLoginActivity.this, "登陆失败，请从新输入。", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

//        loginBean1 = loginBean;
//        List<LoginBean.DatasBean> data = loginBean.getDatas()
//        radapter.setData(data);
    }

    @Override
    public void ErrCallBack(String str, int code) {

    }
}
