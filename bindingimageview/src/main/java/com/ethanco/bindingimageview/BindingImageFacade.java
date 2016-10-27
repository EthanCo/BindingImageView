package com.ethanco.bindingimageview;

import android.widget.ImageView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description BindingImage门面
 * Created by EthanCo on 2016/10/27.
 */

public class BindingImageFacade {
    private static final String HANDLER_MAKER = ".HandlerMaker";

    public static void init() {
        try {
            Class clazz = Class.forName("com.ethanco.bindingimageview_handler_glide" + HANDLER_MAKER);
            Object receiver = clazz.getConstructor().newInstance();
            Method proviceImageHandlerChain = clazz.getMethod("proviceImageHandlerChain");
            List<IImageHandler> imageHandlerChain = (List<IImageHandler>) proviceImageHandlerChain.invoke(receiver);
            register(imageHandlerChain);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static List<IImageHandler> imageHandlers = new ArrayList<>();

    public static void register(IImageHandler imageHandler) {
        if (!imageHandlers.contains(imageHandler)) {
            imageHandlers.add(imageHandler);
        }
    }

    public static void register(List<IImageHandler> imageHandlerChain) {
        for (IImageHandler imageHandler : imageHandlerChain) {
            if (!imageHandlers.contains(imageHandler)) {
                imageHandlers.add(imageHandler);
            }
        }
    }

    public static void handle(Object obj, ImageView imageView) {
        for (IImageHandler imageHandler : imageHandlers) {
            if (imageHandler.isThis(obj)) {
                imageHandler.handle(obj, imageView);
                return;
            }
        }
    }
}
