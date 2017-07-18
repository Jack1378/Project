package com.example.lenovo_pc.myproject.mvp.model.utils;

/**
 * 作者：李飞宇
 * 时间：2017/7/11 20:30
 * 功能：自定义一个接口 传要解析的Bean类（M层）
 */

public interface RequestDataCallBack<T> {
    //成功
    void SucceedBack(T t);

    //失败
    void ErrBack(String err, int code);

}
