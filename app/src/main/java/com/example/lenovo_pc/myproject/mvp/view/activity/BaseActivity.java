package com.example.lenovo_pc.myproject.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：李飞宇
 * 时间：2017/7/12 09:43
 * 功能：自定义的Activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setMyContentView());
        initView();
        initData();
        data_loading();
    }
    //找布局
    abstract int setMyContentView();

    //找控件
    abstract void initView();

    //适配器
    abstract void initData();

    //加载网络数据
    abstract void data_loading();

}
