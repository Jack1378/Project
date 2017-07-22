package com.example.lenovo_pc.myproject.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.ClassifyBean;
import com.example.lenovo_pc.myproject.mvp.presenter.MainPresenter;
import com.example.lenovo_pc.myproject.mvp.view.adapter.RecyclerAdapter2;
import com.example.lenovo_pc.myproject.mvp.view.adapter.RecyclerSecondAdapter;
import com.example.lenovo_pc.myproject.mvp.view.adapter.RecyclerThridAdapter;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/7/12 14:00
 * 功能：分类页面
 */

public class Fragment_Classify extends BaseFragment implements IMainView<ClassifyBean> {
    //分类的接口
    private String url = "http://169.254.116.130/mobile/index.php?act=goods_class ";
    //分类的二级列表和三级列表的参数的数据
    private String url2 = "http://169.254.116.130/mobile/index.php?act=goods_class&gc_id=";
    private ImageView RichScan;
    private TextView search;
    private ImageView information;
    private RecyclerView First_Classify;
    private RecyclerView Second_Classify;
    private MainPresenter mainPresenter;
    private RecyclerAdapter2 adapter2;
    private static final String TAG = "Fragment_Classify";
    private RecyclerSecondAdapter recyclerSecondAdapter;

    private List<ClassifyBean.DatasBean.ClassListBean> class_list = new ArrayList<>();
    private List<ClassifyBean.DatasBean.ClassListBean> class_list2 = new ArrayList<>();
    private List<ClassifyBean.DatasBean.ClassListBean> class_list3 = new ArrayList<>();
    private RecyclerSecondAdapter secondAdapter;
    private RecyclerView Third_Classify;

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

    }

    @Override
    int setMyContentView() {
        return R.layout.frag_classify;
    }

    @Override
    void initView(View view) {
        RichScan = (ImageView) view.findViewById(R.id.RichScan);
        RichScan.setOnClickListener(this);
        search = (TextView) view.findViewById(R.id.search);
        search.setOnClickListener(this);
        information = (ImageView) view.findViewById(R.id.information);
        information.setOnClickListener(this);
        First_Classify = (RecyclerView) view.findViewById(R.id.First_Classify);
        First_Classify.setOnClickListener(this);
        Second_Classify = (RecyclerView) view.findViewById(R.id.Second_Classify);
        Second_Classify.setOnClickListener(this);
        Third_Classify = (RecyclerView) view.findViewById(R.id.Third_Classify);
        Third_Classify.setOnClickListener(this);
    }

    @Override
    void initData() {
        //一级列表适配器
        adapter2 = new RecyclerAdapter2(getContext());
        First_Classify.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        First_Classify.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        First_Classify.setAdapter(adapter2);
        //一级列表的RecyclerView的点击事件
        adapter2.setOnItemClickListener(new RecyclerAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(getActivity(), class_list.get(position).getGc_name(),
//                        Toast.LENGTH_SHORT).show();

                MainPresenter mPersenter = new MainPresenter();
                mPersenter.attachView(Fragment_Classify.this);
                mPersenter.load_data(url2 + class_list.get(position).getGc_id(), ClassifyBean.class, 1);
            }
        });

    }

    @Override
    void data_loading() {
        //首页列表
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.load_data(url, ClassifyBean.class, 0);
    }

    @Override
    public void SucceedCallBack(ClassifyBean classifyBean, int i) {
        switch (i) {
            case 0:
                class_list = classifyBean.getDatas().getClass_list();
                adapter2.setData(class_list);
                break;
            case 1:
                class_list2.clear();
                List<ClassifyBean.DatasBean.ClassListBean> class1 = classifyBean.getDatas().getClass_list();
                class_list2.addAll(class1);

                secondAdapter = new RecyclerSecondAdapter(getContext());
                secondAdapter.setData(class_list2);

                //二级类表的适配器
                secondAdapter.setOnItemClickListener(new RecyclerSecondAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        MainPresenter mainPresenter2 = new MainPresenter();
                        mainPresenter2.attachView(Fragment_Classify.this);
                        mainPresenter2.load_data(url2 + class_list2.get(position).getGc_id(), ClassifyBean.class, 2);

                    }
                });

                Second_Classify.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                Second_Classify.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                Second_Classify.setAdapter(secondAdapter);

                break;
            case 2:
                //三级列表
                class_list3.clear();
                List<ClassifyBean.DatasBean.ClassListBean> class_list = classifyBean.getDatas().getClass_list();
                class_list3.addAll(class_list);

                RecyclerThridAdapter thridAdapter = new RecyclerThridAdapter(getContext());
                thridAdapter.setData(class_list3);

                Third_Classify.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                Third_Classify.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

                Third_Classify.setAdapter(thridAdapter);
                break;
        }
    }

    @Override
    public void SucceedCallBack1(ClassifyBean classifyBean, int i) {

    }

    @Override
    public void ErrCallBack(String str, int code) {
        Log.e(TAG, "ErrCallBack: " + str.toString());
    }

}
