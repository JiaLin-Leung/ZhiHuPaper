package com.example.zhihupaper.rv.delegate;


import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.bean.Bean;

/**
 * Created by xubinhong on 2018/1/9.
 */

public interface Delegate {
    void convert(CommonViewHolder holder, int position, Bean bean);
    int getLayoutId();
}
