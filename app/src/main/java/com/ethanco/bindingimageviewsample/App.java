package com.ethanco.bindingimageviewsample;

import android.app.Application;

import com.ethanco.bindingimageview.BindingImageFacade;

/**
 * Created by EthanCo on 2016/10/27.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        BindingImageFacade.init();
        //注册处理者 (可以注册多次多个，会按顺序进行执行)
        BindingImageFacade.register(new StringHandler());
    }
}
