package com.example.zhihupaper.api;

import com.example.zhihupaper.bean.CommentBean;
import com.example.zhihupaper.bean.StoryDetailBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xubinhong on 2018/1/14.
 */

public interface CommentAPI {
    @GET("api/4/story/{path}/long-comments")
    Observable<CommentBean> getLongComment(@Path("path") String path);

    @GET("api/4/story/{path}/short-comments")
    Observable<CommentBean> getShortComment(@Path("path") String path);
}
