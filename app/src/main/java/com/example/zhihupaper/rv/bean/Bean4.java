package com.example.zhihupaper.rv.bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public class Bean4<A,B,C,D> implements Bean{
    private A a;
    private B b;
    private C c;
    private D d;

    private int layoutId;

    public Bean4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public Bean4 setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @Override
    public int getParaCount() {
        return 4;
    }
}

