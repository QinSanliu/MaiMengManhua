package com.example.administrator.maimengcartoon;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.sharesdk.framework.ShareSDK;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016-12-10.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initOkHttpUtils();

        //初始化fresco
        Fresco.initialize(this);

        ShareSDK.initSDK(this);
    }

    private void initOkHttpUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
        .connectTimeout(10000L, TimeUnit.MILLISECONDS)
        .readTimeout(10000L, TimeUnit.MILLISECONDS)
        //其他配置
        .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
