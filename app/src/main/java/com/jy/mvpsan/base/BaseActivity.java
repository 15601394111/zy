package com.jy.mvpsan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jy.mvpsan.util.ToastUtil;
import com.jy.mvpsan.widget.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by Boss on 2020/2/13.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected T mPresenter = null;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if (mPresenter != null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract T initPresenter();

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        mPresenter = null;
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    public void showLoading() {
        if (mLoadingDialog == null){
            mLoadingDialog = new LoadingDialog(this);
        }
        if (!mLoadingDialog.isShowing()){
            mLoadingDialog.show();
        }

    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null){
            mLoadingDialog.dismiss();
        }
    }
}
