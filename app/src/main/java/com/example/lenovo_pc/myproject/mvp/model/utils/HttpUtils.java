package com.example.lenovo_pc.myproject.mvp.model.utils;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.lenovo_pc.myproject.mvp.model.bean.LoginBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：李飞宇
 * 时间：2017/7/11 20:05
 * 功能：Okhttp请求加载数据（M层）
 */

public class HttpUtils {
    private List<LoginBean> list = new ArrayList();
    private static final String TAG = "HttpUtils";
    private RequestDataCallBack requestDataCallBack;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Log.e(TAG, "handleMessage: "+msg.obj.toString() );
                    requestDataCallBack.SucceedBack(msg.obj);
                    break;
                case 1:
                    requestDataCallBack.SucceedBack(msg.obj);
                    break;
            }
        }
    };

    /**
     * 定义请求数据
     *
     * @param url
     * @param requestDataCallBack
     * @param tClass
     * @param <T>
     */
    public <T> void request_data(String url, final RequestDataCallBack requestDataCallBack, final Class<T> tClass) {
        this.requestDataCallBack = requestDataCallBack;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //netDataCallback.err(500,e.getMessage());
                Log.e("=====", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                message.what = 0;
                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), tClass);
                Log.e(TAG, "onResponse: " + t);
                message.obj = t;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 异步post请求注册
     *
     * @param url
     * @param requestDataCallBack
     * @param tClass
     * @param user
     * @param password
     * @param email
     * @param <T>
     */
    public <T> void postAsynHttp(String url, final RequestDataCallBack requestDataCallBack, final Class<T> tClass, String user, String password, String email) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("act", "login")
                .add("op", "register")
                .add("username", user)
                .add("password", password)
                .add("password_confirm", password)
                .add("email", email)
                .add("client", "android")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                try {
                    final String str = response.body().string();
                    Log.i("wangshu", str);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson asygson = new Gson();
                            T t = asygson.fromJson(str, tClass);
                            requestDataCallBack.SucceedBack(t);

                        }
                    });
                } catch (Exception e)

                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 异步post请求登录
     *
     * @param <T>
     * @param url
     * @param requestDataCallBack
     * @param tClass
     * @param userNameString
     * @param userPasswordString
     */
    public <T> void postAsynHttpLogin(String url, final RequestDataCallBack requestDataCallBack, final Class<T> tClass, String userNameString, String userPasswordString) {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("act", "login")
                .add("username", userNameString)
                .add("password", userPasswordString)
                .add("client", "android")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                try {
                    final String str = response.body().string();
                    Log.e(TAG, "onResponse: " + str);
                    Message message = handler.obtainMessage();
                    message.what = 1;
                    /*runOnUiThread(new Runnable() {
                        @Override
                        public void run() {*/
                    Gson asylgson = new Gson();
                    T t = asylgson.fromJson(str, tClass);
                    Log.e(TAG, "run: " + t.toString());
                    requestDataCallBack.SucceedBack(t);
                     /*   }
                    });*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    private void runOnUiThread(Runnable runnable) {

    }

}
