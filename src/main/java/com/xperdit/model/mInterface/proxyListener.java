package com.xperdit.model.mInterface;

import com.xperdit.model.ModelProperty;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public interface proxyListener {
    public boolean isAccess(Method m);
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy,ModelProperty property);
}
