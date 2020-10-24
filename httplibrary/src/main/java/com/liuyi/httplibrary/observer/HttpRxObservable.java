package com.liuyi.httplibrary.observer;


import android.content.Context;

import com.liuyi.httplibrary.function.HttpResultFunction;
import com.liuyi.httplibrary.function.ServerResultFunction;
import com.liuyi.httplibrary.function.ServerResultObjectFunction;
import com.liuyi.httplibrary.retrofit.HttpResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @说明 适用Retrofit网络请求Observable(被监听者)
 * @作者 liuyi
 * @时间 2019-09-03 09:10
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2019 liuyi-版权所有
 * @备注
 */
public class HttpRxObservable<T> {
    private static HttpRxObservable instance;

    public static HttpRxObservable getInstance() {
        if (instance == null) {
            synchronized (HttpRxObservable.class) {
                if (instance == null) {
                    instance = new HttpRxObservable();
                }
            }
        }
        return instance;
    }

    /**
     * 获取被监听者
     * 网络请求Observable构建
     * 网络请求参数
     * 无管理生命周期,容易导致内存溢出
     *
     * @param apiObservable
     * @return
     */
    public Observable getObservable(Observable<HttpResponse<T>> apiObservable) {
        Observable observable = apiObservable.map(new ServerResultFunction<T>())
                .onErrorResumeNext(new HttpResultFunction<HttpResponse<T>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /**
     * 获取被监听者
     * 网络请求Observable构建
     * 网络请求参数
     * 无管理生命周期,容易导致内存溢出
     *
     * @param apiObservable
     * @return
     */
    public static Observable getObservableObject(Observable<Object> apiObservable) {
        Observable observable = apiObservable.map(new ServerResultObjectFunction())
                .onErrorResumeNext(new HttpResultFunction<HttpResponse>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

}
