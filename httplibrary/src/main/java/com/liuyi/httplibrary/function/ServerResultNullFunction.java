package com.liuyi.httplibrary.function;



import androidx.annotation.NonNull;

import com.liuyi.httplibrary.exception.HttpError;
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
public class ServerResultNullFunction implements Function<HttpResponse, Object> {
    @Override
    public Object apply(@NonNull HttpResponse response) throws Exception {
        if (response.getCode() != 0) {
            throw new ServerException(HttpError.HTTP_EXCEPTION.getType(), response.getMsg());
        }
        return response.getData();
    }
}
