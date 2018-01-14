package com.example.zhihupaper.item.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.zhihupaper.R;
import com.example.zhihupaper.api.CommentAPI;
import com.example.zhihupaper.base.BaseActivity;
import com.example.zhihupaper.bean.CommentBean;
import com.example.zhihupaper.rv.CommonViewHolder;
import com.example.zhihupaper.rv.MultiAdapter;
import com.example.zhihupaper.rv.bean.Bean;
import com.example.zhihupaper.rv.bean.Bean1;
import com.example.zhihupaper.rv.bean.Bean5;
import com.example.zhihupaper.rv.delegate.Delegate;
import com.example.zhihupaper.rv.delegate.Delegate1;
import com.example.zhihupaper.rv.delegate.Delegate3;
import com.example.zhihupaper.rv.delegate.Delegate5;
import com.example.zhihupaper.util.RetrofitUtils;
import com.example.zhihupaper.widget.RoundImageView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CommentActivity extends BaseActivity {

    private ViewGroup root = null;
    private int id = 0;

    private List<Bean> list = new ArrayList<>();
    private MultiAdapter adapter = null;

    @Override
    protected ViewGroup getContentView() {
        root = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_comment, null, false);
        return root;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        (new RetrofitUtils())
                .getRetrofit("https://news-at.zhihu.com/")
                .create(CommentAPI.class)
                .getLongComment(id + "")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CommentBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(CommentBean commentBean) {
                        if (commentBean.getComments() != null && commentBean.getComments().size() != 0) {
                            list.add(new Bean1("一共" + commentBean.getComments().size() + "条长评").setLayoutId(R.layout.item_rv_comment_item1));
                            for (int i = 0; i < commentBean.getComments().size(); i ++) {
                                list.add(new Bean5(commentBean.getComments().get(i).getAvatar(),commentBean.getComments().get(i).getAuthor(),commentBean.getComments().get(i).getLikes() + "",commentBean.getComments().get(i).getContent(),commentBean.getComments().get(i).getTime() + "").setLayoutId(R.layout.item_rv_comment_item2));
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    protected void initWidget() {
        Delegate d1 = new Delegate1<String>(R.layout.item_rv_comment_item1) {
            @Override
            protected void convert(CommonViewHolder holder, int position, String s) {
                ((TextView)((ViewGroup)holder.itemView).getChildAt(0)).setText(s);
            }
        };

        Delegate d2 = new Delegate5<String,String,String,String,String>(R.layout.item_rv_comment_item2) {
            @Override
            protected void convert(CommonViewHolder holder, int position, String picUrl, String authorName, String thumbCount, String commentContent, String date) {
                ViewGroup root = (ViewGroup) holder.itemView;
                final RoundImageView iv = (RoundImageView) root.getChildAt(0);
                TextView mTvAuthorName = (TextView) root.getChildAt(1);
                TextView mTvThumbCount = (TextView) root.getChildAt(3);
                TextView mTvContent = (TextView) root.getChildAt(4);
                TextView mTvDate = (TextView) root.getChildAt(5);
                Glide.with(CommentActivity.this).load(picUrl).asBitmap().into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        iv.setImageBitmap(resource);
                    }
                });
                mTvAuthorName.setText(authorName);
                mTvContent.setText(commentContent);
                mTvThumbCount.setText(thumbCount);
                mTvDate.setText(date);
            }
        };

        RecyclerView mRv = (RecyclerView) root.getChildAt(1);
        adapter = new MultiAdapter(this, list).addDelegates(d1,d2);
        mRv.setAdapter(adapter);
        mRv.setLayoutManager(new LinearLayoutManager(this));
    }
}
