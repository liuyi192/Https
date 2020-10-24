package com.liuyi.httplibrary.function;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.liuyi.httplibrary.exception.HttpError;
import com.liuyi.httplibrary.exception.ServerException;

import io.reactivex.functions.Function;

/**
 * @说明 服务器结果处理函数String
 * @作者 liuyi
 * @时间 2019-09-03 09:10
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2019 liuyi-版权所有
 * @备注
 */
public class ServerResultObjectFunction implements Function<Object, Object> {
    @Override
    public Object apply(@NonNull Object response) throws Exception {
        if (response == null) {
            throw new ServerException(HttpError.HTTP_EXCEPTION.getType(), HttpError.HTTP_EXCEPTION.getName());
        }
        return new Gson().toJson(response);
    }
}

