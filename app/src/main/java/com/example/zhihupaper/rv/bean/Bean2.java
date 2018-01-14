package com.example.zhihupaper.rv.bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public class Bean2<A,B> implements Bean{
    private A a;
    private B b;

    private int layoutId;

    public Bean2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public Bean2 setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @Override
    public int getParaCount() {
        return 2;
    }
}

