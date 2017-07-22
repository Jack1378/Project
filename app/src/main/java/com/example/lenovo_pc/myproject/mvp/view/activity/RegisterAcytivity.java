package com.example.lenovo_pc.myproject.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.RegisterBean;
import com.example.lenovo_pc.myproject.mvp.model.utils.HttpUtils;
import com.example.lenovo_pc.myproject.mvp.presenter.MainPresenter;
import com.example.lenovo_pc.myproject.mvp.presenter.RegisterPersebter;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

/**
 * 作者：李飞宇
 * 时间：2017/7/17 20:32
 * 功能：注册用户页面  V层
 */

public class RegisterAcytivity extends BaseActivity implements View.OnClickListener, IMainView<RegisterBean> {
    //注册的接口
    private String url = "http://169.254.116.130/mobile/index.php?act=login&op=register";
    private ImageView Register_go_back;
    private EditText Edit_User;
    private EditText Edit_Password;
    private EditText Edit_Password_Twice;
    private EditText User_Email;
    private Button User_Register;
    private String user;
    private String password;
    private String twice;
    private String email;
    private RegisterPersebter presenter1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    int setMyContentView() {

        return R.layout.user_register_account;
    }

    @Override
    void initView() {
        //返回
        Register_go_back = (ImageView) findViewById(R.id.Register_go_back);
        Register_go_back.setOnClickListener(this);
        //输入用户名
        Edit_User = (EditText) findViewById(R.id.Edit_User);
        Edit_User.setOnClickListener(this);
        //输入密码
        Edit_Password = (EditText) findViewById(R.id.Edit_Password);
        Edit_Password.setOnClickListener(this);
        //再次输入密码
        Edit_Password_Twice = (EditText) findViewById(R.id.Edit_Password_Twice);
        Edit_Password_Twice.setOnClickListener(this);
        //输入邮箱
        User_Email = (EditText) findViewById(R.id.User_Email);
        User_Email.setOnClickListener(this);
        //注册
        User_Register = (Button) findViewById(R.id.User_Register);
        User_Register.setOnClickListener(this);
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
            //返回到登录页面
            case R.id.Register_go_back:
                Intent intent = new Intent(RegisterAcytivity.this, UsersLoginActivity.class);
                startActivity(intent);
                break;
            //注册
            case R.id.User_Register:
                submit();
                //V-P-M
                presenter1 = new RegisterPersebter();
                presenter1.attachView(this);
                presenter1.load_post(url, RegisterBean.class, user, password, email);
                Toast.makeText(RegisterAcytivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /**
     * 注册判断
     */
    private void submit() {
        // validate
        user = Edit_User.getText().toString().trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (user.length() < 4) {
            Toast.makeText(this, "账号不能小于4个字符", Toast.LENGTH_SHORT).show();
        }

        password = Edit_Password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "密码不能小于6个字符", Toast.LENGTH_SHORT).show();
        }

        twice = Edit_Password_Twice.getText().toString().trim();
        if (TextUtils.isEmpty(twice)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!twice.equals(password)) {
            Toast.makeText(this, "两次输入密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
        }

        email = User_Email.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "请输入邮箱地址", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!email.contains("@") || !email.contains(".com")) {
            Toast.makeText(this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
        }
        // TODO validate success, do something

    }

    @Override
    public void SucceedCallBack(RegisterBean registerBean,int i) {

    }

    @Override
    public void SucceedCallBack1(RegisterBean registerBean, int i) {

    }

    @Override
    public void ErrCallBack(String str, int code) {

    }
}
