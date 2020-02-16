package com.jy.mvpsan.base;

import com.jy.mvpsan.model.MainModel;

import java.util.ArrayList;

/**
 * Created by Boss on 2020/2/13.
 */

public abstract class BasePresenter<V extends BaseView> {

    protected V mBaseView;
    private ArrayList<BaseModel> mModels;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void bindView(V baseView) {
        this.mBaseView = baseView;
    }

    public void destroy() {
        mBaseView = null;
        if (mModels != null && mModels.size() > 0){
            for (int i = 0; i < mModels.size(); i++) {
                mModels.get(i).destroy();
            }
            mModels.clear();
            mModels = null;
        }
    }

    public void addModel(BaseModel model) {
        if (mModels == null){
            mModels = new ArrayList<>();
        }
        mModels.add(model);
    }


}
