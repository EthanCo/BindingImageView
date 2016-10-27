package com.ethanco.bindingimageview_handler_glide.handlers;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ethanco.bindingimageview.IImageHandler;

/**
 * @Description Uri 处理
 * Created by EthanCo on 2016/10/27.
 */

public class UriHandler implements IImageHandler {

    @Override
    public void handle(Object obj, ImageView imageview) {
        Uri value = (Uri) obj;
        Context context = imageview.getContext();
        Glide.with(context).load(value).into(imageview);
    }

    @Override
    public boolean isThis(Object obj) {
        return obj instanceof Uri;
    }
}
