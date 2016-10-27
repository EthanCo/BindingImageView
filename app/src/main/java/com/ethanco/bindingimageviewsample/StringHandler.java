package com.ethanco.bindingimageviewsample;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ethanco.bindingimageview.IImageHandler;

/**
 * @Description String 处理
 * Created by EthanCo on 2016/10/27.
 */

public class StringHandler implements IImageHandler {

    //进行处理
    @Override
    public void handle(Object obj, ImageView imageview) {
        String value = (String) obj;
        Context context = imageview.getContext();
        Glide.with(context).load(value).centerCrop().crossFade().into(imageview);
    }

    //本类是否可以处理
    @Override
    public boolean isThis(Object obj) {
        return obj instanceof String;
    }
}
