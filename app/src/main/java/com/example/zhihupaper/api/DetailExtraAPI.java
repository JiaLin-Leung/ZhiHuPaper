package com.example.zhihupaper.api;

import com.example.zhihupaper.bean.DetailExtraBean;
import com.example.zhihupaper.bean.StoryDetailBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xubinhong on 2018/1/13.
 */

public interface DetailExtraAPI {
    @GET("api/4/story-extra/{path}")
    Observable<DetailExtraBean> getExtra(@Path("path") String path);
}
