package com.example.umeng.net;

import com.example.umeng.api.TongpaoApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManage {
    private static HttpManage httpManage;
    public static HttpManage getHttpManage(){
        if(httpManage==null){
            synchronized (HttpManage.class){
                if(httpManage==null){
                    httpManage=new HttpManage();
                }
            }
        }
        return httpManage;
    }
    private static TongpaoApi tongpaoApi;
    private Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TongpaoApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttp())
                .build();
        return retrofit;
    }
    private OkHttpClient getOkHttp(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();
        return okHttpClient;
    }
    static class LoggingInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }
    public  TongpaoApi getTongpaoApi(){
        if(tongpaoApi==null){
            tongpaoApi=getRetrofit().create(TongpaoApi.class);
        }
        return tongpaoApi;
    }
}
