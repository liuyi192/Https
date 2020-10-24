package com.liuyi.httplibrary.retrofit;


import android.content.Context;
import android.util.Log;

import com.liuyi.httplibrary.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @说明 RetrofitUtils工具类
 * @作者 liuyi
 * @时间 2019-09-03 09:10
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2019 liuyi-版权所有
 * @备注
 */
public class RetrofitUtils {
    public static final int CONNECT_TIME_OUT = 30;//连接超时时长x秒
    public static final int READ_TIME_OUT = 30;//读数据超时时长x秒
    public static final int WRITE_TIME_OUT = 30;//写数据接超时时长x秒
    private static RetrofitUtils mInstance = null;
    private Context context;

    private RetrofitUtils(Context context) {
        this.context = context;
    }

    public static RetrofitUtils get(Context context) {
        if (mInstance == null) {
            synchronized (RetrofitUtils.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtils(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 设置okHttp
     */
    private static OkHttpClient okHttpClient() {
        //开启Log
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message ->
                Log.i("INFO", message)
        );
        int level = mInstance.context.getResources().getInteger(R.integer.level);
        switch (level) {
            case 0:
                logging.setLevel(HttpLoggingInterceptor.Level.NONE);
                break;
            case 1:
                logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
                break;
            case 2:
                logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
                break;
            case 3:
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                break;
        }
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
        return client;
    }

    /**
     * 获取Retrofit
     *
     * @author ZhongDaFeng
     */
    public Retrofit retrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
