package com.example.lenovo_pc.myproject.mvp.presenter;

import android.util.Log;

import com.example.lenovo_pc.myproject.mvp.model.utils.HttpUtils;
import com.example.lenovo_pc.myproject.mvp.model.utils.RequestDataCallBack;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

/**
 * 作者：李飞宇
 * 时间：2017/7/21 10:41
 * 功能：用户登录的P层
 */

public class UsersLoginPresenter extends BasePresenter<IMainView> {

    private static final String TAG = "UsersLoginPresenter";
    public <T> void load_post_Login(String url, Class<T> tClass, String userNameString, String userPasswordString) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.postAsynHttpLogin(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(Object o) {
                Log.e(TAG, "SucceedBack: " + o);
                getMvpView().SucceedCallBack(o,4);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
            }
        }, tClass, userNameString, userPasswordString);

    }
}
