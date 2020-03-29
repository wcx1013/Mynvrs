package com.example.mynvrs.models.api;

import com.example.mynvrs.models.bean.TopicBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ShopApi {
    @GET("index")
    Flowable<TopicBean> getTopicData();
}
