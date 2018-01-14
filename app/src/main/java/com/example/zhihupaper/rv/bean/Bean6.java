package com.example.zhihupaper.rv.bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public class Bean6<A,B,C,D,E,F> implements Bean{
    private A a;
    private B b;
    private C c;
    private D d;
    private E e;
    private F f;

    private int layoutId;

    public Bean6(A a, B b, C c, D d, E e, F f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
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

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public F getF() {
        return f;
    }

    public void setF(F f) {
        this.f = f;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public Bean6 setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @Override
    public int getParaCount() {
        return 6;
    }
}

