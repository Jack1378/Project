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
    private int mi;

    public <T> void load_data(String url, Class<T> tClass, final int i) {
        mi = i;
        httpUtils = new HttpUtils();
        httpUtils.request_data(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(T o) {
                getMvpView().SucceedCallBack(o,mi);
                Log.e(TAG, "SucceedBack: " + o);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
                Log.e(TAG, "ErrBack: " + err);
            }
        }, tClass);
    }


    public <T> void load_post(String url, Class<T> tClass, String user, String password, String email) {
        httpUtils = new HttpUtils();
        httpUtils.postAsynHttp(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(Object o) {
                getMvpView().SucceedCallBack(o,mi);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
            }
        }, tClass, user, password, email);

    }

    public <T> void load_post_Login(String url, Class<T> tClass, String userNameString, String userPasswordString) {
        httpUtils = new HttpUtils();
        httpUtils.postAsynHttpLogin(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(Object o) {
                Log.e(TAG, "SucceedBack: " + o);
                getMvpView().SucceedCallBack(o,mi);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
            }
        }, tClass, userNameString, userPasswordString);

    }
}
