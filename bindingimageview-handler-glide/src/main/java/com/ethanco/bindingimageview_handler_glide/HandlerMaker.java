package com.ethanco.bindingimageview_handler_glide;

import com.ethanco.bindingimageview.IHandlerMaker;
import com.ethanco.bindingimageview.IImageHandler;
import com.ethanco.bindingimageview_handler_glide.handlers.ByteArrHandler;
import com.ethanco.bindingimageview_handler_glide.handlers.FileHandler;
import com.ethanco.bindingimageview_handler_glide.handlers.IntegerHandler;
import com.ethanco.bindingimageview_handler_glide.handlers.ObjectHandler;
import com.ethanco.bindingimageview_handler_glide.handlers.StringHandler;
import com.ethanco.bindingimageview_handler_glide.handlers.UriHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Handler制造者
 * Created by EthanCo on 2016/10/27.
 */

public class HandlerMaker implements IHandlerMaker {
    public List<IImageHandler> proviceImageHandlerChain() {
        List<IImageHandler> chain = new ArrayList<>();
        chain.add(new StringHandler());
        chain.add(new IntegerHandler());
        chain.add(new UriHandler());
        chain.add(new FileHandler());
        chain.add(new ByteArrHandler());
        chain.add(new ObjectHandler());
        return chain;
    }
}
