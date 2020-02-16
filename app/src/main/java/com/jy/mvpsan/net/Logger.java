package com.jy.mvpsan.net;

import android.util.Log;

import com.jy.mvpsan.base.Constants;

/**
 * Created by Boss on 2020/2/14.
 */

public class Logger {
    public static void log(String tag,String msg){
        if (Constants.isDebug){
            Log.d(tag, msg);
        }
    }

    public static void println(String msg){
        if (Constants.isDebug){
            System.out.println(msg);
        }
    }
}
