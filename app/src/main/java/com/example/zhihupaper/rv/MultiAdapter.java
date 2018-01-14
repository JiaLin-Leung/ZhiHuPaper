package com.example.zhihupaper.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.delegate.Delegate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xubinhong on 2018/1/8.
 * 多item type(因为单item type用这个略显麻烦)
 */

public class MultiAdapter extends RecyclerView.Adapter<CommonViewHolder> {

    private LayoutInflater inflater = null;
    private List<Bean> beans = null;
    private List<Delegate> delegates = null;

    public MultiAdapter(Context context, List<Bean> beans) {
        this.inflater = LayoutInflater.from(context);
        this.beans = beans;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommonViewHolder(inflater.inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        Bean bean = beans.get(position);
        int layoutId = bean.getLayoutId();
        for (Delegate d : delegates) {
            if (layoutId == d.getLayoutId()) {
                d.convert(holder, position, bean);
            }
        }
    }

    public MultiAdapter addDelegates(Delegate...delegates) {
        if (this.delegates == null) {
            this.delegates = new ArrayList<>();
        }
        Collections.addAll(this.delegates, delegates);
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        return beans.get(position).getLayoutId();
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }
}
