package com.example.zhihupaper.rv.delegate;

import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean1;

/**
 * Created by xubinhong on 2018/1/9.
 */

public abstract class Delegate1<A> implements Delegate {
    private int layoutId = 0;

    protected Delegate1(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void convert(CommonViewHolder holder, int position, Bean bean) {
        Bean1 bean9 = (Bean1) bean;
        convert(holder, position, (A)bean9.getA());
    }
    protected abstract void convert(CommonViewHolder holder, int position, A a);

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
