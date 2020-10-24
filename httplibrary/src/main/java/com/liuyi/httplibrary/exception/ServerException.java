package com.liuyi.httplibrary.exception;

/**
 * @说明 自定义服务器错误
 * @作者 liuyi
 * @时间 2019-09-03 09:10
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2019 liuyi-版权所有
 * @备注
 */
public class ServerException extends RuntimeException {
    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
