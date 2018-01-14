package com.example.zhihupaper.rv.bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public class Bean3<A,B,C> implements Bean{
    private A a;
    private B b;
    private C c;

    private int layoutId;

    public Bean3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public Bean3 setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @Override
    public int getParaCount() {
        return 3;
    }
}

