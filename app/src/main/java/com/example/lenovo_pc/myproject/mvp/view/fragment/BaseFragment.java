package com.example.lenovo_pc.myproject.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

/**
 * 作者：李飞宇
 * 时间：2017/7/12 15:01
 * 功能：
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setMyContentView(), container, false);
        initView(view);
        onClick(view);
        initData();
        data_loading();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //找布局
    abstract int setMyContentView();

    //找控件
    abstract void initView(View view);

    //
    abstract void initData();

    public void onClick(View view) {

    }
    abstract void data_loading();

}
