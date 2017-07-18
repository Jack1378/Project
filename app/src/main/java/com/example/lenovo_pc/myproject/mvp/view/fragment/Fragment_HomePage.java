package com.example.lenovo_pc.myproject.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.NewsData;
import com.example.lenovo_pc.myproject.mvp.presenter.MainPresenter;
import com.example.lenovo_pc.myproject.mvp.view.adapter.RecyclerAdapter;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

import java.util.List;


/**
 * 作者：李飞宇
 * 时间：2017/7/12 12:00
 * 功能：首页页面
 */

public class Fragment_HomePage extends BaseFragment implements IMainView<NewsData> {

    private String url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private RecyclerView recyclerView;
    private MainPresenter mainPresenter;
    private RecyclerAdapter radapter;
    private ImageView RichScan;
    private TextView search;
    private ImageView information;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setMyContentView(), container, false);
        initView(view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        data_loading();

    }

    @Override
    int setMyContentView() {
        return R.layout.frag_home_page;
    }

    @Override
    void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        RichScan = (ImageView) view.findViewById(R.id.RichScan);
        search = (TextView) view.findViewById(R.id.search);
        information = (ImageView) view.findViewById(R.id.information);
    }

    @Override
    public void initData() {
        radapter = new RecyclerAdapter(getActivity());
        recyclerView.setAdapter(radapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void data_loading() {
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.load_data(url, NewsData.class);
    }

    @Override
    public void SucceedCallBack(NewsData newsData) {
        List<NewsData.DataBean> data = newsData.getData();
        radapter.setData(data);
        radapter.notifyDataSetChanged();
    }

    @Override
    public void ErrCallBack(String str, int code) {

    }
}
