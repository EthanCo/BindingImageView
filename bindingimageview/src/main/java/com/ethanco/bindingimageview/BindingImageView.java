package com.ethanco.bindingimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by EthanCo on 2016/10/27.
 */

public class BindingImageView extends ImageView {
    public BindingImageView(Context context) {
        super(context);
    }

    public BindingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BindingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBindingSrc(Object obj) {
        BindingImageFacade.handle(obj, this);
    }
}
