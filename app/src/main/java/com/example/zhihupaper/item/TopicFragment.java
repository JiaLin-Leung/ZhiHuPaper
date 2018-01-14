package com.example.zhihupaper.item;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.zhihupaper.MainActivity;
import com.example.zhihupaper.R;
import com.example.zhihupaper.api.TopicAPI;
import com.example.zhihupaper.base.BaseFragment;
import com.example.zhihupaper.bean.TopicBean;
import com.example.zhihupaper.item.detail.StoryDetailActivity;
import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.MultiAdapter;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean1;
import com.example.zhihupaper.rv.bean.Bean2;
import com.example.zhihupaper.rv.bean.Bean3;
import com.example.zhihupaper.rv.bean.Bean4;
import com.example.zhihupaper.rv.delegate.Delegate;
import com.example.zhihupaper.rv.delegate.Delegate1;
import com.example.zhihupaper.rv.delegate.Delegate2;
import com.example.zhihupaper.rv.delegate.Delegate3;
import com.example.zhihupaper.util.RetrofitUtils;
import com.example.zhihupaper.widget.RoundImageView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xubinhong on 2018/1/13.
 */

public class TopicFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_topic;
    }

    private int id = 0;
    private String picUrl = "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg";
    private String titleName = null;
    private String signature = null;

    private List<Bean4> infoList = null;

    private List<Bean> list = new ArrayList<>();

    private MultiAdapter adapter = null;

    @Override
    protected void initData() {
        infoList = new ArrayList<>();
        infoList.add(new Bean4("日常心理学", 13, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "了解自己和别人，了解彼此的欲望和局限。"));
        infoList.add(new Bean4("用户推荐日报", 12, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "内容由知乎用户推荐，海纳主题百万，趣味上天入地"));
        infoList.add(new Bean4("电影日报", 3, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "除了经典和新片，我们还关注技术和产业"));
        infoList.add(new Bean4("不许无聊", 11, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "为你发现最有趣的新鲜事，建议在 WiFi 下查看"));
        infoList.add(new Bean4("设计日报", 4, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "好设计需要打磨和研习，我们分享灵感和路径"));
        infoList.add(new Bean4("大公司日报", 5, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "商业世界变化越来越快，就是这些家伙干的"));
        infoList.add(new Bean4("财经日报", 6, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "从业者推荐的财经金融资讯"));
        infoList.add(new Bean4("互联网安全", 10, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "把黑客知识科普到你的面前"));
        infoList.add(new Bean4("开始游戏", 2, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "如果你喜欢游戏，就从这里开始"));
        infoList.add(new Bean4("音乐日报", 7, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "有音乐就很好"));
        infoList.add(new Bean4("动漫日报", 9, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "用技术的眼睛仔细看懂每一部动画和漫画"));
        infoList.add(new Bean4("体育日报", 8, "http:\\/\\/pic3.zhimg.com\\/0e71e90fd6be47630399d63c58beebfc.jpg", "关注体育，不吵架。"));

        Bundle bundle = getArguments();
        titleName = bundle.getString("title_name");

        for (Bean4 b : infoList) {
            if (b.getA().equals(titleName)) {
                signature = (String) b.getD();
                id = (int) b.getB();
                break;
            }
        }
        list.add(new Bean2(picUrl, signature).setLayoutId(R.layout.item_rv_topic_item1));

        (new RetrofitUtils())
                .getRetrofit("https://news-at.zhihu.com/")
                .create(TopicAPI.class)
                .getTopic(id + "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TopicBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(TopicBean topicBean) {
                        List<String> list = new ArrayList<>();
                        for (int i = 0; i < topicBean.getEditors().size(); i ++) {
                            list.add(topicBean.getEditors().get(i).getAvatar());
                        }
                        TopicFragment.this.list.add(new Bean1(list).setLayoutId(R.layout.item_rv_topic_item2));

                        for (int i = 0; i < topicBean.getStories().size(); i ++) {
                            TopicFragment.this.list.add(new Bean3(topicBean.getStories().get(i).getTitle(), topicBean.getStories().get(i).getImages() == null ? null: topicBean.getStories().get(i).getImages().get(0), topicBean.getStories().get(i).getId()).setLayoutId(R.layout.item_rv_home_page));
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    protected void initWidget(View root) {
        ViewGroup mRoot = (ViewGroup) root;
        ViewGroup topView = (ViewGroup) mRoot.getChildAt(0);
        View backView = topView.getChildAt(0);
        TextView mTvTitle = (TextView) topView.getChildAt(1);
        ImageView mIvConcern = (ImageView) topView.getChildAt(3);

        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) mRoot.getChildAt(1);
        RecyclerView mRv = (RecyclerView) ((ViewGroup) mRoot.getChildAt(1)).getChildAt(1);

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });
        mTvTitle.setText(titleName);

        // TODO: 2018/1/14 main thread做了太多耗时操作

        Delegate d1 = new Delegate2<String, String>(R.layout.item_rv_topic_item1) {
            @Override
            protected void convert(CommonViewHolder holder, int position, String picUrl, String s) {
                ImageView iv = (ImageView) ((ViewGroup)holder.itemView).getChildAt(0);
                TextView tv = (TextView) ((ViewGroup)holder.itemView).getChildAt(1);
                Glide.with(getActivity()).load(picUrl).into(iv);
                tv.setText(s);
            }
        };

        Delegate d2 = new Delegate1<List<String>>(R.layout.item_rv_topic_item2) {
            @Override
            protected void convert(CommonViewHolder holder, int position, List<String> strings) {
                if (((ViewGroup)holder.itemView).getChildCount() == 1) {
                    for (int i = 0; i < strings.size(); i ++) {
                        final RoundImageView iv = new RoundImageView(getActivity());
                        Glide.with(mContext).load(strings.get(i)).asBitmap().into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                iv.setImageBitmap(resource);
                            }
                        });
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(12, 12, 0, 12);
                        iv.setLayoutParams(params);
                        ((ViewGroup)holder.itemView).addView(iv);
                    }
                }
            }
        };

        Delegate d3 = new Delegate3<String, String, Integer>(R.layout.item_rv_home_page) {
            @Override
            protected void convert(CommonViewHolder holder, int position, String s, String url, final Integer id) {
                ViewGroup root = (ViewGroup) holder.itemView;
                TextView mTv = (TextView) root.getChildAt(0);
                ImageView mIv = (ImageView) root.getChildAt(1);
                mTv.setText(s);
                if (url != null) {
                    Glide.with(getActivity()).load(url).into(mIv);
                } else {
                    mIv.setVisibility(View.GONE);
                }

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

        adapter = new MultiAdapter(getActivity(), list).addDelegates(d1,d2,d3);
        mRv.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(manager);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });
    }
}
