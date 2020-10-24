package com.liuyi.httplibrary.exception;

/**
 * @说明 网路异常
 * @作者 liuyi
 * @时间 2019-09-03 09:10
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2019 liuyi-版权所有
 * @备注
 */
public enum HttpError {

    HTTP_EXCEPTION(2000, "Network error"),
    ANALYTIC_SERVER_DATA_ERROR(1001, "Parse error"),
    CONNECT_ERROR(1003, "The connection fails"),
    TIME_OUT_ERROR(1004, "Network timeout"),
    UN_KNOWN_ERROR(1000, "An unknown error");

    private int type;
    private String name;

    HttpError(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getName(int type) {
        for (HttpError c : HttpError.values()) {
            if (c.getType() == type) {
                return c.getName();
            }
        }
        return HTTP_EXCEPTION.name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
