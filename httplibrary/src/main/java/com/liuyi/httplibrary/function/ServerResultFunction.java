package com.liuyi.httplibrary.function;

import androidx.annotation.NonNull;

import com.liuyi.httplibrary.entity.BaseEntity;
import com.liuyi.httplibrary.exception.ServerException;
import com.liuyi.httplibrary.retrofit.HttpResponse;

import io.reactivex.functions.Function;

/**
 * @说明 服务器结果处理函数
 * @作者 liuyi
 * @时间 2019-09-03 09:10
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2019 liuyi-版权所有
 * @备注
 */
public class ServerResultFunction<T> implements Function<HttpResponse<T>, Object> {
    @Override
    public T apply(@NonNull HttpResponse<T> response){
        if (response.getCode() != 0) {
            throw new ServerException(response.getCode(), response.getMsg());
        }
        return response.getData() == null ? (T) new BaseEntity() : response.getData();
    }
}
