package com.example.zhihupaper.rv.delegate;

import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean2;

/**
 * Created by xubinhong on 2018/1/9.
 */

public abstract class Delegate2<A,B> implements Delegate {
    private int layoutId = 0;

    protected Delegate2(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void convert(CommonViewHolder holder, int position, Bean bean) {
        Bean2 bean9 = (Bean2) bean;
        convert(holder, position, (A)bean9.getA(), (B)bean9.getB());
    }
    protected abstract void convert(CommonViewHolder holder, int position, A a, B b);

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
