package com.example.lenovo_pc.myproject.mvp.model.utils;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：李飞宇
 * 时间：2017/7/11 20:05
 * 功能：Okhttp请求加载数据（M层）
 */

public class HttpUtils {
    private RequestDataCallBack requestDataCallBack;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
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
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                message.what = 0;
                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), tClass);
                message.obj = t;
                handler.sendMessage(message);
            }
        });


    }

}
