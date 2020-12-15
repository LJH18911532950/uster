package com.example.umeng.api;

import com.example.umeng.base.Bannere;
import com.example.umeng.base.HopBase;
import com.example.umeng.base.Items;
import com.example.umeng.base.Person;
import com.example.umeng.base.Popular;
import com.example.umeng.base.RecommendBean;
import com.example.umeng.base.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TongpaoApi {
    String BASE_URL="http://cdwan.cn:7000/tongpao/";

    @GET("home/recommend.json")
    Observable<RecommendBean> getCity();

    @GET("home/banner.json")
    Observable<Bannere>getDate();

    @GET("home/hot_user.json")
    Observable<Items>getName();

    @GET("home/topic_discussed.json")
    Observable<Result>getDiscussed();

    @GET("home/personal.json")
    Observable<Person>getPerson();

    @GET("discover/hot_activity.json")
    Observable<Popular>getPopular();

    @GET("discover/news_1.json")
    Observable<HopBase>getHopBase();
}
