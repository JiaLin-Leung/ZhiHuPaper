package com.example.zhihupaper.rv.bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public class Bean9<A,B,C,D,E,F,G,H,I> implements Bean{
    private A a;
    private B b;
    private C c;
    private D d;
    private E e;
    private F f;
    private G g;
    private H h;
    private I i;

    private int layoutId;

    public Bean9(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
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

    public G getG() {
        return g;
    }

    public void setG(G g) {
        this.g = g;
    }

    public H getH() {
        return h;
    }

    public void setH(H h) {
        this.h = h;
    }

    public I getI() {
        return i;
    }

    public void setI(I i) {
        this.i = i;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public Bean9 setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @Override
    public int getParaCount() {
        return 9;
    }
}
