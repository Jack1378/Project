package com.example.lenovo_pc.myproject.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo_pc.myproject.R;

/**
 * 作者：李飞宇
 * 时间：2017/7/12 14:00
 * 功能：分类页面
 */

public class Fragment_Classify extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setMyContentView(), container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    int setMyContentView() {
        return R.layout.frag_classify;
    }

    @Override
    void initView(View view) {

    }

    @Override
    void initData() {

    }

    @Override
    void data_loading() {

    }
}
