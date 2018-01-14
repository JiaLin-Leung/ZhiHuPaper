package com.example.zhihupaper.item.detail;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhihupaper.R;
import com.example.zhihupaper.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class StoryDetailActivity extends BaseActivity {

    // TODO: 2018/1/13 这个titie 向上是显示 向下是隐藏 不下心带到一点

    // TODO: 2018/1/13 这个activity要注意finish

    // TODO: 2018/1/13 web view 

    private ViewGroup root = null;
    private View backView = null;
    private ViewPager mVp = null;

    private TextView mTvComment = null;
    private TextView mTvThumb = null;

    private ImageView mIvGoToComment = null;

    private List<Integer> idList = null;
    private int currentIdNumber = 0;//是上面这个list的第几个，上面这个list是所有已经显示的list<Id>
    private int currentId = 0;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected ViewGroup getContentView() {
        root = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_story_detail, null, false);
        return root;
    }

    @Override
    protected void initData() {
        idList = (List<Integer>) getIntent().getSerializableExtra("idList");
        currentId = getIntent().getIntExtra("id", 0);
        for (int i = 0; i < idList.size(); i ++) {
            if (idList.get(i) == currentId) {
                currentIdNumber = i;
            }
            DetailFragment detailFragment = new DetailFragment();
            Bundle args = new Bundle();
            args.putInt("id", idList.get(i));
            detailFragment.setArguments(args);
            fragmentList.add(detailFragment);
        }
    }

    @Override
    protected void initWidget() {
        ViewGroup titleView = (ViewGroup)root.getChildAt(0);
        backView = titleView.getChildAt(0);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDestroy();
            }
        });
        mTvComment = (TextView) titleView.getChildAt(5);
        mTvThumb = (TextView) titleView.getChildAt(7);
        mVp = (ViewPager) root.getChildAt(1);
        mIvGoToComment = (ImageView) titleView.getChildAt(4);
        mIvGoToComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoryDetailActivity.this, CommentActivity.class).putExtra("id", currentId));
            }
        });

        mVp.setAdapter(new MyAdapter(getSupportFragmentManager(), fragmentList));
        mVp.setCurrentItem(currentIdNumber);
    }

    public void setExtraText(int commentCount, int thumbCount) {
        mTvComment.setText(commentCount + "");
        mTvThumb.setText(thumbCount + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    static class MyAdapter extends FragmentPagerAdapter {

        List<Fragment> list = null;

        public MyAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
