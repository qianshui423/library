package com.lucky.baselib.base.interfaces;

/**
 * Created by liuxuehao on 16/12/29.
 * 网络请求接口
 */

public interface IFlow<T> {
    void flowData(T data);

    void flowCode(int code);
}
