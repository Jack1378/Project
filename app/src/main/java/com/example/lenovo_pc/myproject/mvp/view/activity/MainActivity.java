package com.example.lenovo_pc.myproject.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.model.bean.NewsData;
import com.example.lenovo_pc.myproject.mvp.presenter.MainPresenter;
import com.example.lenovo_pc.myproject.mvp.view.fragment.Fragment_Classify;
import com.example.lenovo_pc.myproject.mvp.view.fragment.Fragment_HomePage;
import com.example.lenovo_pc.myproject.mvp.view.fragment.Fragment_User;
import com.example.lenovo_pc.myproject.mvp.view.fragment.Frament_Shopping_Cart;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

import java.util.ArrayList;
import java.util.List;

/**
 * V层
 */
public class MainActivity extends BaseActivity implements /*IMainView<NewsData>,*/ View.OnClickListener {
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
/*    private MainPresenter mainPresenter;*/
    private FrameLayout fragment;
    private RadioGroup Radio_Group;
    private FragmentTransaction transaction;
    private Fragment_HomePage f_homePage;
    private Fragment_Classify f_classify;
    private Fragment_User f_user;
    private Frament_Shopping_Cart f_shopping_cart;
    private List<Fragment> F_List = new ArrayList<>();
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 找布局文件
     *
     * @return
     */
    @Override
    int setMyContentView() {
        return R.layout.activity_main;
    }

    /**
     * 找控件
     */
    @Override
    public void initView() {

        fragment = (FrameLayout) findViewById(R.id.fragment);
        fragment.setOnClickListener(this);
        Radio_Group = (RadioGroup) findViewById(R.id.Radio_Group);
        Radio_Group.setOnClickListener(this);
    }

    /**
     * 适配
     */
    @Override
    public void initData() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        f_homePage = new Fragment_HomePage();
        f_classify = new Fragment_Classify();
        f_shopping_cart = new Frament_Shopping_Cart();
        f_user = new Fragment_User();

        F_List.add(f_homePage);
        F_List.add(f_classify);
        F_List.add(f_shopping_cart);
        F_List.add(f_user);

        transaction.add(R.id.fragment, F_List.get(0));
        transaction.add(R.id.fragment, F_List.get(1));
        transaction.add(R.id.fragment, F_List.get(2));
        transaction.add(R.id.fragment, F_List.get(3));
        transaction.show(F_List.get(0)).hide(F_List.get(1)).hide(F_List.get(2)).hide(F_List.get(3));
        transaction.commit();

        Radio_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                RadioButton rb = radioGroup.findViewById(checkedId);
                int tag = Integer.parseInt(rb.getTag().toString());
                FragmentTransaction transaction1 = manager.beginTransaction();
                for (int i = 0; i < F_List.size(); i++) {
                    if (tag == i) {
                        transaction1.show(F_List.get(i));
                    } else {
                        transaction1.hide(F_List.get(i));
                    }
                }
                transaction1.commit();
            }
        });
    }

    /**
     * 和P层进行关联 进行网络加载
     */
    @Override
    public void data_loading() {
/*        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.load_data(url, NewsData.class);*/
    }
/*
    @Override
    public void SucceedCallBack(NewsData newsData) {

    }

    @Override
    public void ErrCallBack(String str, int code) {

    }*/

    //点击事件
    @Override
    public void onClick(View view) {

    }
}
