package com.example.zhihupaper.rv;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by xubinhong on 2018/1/8.
 */

public class CommonViewHolder extends ViewHolder {
    SparseArray<View> sparseArray = null;

    public CommonViewHolder(View itemView) {
        super(itemView);
    }

    public View holdAndGetView(int viewId) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        View v = null;
        View viewGot = sparseArray.get(viewId);
        if (viewGot == null) {
            v = itemView.findViewById(viewId);
            sparseArray.put(viewId, v);
            return v;
        } else {
            return viewGot;
        }
    }
}
