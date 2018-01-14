package com.example.zhihupaper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xubinhong on 2018/1/12.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = "xbh";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /***
         * 初始化
         */
        if (initBundle(getIntent().getExtras())) {
            setContentView(getContentView());

            initData();
            initWidget();
        } else {
            finish();
        }
    }

    protected void initData() {

    }

    protected void initWidget() {

    }

    protected abstract ViewGroup getContentView();

    protected boolean initBundle(Bundle bundle) {
        return true;
    }

    protected void replaceFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(frameLayoutId, fragment);
            transaction.commit();
        }
    }
}
