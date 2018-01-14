package com.example.zhihupaper.rv.bean;

/**
 * Created by xubinhong on 2018/1/11.
 */

public class Bean0  implements Bean{
    public Bean0() {
    }

    private int layoutId = 0;

    @Override
    public int getLayoutId() {
        return layoutId;
    }

    public Bean0 setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @Override
    public int getParaCount() {
        return 0;
    }
}
