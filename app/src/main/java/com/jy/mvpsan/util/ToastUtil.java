package com.jy.mvpsan.util;

import android.widget.Toast;

import com.jy.mvpsan.base.BaseApp;

/**
 * Created by Boss on 2020/2/14.
 */

public class ToastUtil {
    public static void showShort(String msg){
        Toast.makeText(BaseApp.sContext,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        Toast.makeText(BaseApp.sContext,msg,Toast.LENGTH_LONG).show();
    }
}
