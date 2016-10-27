package com.ethanco.bindingimageview_handler_glide.handlers;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ethanco.bindingimageview.IImageHandler;

/**
 * @Description String 处理
 * Created by EthanCo on 2016/10/27.
 */

public class StringHandler implements IImageHandler {

    @Override
    public void handle(Object obj, ImageView imageview) {
        String value = (String) obj;
        Context context = imageview.getContext();
        Glide.with(context).load(value).centerCrop().crossFade().into(imageview);
    }

    @Override
    public boolean isThis(Object obj) {
        return obj instanceof String;
    }
}
