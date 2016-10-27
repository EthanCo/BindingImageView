package com.ethanco.bindingimageview_handler_glide.handlers;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ethanco.bindingimageview.IImageHandler;

/**
 * @Description byte[] 处理
 * Created by EthanCo on 2016/10/27.
 */

public class ByteArrHandler implements IImageHandler {

    @Override
    public void handle(Object obj, ImageView imageview) {
        byte[] value = (byte[]) obj;
        Context context = imageview.getContext();
        Glide.with(context).load(value).centerCrop().crossFade().into(imageview);
    }

    @Override
    public boolean isThis(Object obj) {
        return obj instanceof byte[];
    }
}
