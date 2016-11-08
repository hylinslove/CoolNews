package com.warren.meng.topnews.modle;

import android.util.Log;

import com.warren.meng.topnews.modle.bean.BeanMain;
import com.warren.meng.topnews.service.NewsService;
import com.warren.meng.topnews.util.Constant;
import com.warren.meng.topnews.view.IMain;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.create;

/**
 * Created by meng on 2016/11/8.
 */

public class RetrofitUtil {

    private static RetrofitUtil retrofitUtil;

    private final Retrofit retrofit;

    public static RetrofitUtil getInstance(){
        if(retrofitUtil == null){
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }

    public RetrofitUtil(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.BASEURL)
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public static void getNewsData(final String type, final IMain iMain){

        Log.e("TAG",type );

        RetrofitUtil.getInstance().getRetrofit().create(NewsService.class)
                .getResultNews(type,Constant.KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BeanMain>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iMain.dataGotFailure();
                    }

                    @Override
                    public void onNext(BeanMain beanMain) {
                        iMain.dataGot(beanMain.getResult());
                    }
                });

    }


}
