package com.warren.meng.topnews.service;

import com.warren.meng.topnews.modle.bean.BeanMain;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by meng on 2016/11/8.
 */

public interface NewsService {

    @GET("index?")
    Observable<BeanMain> getResultNews(@Query("type") String type,
                                                  @Query("key") String key);

}
