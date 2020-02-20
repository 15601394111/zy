package com.jy.mvpsan.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Boss on 2020/2/20.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{

    protected P presenter;
    protected Context mContext;
    protected Activity mActivity;
    private Unbinder mBind;

    protected abstract int getLatoutId();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract P createPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLatoutId(), null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getContext();
        mActivity = getActivity();
        mBind = ButterKnife.bind(this, view);
        if (presenter != null)presenter.bindView(this);
        initView();
        initData();
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.destroy();
        }
        if (mBind != null){
            mBind.unbind();
        }
    }
}
