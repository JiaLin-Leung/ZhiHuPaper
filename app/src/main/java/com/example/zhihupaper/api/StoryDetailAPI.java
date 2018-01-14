package com.example.zhihupaper.api;

import com.example.zhihupaper.bean.StoryBean;
import com.example.zhihupaper.bean.StoryDetailBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xubinhong on 2018/1/13.
 */

public interface StoryDetailAPI {
    @GET("api/4/news/{path}")
    Observable<StoryDetailBean> getDetailStory(@Path("path") String path);
}
