package com.example.lenovo_pc.myproject.mvp.presenter;

/**
 * 作者：李飞宇
 * 时间：2017/7/12 09:52
 * 功能：自定义的Presenter的基类
 */

public class BasePresenter<V> {

    private V mV;

    //给传过来的值赋值
    public void attachView(V v) {
        this.mV = v;
    }

    //返回传过来的值
    public V getMvpView() {
        return mV;
    }

    //制空
    public void dettachView() {
        mV = null;
    }
}
