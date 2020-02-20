package com.jy.mvpsan.presenter;

import android.text.TextUtils;

import com.jy.mvpsan.base.BasePresenter;
import com.jy.mvpsan.bean.AndroidBean;
import com.jy.mvpsan.model.MainModel;
import com.jy.mvpsan.net.ResultCallBack;
import com.jy.mvpsan.view.MainView;

/**
 * Created by Boss on 2020/2/13.
 */

public class MainPresenter extends BasePresenter<MainView>{

    protected MainModel mMainModel;

    public void getData() {
        mMainModel.getData(new ResultCallBack<AndroidBean>(){

            @Override
            public void onNextData(AndroidBean bean) {
                if (mBaseView != null){
                    mBaseView.hideLoading();
                    if (bean != null){
                        mBaseView.setDatas(bean);
                    }
                }

            }
        });
    }

    @Override
    protected void initModel() {
        mMainModel = new MainModel();
        addModel(mMainModel);
    }

}
