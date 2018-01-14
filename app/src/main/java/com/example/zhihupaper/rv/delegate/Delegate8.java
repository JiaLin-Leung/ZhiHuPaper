package com.example.zhihupaper.rv.delegate;

import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean8;

/**
 * Created by xubinhong on 2018/1/9.
 */

public abstract class Delegate8<A,B,C,D,E,F,G,H> implements Delegate {
    private int layoutId = 0;

    Delegate8(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void convert(CommonViewHolder holder, int position, Bean bean) {
        Bean8 bean9 = (Bean8) bean;
        convert(holder, position, (A)bean9.getA(), (B)bean9.getB(), (C)bean9.getC(), (D)bean9.getD(), (E)bean9.getE(), (F)bean9.getF(), (G)bean9.getG(), (H)bean9.getH());
    }
    protected abstract void convert(CommonViewHolder holder, int position, A a, B b, C c, D d, E e, F f, G g, H h);

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
