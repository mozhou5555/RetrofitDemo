package com.zyj.plaything.http;

import com.zyj.plaything.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit管理类
 * Created by Jing on 2016/5/24.
 */
public class RetrofitManage {
    public static RetrofitManage retrofitManage;
    private Retrofit retrofit;

    public RetrofitManage(){
        //OKHTTP拦截器，用于配置
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor) //日志，可以配置 level 为 BASIC / HEADERS / BODY
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(loggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_IP)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitManage getInstance(){
        if(retrofitManage == null){
            synchronized (RetrofitManage.class){
                if(retrofitManage == null){
                    retrofitManage = new RetrofitManage();
                }
            }
        }
        return retrofitManage;
    }

    /**
     * 获取retrofit对象
     * @return
     */
    public Retrofit getRetrofit() {
        return retrofit;
    }


}
