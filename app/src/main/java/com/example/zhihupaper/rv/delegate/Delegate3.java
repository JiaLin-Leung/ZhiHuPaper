package com.example.zhihupaper.rv.delegate;


import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean3;

/**
 * Created by xubinhong on 2018/1/9.
 */

public abstract class Delegate3<A,B,C> implements Delegate {
    private int layoutId = 0;

    protected Delegate3(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void convert(CommonViewHolder holder, int position, Bean bean) {
        Bean3 bean9 = (Bean3) bean;
        convert(holder, position, (A)bean9.getA(), (B)bean9.getB(), (C)bean9.getC());
    }
    protected abstract void convert(CommonViewHolder holder, int position, A a, B b, C c);

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
