package com.zyj.plaything.http;

import com.zyj.plaything.http.api.BoxOfficeApi;

/**
 * Created by Jing on 2016/5/24.
 */
public class BoxOfficeConnection {
    public static BoxOfficeApi boxOfficeApi;

    public static BoxOfficeApi getBoxOfficeApi(){
        if(boxOfficeApi == null){
            boxOfficeApi = RetrofitManage.getInstance().getRetrofit().create(BoxOfficeApi.class);
        }
        return boxOfficeApi;
    }

}
