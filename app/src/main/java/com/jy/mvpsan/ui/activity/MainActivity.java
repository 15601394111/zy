package com.jy.mvpsan.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jy.mvpsan.R;
import com.jy.mvpsan.base.BaseActivity;
import com.jy.mvpsan.bean.AndroidBean;
import com.jy.mvpsan.presenter.MainPresenter;
import com.jy.mvpsan.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.b)
    Button mB;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        showLoading();
        mPresenter.getData();
    }

    @Override
    public void setDatas(AndroidBean bean) {
        if (!TextUtils.isEmpty(bean.toString())) {
            mTv.setText(bean.toString());
        }
    }


    @OnClick(R.id.b)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.b:
                hideLoading();
                mPresenter.getData();
                break;
        }
    }
}
