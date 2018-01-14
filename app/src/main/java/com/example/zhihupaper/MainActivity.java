package com.example.zhihupaper;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.zhihupaper.base.BaseActivity;
import com.example.zhihupaper.item.HomePageFragment;
import com.example.zhihupaper.item.TopicFragment;
import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.MultiAdapter;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean0;
import com.example.zhihupaper.rv.bean.Bean2;
import com.example.zhihupaper.rv.delegate.Delegate;
import com.example.zhihupaper.rv.delegate.Delegate0;
import com.example.zhihupaper.rv.delegate.Delegate2;
import com.google.gson.Gson;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewGroup root = null;
    private FrameLayout mainContainer = null;

    private ConstraintLayout leftContainer = null;
    private RecyclerView mRvLeft = null;

    List<Bean> list = new ArrayList<>();

    @Override
    protected ViewGroup getContentView() {
        root = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_main, null, false);
        return root;
    }

    @Override
    protected void initData() {
        //json shared preferences保存对象，先判断本地是否有了
        String listJson = getSharedPreferences("item_name_list", Context.MODE_PRIVATE).getString("item_name_list", "");
        //如果是第一次进入
        if (listJson.equals("")) {
            //初始化集合
            String[] items = {"日常心理学", "用户推荐日报", "电影日报", "不许无聊", "设计日报", "大公司日报", "财经日报", "互联网安全", "开始游戏", "音乐日报", "动漫日报", "体育日报"};
            list.add(new Bean0().setLayoutId(R.layout.item_left_rv_home_page));
            for (int i = 0; i < items.length; i++) {
                list.add(new Bean2(items[i], false).setLayoutId(R.layout.item_left_rv));
            }
            //转成json 存储
            getSharedPreferences("item_name_list", Context.MODE_PRIVATE)
                    .edit()
                    .putString("item_name_list", (new Gson()).toJson(list))
                    .apply();
        } else {
            //赋值集合
            list.add(new Bean0().setLayoutId(R.layout.item_left_rv_home_page));
            JSONArray array = JSONArray.parseArray(listJson);
            for (int i = 1; i < array.size(); i++) {
                JSONObject o = array.getJSONObject(i);
                list.add(new Bean2(o.get("a"), o.get("b")).setLayoutId(R.layout.item_left_rv));
            }
        }
    }

    @Override
    protected void initWidget() {
        mainContainer = (FrameLayout) root.getChildAt(0);

        leftContainer = (ConstraintLayout) root.getChildAt(1);
        mRvLeft = (RecyclerView) leftContainer.getChildAt(4);

        Delegate0 d1 = new Delegate0(R.layout.item_left_rv_home_page) {
            @Override
            public void convert(CommonViewHolder holder, int position, Bean bean) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        replaceFragment(R.id.fl_main_container, new HomePageFragment());
                        closeDrawer();
                    }
                });
            }
        };
        Delegate2<String, Boolean> d2 = new Delegate2<String, Boolean>(R.layout.item_left_rv) {
            @Override
            protected void convert(CommonViewHolder holder, final int position, final String s, Boolean aBoolean) {
                ((TextView) ((ViewGroup) holder.itemView).getChildAt(0)).setText(s);
                ((ImageView) ((ViewGroup) holder.itemView).getChildAt(2)).setImageBitmap(aBoolean ? ((BitmapDrawable) getResources().getDrawable(R.drawable.arrow)).getBitmap() : ((BitmapDrawable) getResources().getDrawable(R.drawable.add)).getBitmap());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TopicFragment topicFragment = new TopicFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("title_name", s);
                        topicFragment.setArguments(bundle);
                        replaceFragment(R.id.fl_main_container, topicFragment);
                        closeDrawer();
                    }
                });
            }
        };

        mRvLeft.setAdapter(new MultiAdapter(this, list).addDelegates(d1, d2));
        mRvLeft.setLayoutManager(new LinearLayoutManager(this));

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_main_container, new HomePageFragment())
                .commit();
    }

    private void closeDrawer() {
        ((DrawerLayout) root).closeDrawer(Gravity.START);
    }

    public void openDrawer() {
        ((DrawerLayout) root).openDrawer(Gravity.START);
    }
}
