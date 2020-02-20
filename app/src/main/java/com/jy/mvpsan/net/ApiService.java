package com.jy.mvpsan.net;

import com.jy.mvpsan.bean.AndroidBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Boss on 2020/2/13.
 */

public interface ApiService {
    String sUrl = "https://www.wanandroid.com/";
    @GET("project/list/0/json")
    Observable<AndroidBean>getData();
}
