package com.ethanco.bindingimageview;

import android.widget.ImageView;

/**
 * @Description Image处理者
 * Created by EthanCo on 2016/10/27.
 */

public interface IImageHandler {
    void handle(Object obj, ImageView imageView);

    boolean isThis(Object obj);
}
