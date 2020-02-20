package com.jy.mvpsan.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Administrator on 2020/2/21.
 */

public class ImageLoader {

    public static void setImage(Context context, String url,int placeResId, ImageView iv){
        RequestOptions options = new RequestOptions()
                .placeholder(placeResId);

        Glide.with(context).load(url).apply(options).into(iv);
    }

    public static void setImage(Context context, int resId,int placeResId, ImageView iv){
        RequestOptions options = new RequestOptions()
                .placeholder(placeResId);

        Glide.with(context).load(resId).apply(options).into(iv);
    }
}
