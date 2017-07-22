package com.example.lenovo_pc.myproject.mvp.view.iview;

/**
 * 作者：李飞宇
 * 时间：2017/7/11 19:55
 * 功能：自定义接口
 */

public interface IMainView<T> {
    //成功
    void SucceedCallBack(T t,int i);
    void SucceedCallBack1(T t,int i);

    //失败
    void ErrCallBack(String str, int code);
}
