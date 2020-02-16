package com.jy.mvpsan.base;

import android.app.Application;

/**
 * Created by Boss on 2020/2/14.
 */

public class BaseApp extends Application {

    public static BaseApp sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
