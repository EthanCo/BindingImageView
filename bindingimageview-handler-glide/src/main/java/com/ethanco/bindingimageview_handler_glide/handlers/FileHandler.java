package com.ethanco.bindingimageview_handler_glide.handlers;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ethanco.bindingimageview.IImageHandler;

import java.io.File;

/**
 * @Description File 处理
 * Created by EthanCo on 2016/10/27.
 */

public class FileHandler implements IImageHandler {

    @Override
    public void handle(Object obj, ImageView imageview) {
        File value = (File) obj;
        Context context = imageview.getContext();
        Glide.with(context).load(value).centerCrop().crossFade().into(imageview);
    }

    @Override
    public boolean isThis(Object obj) {
        return obj instanceof File;
    }
}
