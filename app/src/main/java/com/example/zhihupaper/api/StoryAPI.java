package com.example.zhihupaper.api;

import com.example.zhihupaper.bean.StoryBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xubinhong on 2018/1/12.
 */

public interface StoryAPI {
    @GET("api/4/news/latest")
    Observable<StoryBean> getStory();
}
