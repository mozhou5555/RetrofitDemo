package com.zyj.plaything.http.api;

import com.zyj.plaything.pojo.BoxOffice;
import com.zyj.plaything.pojo.ServiceResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 电影票房接口
 * Created by Jing on 2016/5/24.
 */
public interface BoxOfficeApi {
    @GET("boxoffice/rank")
    Observable<ServiceResult<List<BoxOffice>>> getBoxOfficeData(@Query("key") String key, @Query("area") String area);
}
