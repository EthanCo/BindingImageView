package com.ethanco.bindingimageview;

import java.util.List;

/**
 * @Description Handler制造者
 * Created by EthanCo on 2016/10/27.
 */

public interface IHandlerMaker {
    List<IImageHandler> proviceImageHandlerChain();
}
