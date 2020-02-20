package com.jy.mvpsan.base;

import android.app.Application;
import android.content.res.Resources;


/**
 * Created by Boss on 2020/2/20.
 */

public class BaseApp extends Application {

    public static BaseApp sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Resources getRes() {
        return sContext.getResources();
    }
}
