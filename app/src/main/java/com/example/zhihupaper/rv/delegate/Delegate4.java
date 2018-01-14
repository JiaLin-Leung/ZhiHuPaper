package com.example.zhihupaper.rv.delegate;

import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean4;

/**
 * Created by xubinhong on 2018/1/9.
 */

public abstract class Delegate4<A,B,C,D> implements Delegate {
    private int layoutId = 0;

    Delegate4(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void convert(CommonViewHolder holder, int position, Bean bean) {
        Bean4 bean9 = (Bean4) bean;
        convert(holder, position, (A)bean9.getA(), (B)bean9.getB(), (C)bean9.getC(), (D)bean9.getD());
    }
    protected abstract void convert(CommonViewHolder holder, int position, A a, B b, C c, D d);

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
