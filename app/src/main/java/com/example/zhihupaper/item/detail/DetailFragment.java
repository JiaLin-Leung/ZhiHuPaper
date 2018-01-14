package com.example.zhihupaper.item.detail;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhihupaper.R;
import com.example.zhihupaper.api.DetailExtraAPI;
import com.example.zhihupaper.api.StoryDetailAPI;
import com.example.zhihupaper.base.BaseFragment;
import com.example.zhihupaper.bean.DetailExtraBean;
import com.example.zhihupaper.bean.StoryDetailBean;
import com.example.zhihupaper.util.RetrofitUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xubinhong on 2018/1/13.
 */

public class DetailFragment extends BaseFragment {
    private FrameLayout mFl = null;
    private ImageView mIv = null;
    private TextView mTv = null;

    private WebView mWv = null;

    private int id = 0;

    private String imgUrl = null;
    private String title = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail_item;
    }

    @Override
    protected void initData() {
        // TODO: 2018/1/13 还要获取父容器tv控件
        Bundle bundle = getArguments();
        id = bundle.getInt("id");

        (new RetrofitUtils())
                .getRetrofit("https://news-at.zhihu.com/")
                .create(StoryDetailAPI.class)
                .getDetailStory(id + "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<StoryDetailBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(StoryDetailBean storyDetailBean) {
                        imgUrl = storyDetailBean.getImage();
                        title = storyDetailBean.getTitle();

                        Glide.with(getActivity()).load(imgUrl).into(mIv);
                        mTv.setText(title);

                        mWv.loadData(storyDetailBean.getBody(),"text/html; charset=UTF-8", null);
                    }
                });

        (new RetrofitUtils())
                .getRetrofit("https://news-at.zhihu.com/")
                .create(DetailExtraAPI.class)
                .getExtra(id + "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DetailExtraBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(DetailExtraBean detailExtraBean) {
                        ((StoryDetailActivity)getActivity()).setExtraText(detailExtraBean.getComments(), detailExtraBean.getPopularity());
                    }
                });
    }

    @Override
    protected void initWidget(View root) {
        ViewGroup mRoot = (ViewGroup) root;

        mFl = (FrameLayout) mRoot.getChildAt(0);
        mIv = (ImageView) mFl.getChildAt(0);
        mTv = (TextView) mFl.getChildAt(1);

        LinearLayout mLl = (LinearLayout) mRoot.getChildAt(1);
        mWv = new WebView(getActivity()) {
            // TODO: 2018/1/13 怎么才能隔绝水平的滑动?
            private int lastX;
            private int lastY;
            @Override
            public boolean dispatchTouchEvent(MotionEvent ev) {
                int x = (int) ev.getX();
                int y = (int) ev.getY();
                switch (ev.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = x;
                        lastY = y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int offsetX = Math.abs(x - lastX);
                        int offsetY = Math.abs(y - lastY);
                        if (offsetX > offsetY) {
                            return false;
                        }
                }
                return super.dispatchTouchEvent(ev);
            }
        };
        mWv.getSettings().setDefaultTextEncodingName("utf-8");
        mLl.addView(mWv);
    }
}
