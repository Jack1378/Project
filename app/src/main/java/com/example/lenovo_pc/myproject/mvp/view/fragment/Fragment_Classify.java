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

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.ClassifyBean;
import com.example.lenovo_pc.myproject.mvp.model.bean.ClassifySecondBean;
import com.example.lenovo_pc.myproject.mvp.model.bean.ClassifyThirdBean;
import com.example.lenovo_pc.myproject.mvp.presenter.MainPresenter;
import com.example.lenovo_pc.myproject.mvp.view.adapter.RecyclerAdapter2;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

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
    private List<ClassifyBean.DatasBean.ClassListBean> class_list;
    private int i = 0;
    private String gc_id;

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
    }

    @Override
    void initData() {
        adapter2 = new RecyclerAdapter2(getContext());
        First_Classify.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        First_Classify.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        First_Classify.setAdapter(adapter2);
    }

    @Override
    void data_loading() {
        //首页列表
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.load_data(url, ClassifyBean.class, 1);
//        //二级列表
//        mainPresenter.load_data1(url2 + gc_id, ClassifySecondBean.class);
//        //三级列表
//        mainPresenter.load_data2(url2, ClassifyThirdBean.class);

    }

    @Override
    public void SucceedCallBack(ClassifyBean classifyBean, int i) {

//        Log.e(TAG, "SucceedCallBack: " + class_list.get(i).getGc_id());
        switch (i) {
            case 1:
                class_list = classifyBean.getDatas().getClass_list();
                adapter2.setData(class_list);
                //得到二级列表的参数
                gc_id = class_list.get(0).getGc_id();

//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mainPresenter.load_data(url2 + gc_id, ClassifySecondBean.class, 2);
//                    }
//                });


                break;
            case 2:

                break;
            case 3:

                break;
        }


    }

    @Override
    public void ErrCallBack(String str, int code) {
        Log.e(TAG, "ErrCallBack: " + str.toString());
    }
}
