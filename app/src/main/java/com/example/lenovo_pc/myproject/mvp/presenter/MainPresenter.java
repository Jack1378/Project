package com.example.lenovo_pc.myproject.mvp.presenter;

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

    public <T> void load_data(String url, Class<T> tClass) {
        httpUtils = new HttpUtils();
        httpUtils.request_data(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(T o) {
                getMvpView().SucceedCallBack(o);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
            }
        }, tClass);

    }
}
