package com.example.zhihupaper.item;


import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhihupaper.widget.EndlessRecyclerOnScrollListener;
import com.example.zhihupaper.MainActivity;
import com.example.zhihupaper.R;
import com.example.zhihupaper.item.detail.StoryDetailActivity;
import com.example.zhihupaper.api.OldStoryAPI;
import com.example.zhihupaper.api.StoryAPI;
import com.example.zhihupaper.base.BaseFragment;
import com.example.zhihupaper.bean.StoryBean;
import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.MultiAdapter;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean1;
import com.example.zhihupaper.rv.bean.Bean2;
import com.example.zhihupaper.rv.bean.Bean3;
import com.example.zhihupaper.rv.delegate.Delegate;
import com.example.zhihupaper.rv.delegate.Delegate1;
import com.example.zhihupaper.rv.delegate.Delegate2;
import com.example.zhihupaper.rv.delegate.Delegate3;
import com.example.zhihupaper.util.RetrofitUtils;
import com.example.zhihupaper.widget.Dot;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xubinhong on 2018/1/12.
 */

// TODO: 2018/1/12 ctrl + - 舒服

//首页不继承通用的
public class HomePageFragment extends BaseFragment {
    private ViewGroup mRoot = null;

    private ViewGroup titleView = null;
    private View openDrawerView = null;

    private SwipeRefreshLayout refreshLayout = null;
    private RecyclerView mRv = null;

    List<Bean> list = new ArrayList<>();

    List<ImageView> imageList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    private ViewPager vp = null;
    private MyAdapter pagerAdapter = null;

    private android.os.Handler mHandler = new android.os.Handler();

    private TextView mTvTitle = null;

    private String currentData = null;

