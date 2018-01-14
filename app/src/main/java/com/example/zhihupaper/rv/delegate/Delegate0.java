package com.example.zhihupaper.rv.delegate;


import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public class Delegate0 implements Delegate {
    private int layoutId = 0;

    public Delegate0(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void convert(CommonViewHolder holder, int position, Bean bean) {
    }

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
