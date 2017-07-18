package com.example.lenovo_pc.myproject.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo_pc.myproject.R;

/**
 * 作者：李飞宇
 * 时间：2017/7/17 20:32
 * 功能：注册用户页面
 */

public class RegisterAcytivity extends BaseActivity implements View.OnClickListener {

    private ImageView Register_go_back;
    private EditText Edit_User;
    private EditText Edit_Password;
    private EditText Edit_Password_Twice;
    private EditText User_Email;
    private Button User_Register;

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
            //返回
            case R.id.Register_go_back:
                break;
            //注册
            case R.id.User_Register:
                submit();

                break;

        }
    }

    /**
     * 注册判断
     */
    private void submit() {
        // validate
        String User = Edit_User.getText().toString().trim();
        if (TextUtils.isEmpty(User)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (User.length() < 4) {
            Toast.makeText(this, "账号不能小于4个字符", Toast.LENGTH_SHORT).show();
        }

        String Password = Edit_Password.getText().toString().trim();
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Password.length() < 8) {
            Toast.makeText(this, "密码不能小于8个字符", Toast.LENGTH_SHORT).show();
        }

        String Twice = Edit_Password_Twice.getText().toString().trim();
        if (TextUtils.isEmpty(Twice)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Twice.equals(Password)) {
            Toast.makeText(this, "两次输入密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
        }

        String Email = User_Email.getText().toString().trim();
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(this, "请输入邮箱地址", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Email.contains("@") || !Email.contains(".com")) {
            Toast.makeText(this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
        }
        // TODO validate success, do something

    }
}
