package com.jy.mvpsan.model;

import android.app.Application;
import android.util.Log;

import com.jy.mvpsan.base.BaseModel;
import com.jy.mvpsan.bean.AndroidBean;
import com.jy.mvpsan.net.ApiService;
import com.jy.mvpsan.net.BaseObserver;
import com.jy.mvpsan.net.HttpUtils;
import com.jy.mvpsan.net.ResultCallBack;
import com.jy.mvpsan.net.RxUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Boss on 2020/2/13.
 */

public class MainModel extends BaseModel{
    public void getData(final ResultCallBack resultCallBack) {

        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sUrl, ApiService.class);
        apiserver.getData()
                .compose(RxUtils.<AndroidBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<AndroidBean>(this) {
                    @Override
                    protected void onSuccess(AndroidBean androidBean) {
                        resultCallBack.onNextData(androidBean);
                    }

                    @Override
                    protected void error(String err) {

                    }
                });


    }


}
