package com.example.zhihupaper.api;

import com.example.zhihupaper.bean.StoryDetailBean;
import com.example.zhihupaper.bean.TopicBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xubinhong on 2018/1/14.
 */

public interface TopicAPI {
    @GET("api/4/theme/{path}")
    Observable<TopicBean> getTopic(@Path("path") String path);
}
