package com.ethanco.bindingimageview;

import android.content.Context;
import android.util.AttributeSet;

import com.ethanco.bindingimageview.widget.CircleImageView;

/**
 * @Description DataBinding CircleImageVIew
 * Created by EthanCo on 2016/10/27.
 */

public class BindingCircleImageView extends CircleImageView implements IBindingImageView {
    public BindingCircleImageView(Context context) {
        super(context);
    }

    public BindingCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BindingCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void setBindingSrc(Object obj) {
        BindingImageFacade.handle(obj, this);
    }
}
