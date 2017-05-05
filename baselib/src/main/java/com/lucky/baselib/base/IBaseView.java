package com.lucky.baselib.base;

/**
 * Created by liuxuehao on 16/12/26.
 * BaseView基础类
 */

public interface IBaseView {
    <T> void display(T data, int which);

    void error(String error, int which);
}