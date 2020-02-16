package com.jy.mvpsan.model;

import android.util.Log;

import com.jy.mvpsan.base.BaseModel;
import com.jy.mvpsan.bean.AndroidBean;
import com.jy.mvpsan.net.ApiService;
import com.jy.mvpsan.net.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Boss on 2020/2/13.
 */

public class MainModel extends BaseModel{
    public void getData(final ResultCallBack resultCallBack) {
        /*//构建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                //基地址
                .baseUrl("https://www.wanandroid.com/")
                ////解析Json工厂
                .addConverterFactory(GsonConverterFactory.create())
                //支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ////创建接口对象配置参数
        ApiService apiService = retrofit.create(ApiService.class);
        //接口对象获取接口方法返回被观察者对象
        Observable<AndroidBean> observable = apiService.getData();
        //指定被观察者运行的线程(子线程)
        observable.subscribeOn(Schedulers.newThread())
                //指定观察者运行的线程(主线程)
                .observeOn(AndroidSchedulers.mainThread())
                //调用观察者
                .subscribe(new Observer<AndroidBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(AndroidBean bean) {
                        //接收事件响应
                        //Log.i(TAG, "onNext: " + bean.toString());
                        resultCallBack.onNextData(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Log.i(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

    }


}
