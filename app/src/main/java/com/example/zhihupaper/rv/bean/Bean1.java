package com.example.zhihupaper.rv.bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public class Bean1<A> implements Bean{
    private A a;

    private int layoutId;

    public Bean1(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public Bean1 setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @Override
    public int getParaCount() {
        return 1;
    }
}

