package com.example.zhihupaper.rv.delegate;


import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean5;

/**
 * Created by xubinhong on 2018/1/9.
 */

public abstract class Delegate5<A,B,C,D,E> implements Delegate {
    private int layoutId = 0;

    protected Delegate5(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void convert(CommonViewHolder holder, int position, Bean bean) {
        Bean5 bean9 = (Bean5) bean;
        convert(holder, position, (A)bean9.getA(), (B)bean9.getB(), (C)bean9.getC(), (D)bean9.getD(), (E)bean9.getE());
    }
    protected abstract void convert(CommonViewHolder holder, int position, A a, B b, C c, D d, E e);

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