    private int oldSize = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initData() {
        (new RetrofitUtils())
                .getRetrofit("https://news-at.zhihu.com/")
                .create(StoryAPI.class)
                .getStory()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<StoryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(StoryBean storyBean) {
                        for (int i = 0; i < 5; i++) {
                            ImageView iv = new ImageView(getActivity());
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                            params.setMargins(0, 0, 0, 0);
                            iv.setLayoutParams(params);
                            iv.setScaleType(ImageView.ScaleType.FIT_XY);
                            Glide.with(getActivity()).load(storyBean.getTop_stories().get(i).getImage()).into(iv);
                            imageList.add(iv);
                            titleList.add(storyBean.getTop_stories().get(i).getTitle());
                        }
                        pagerAdapter.notifyDataSetChanged();
                        mTvTitle.setText(titleList.get(0));

                        for (int i = 0; i < storyBean.getStories().size(); i ++) {
                            list.add(new Bean3(storyBean.getStories().get(i).getTitle(), storyBean.getStories().get(i).getImages().get(0), storyBean.getStories().get(i).getId()).setLayoutId(R.layout.item_rv_home_page));
                        }

                        currentData = storyBean.getDate();
                        oldSize = storyBean.getStories().size();
                    }
                });

        list.add(new Bean2(imageList, titleList).setLayoutId(R.layout.item_rv_vp_home_page));
        list.add(new Bean1("今日热闻").setLayoutId(R.layout.item_rv_date_home_page));
    }

    @Override
    protected void initWidget(View root) {
        mRoot = (ViewGroup) root;
        titleView = (ViewGroup) mRoot.getChildAt(0);
        openDrawerView = titleView.getChildAt(0);
        refreshLayout = (SwipeRefreshLayout)mRoot.getChildAt(1);
        mRv = (RecyclerView) refreshLayout.getChildAt(1);

        openDrawerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).openDrawer();
            }
        });

        Delegate d1 = new Delegate2<List<ImageView>, List<String>>(R.layout.item_rv_vp_home_page) {
            @Override
            protected void convert(CommonViewHolder holder, int position, List<ImageView> views, final List<String> strings) {
                ViewGroup root = (ViewGroup) holder.itemView;
                final ViewGroup dotContainer = (ViewGroup) root.getChildAt(1);((Dot) dotContainer.getChildAt(0)).setChecked(true);
                final TextView mTv = (TextView) root.getChildAt(2);
                mTvTitle = mTv;

                vp = (ViewPager) root.getChildAt(0);
                pagerAdapter = new MyAdapter(views);
                vp.setAdapter(pagerAdapter);
                vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        for (int i = 0; i < 5; i ++) {
                            Dot d = (Dot) dotContainer.getChildAt(i);
                            if (i == position) {
                                d.setChecked(true);
                            } else {
                                d.setChecked(false);
                            }
                        }
                        mTv.setText(strings.get(position));
                    }
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }
                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        };
        Delegate d2 = new Delegate1<String>(R.layout.item_rv_date_home_page) {
            @Override
            protected void convert(CommonViewHolder holder, int position, String s) {
                ((TextView)((ViewGroup)holder.itemView).getChildAt(0)).setText(s);
            }
        };
        Delegate d3 = new Delegate3<String, String, Integer>(R.layout.item_rv_home_page) {
            @Override
            protected void convert(CommonViewHolder holder, int position, String s, String url, final Integer id) {
                ViewGroup root = (ViewGroup) holder.itemView;
                TextView mTv = (TextView) root.getChildAt(0);
                ImageView mIv = (ImageView) root.getChildAt(1);
                mTv.setText(s);
                Glide.with(getActivity()).load(url).into(mIv);

                root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //id相关给故事详情页面
                        ArrayList<Integer> idList = new ArrayList<>();
                        for (Bean bean : list) {
                            if (bean.getParaCount() == 3) {
                                idList.add((Integer) ((Bean3)bean).getC());
                            }
                        }
                        Intent intent = new Intent(getActivity(), StoryDetailActivity.class);
                        intent.putExtra("idList", idList);
                        intent.putExtra("id", id);
                        getActivity().startActivity(intent);
                    }
                });
            }
        };
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                vp.setCurrentItem((vp.getCurrentItem() + 1)%5);
                mHandler.postDelayed(this, 2000);
            }
        }, 2000);

        final MultiAdapter rvAdapter = new MultiAdapter(getActivity(), list).addDelegates(d1, d2, d3);
        mRv.setAdapter(rvAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(manager);

        mRv.addOnScrollListener(new EndlessRecyclerOnScrollListener(manager) {
            @Override
            public void onLoadMore(int currentPage) {
                (new RetrofitUtils())
                        .getRetrofit("https://news-at.zhihu.com/")
                        .create(OldStoryAPI.class)
                        .getOldStory(currentData)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<StoryBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(StoryBean storyBean) {
                                currentData = storyBean.getDate();
                                list.add(new Bean1(currentData).setLayoutId(R.layout.item_rv_date_home_page));
                                for (int i = 0; i < storyBean.getStories().size(); i ++) {
                                    list.add(new Bean3(storyBean.getStories().get(i).getTitle(), storyBean.getStories().get(i).getImages().get(0), storyBean.getStories().get(i).getId()).setLayoutId(R.layout.item_rv_home_page));
                                }
                                rvAdapter.notifyDataSetChanged();
                            }
                        });
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                (new RetrofitUtils())
                        .getRetrofit("https://news-at.zhihu.com/")
                        .create(StoryAPI.class)
                        .getStory()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<StoryBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(StoryBean storyBean) {
                                int newSize = storyBean.getStories().size();
                                if (newSize > oldSize) {
                                    int difSize = newSize - oldSize;
                                    for (int i = 0; i < difSize; i ++) {
                                        list.add(i, new Bean3(storyBean.getStories().get(i).getTitle(), storyBean.getStories().get(i).getImages().get(0), storyBean.getStories().get(i).getId()).setLayoutId(R.layout.item_rv_home_page));
                                    }
                                    rvAdapter.notifyDataSetChanged();//not best oper
                                    oldSize = newSize;
                                }
                                refreshLayout.setRefreshing(false);
                            }
                        });
            }
        });
    }

    static class MyAdapter extends PagerAdapter {

        private List<ImageView> list;

        public MyAdapter(List<ImageView> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }
}
