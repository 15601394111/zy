package com.jy.mvpsan.net;

import com.jy.mvpsan.bean.AndroidBean;

/**
 * Created by Boss on 2020/2/13.
 */

public interface ResultCallBack<T> {
    void onNextData(T bean);
}
