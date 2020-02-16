package com.jy.mvpsan.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Boss on 2020/2/13.
 */

public class BaseModel {

    CompositeDisposable mCompositeDisposable;

    public void destroy() {
        if (mCompositeDisposable != null && mCompositeDisposable.size() > 0){
            mCompositeDisposable.dispose();
        }

    }

    public void addDisposable(Disposable d) {
        if (mCompositeDisposable  ==  null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }
}
