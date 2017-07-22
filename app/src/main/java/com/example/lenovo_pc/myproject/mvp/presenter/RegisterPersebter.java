package com.example.lenovo_pc.myproject.mvp.presenter;

import com.example.lenovo_pc.myproject.mvp.model.utils.HttpUtils;
import com.example.lenovo_pc.myproject.mvp.model.utils.RequestDataCallBack;
import com.example.lenovo_pc.myproject.mvp.view.fragment.BaseFragment;
import com.example.lenovo_pc.myproject.mvp.view.iview.IMainView;

/**
 * 作者：李飞宇
 * 时间：2017/7/21 10:45
 * 功能：注册的p层
 */

public class RegisterPersebter extends BasePresenter<IMainView> {

    public <T> void load_post(String url, Class<T> tClass, String user, String password, String email) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.postAsynHttp(url, new RequestDataCallBack<T>() {
            @Override
            public void SucceedBack(Object o) {
                getMvpView().SucceedCallBack(o, 3);
            }

            @Override
            public void ErrBack(String err, int code) {
                getMvpView().ErrCallBack(err, code);
            }
        }, tClass, user, password, email);

    }
}
