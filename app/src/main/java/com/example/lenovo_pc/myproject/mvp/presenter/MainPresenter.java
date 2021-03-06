package com.example.lenovo_pc.myproject.mvp.presenter;

import android.util.Log;

import com.example.lenovo_pc.myproject.mvp.model.bean.RegisterBean;
import com.example.lenovo_pc.myproject.mvp.model.utils.HttpUtils;
import com.example.lenovo_pc.myproject.mvp.model.utils.RequestDataCallBack;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

/**
 * 作者：李飞宇
 * 时间：2017/7/11 20:54
 * 功能：P层
 * V层告诉P层需要的东西,P层需要去找M层要V层需要的东西
 */

public class MainPresenter<T> extends BasePresenter<IMainView> {
    private HttpUtils httpUtils;
    private static final String TAG = "MainPresenter";
    private int code;
    private int i;

    public <T> void load_data(String url, Class<T> tClass, final int i) {
        this.i = i;
        httpUtils = new HttpUtils();
        httpUtils.request_data(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(T o) {
                getMvpView().SucceedCallBack(o, i);
                Log.e(TAG, "SucceedBack: " + o);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
                Log.e(TAG, "ErrBack: " + err);
            }
        }, tClass);
    }

}
