package com.liuyi.httplibrary.helper;

import com.google.gson.JsonElement;

/**
 * @说明 数据解析helper
 * @作者 liuyi
 * @时间 2019-09-03 09:10
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2019 liuyi-版权所有
 * @备注
 */
public interface ParseHelper {
    Object[] parse(JsonElement jsonElement);
}
