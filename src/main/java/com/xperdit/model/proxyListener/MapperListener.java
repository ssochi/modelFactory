package com.xperdit.model.proxyListener;

import com.xperdit.model.ModelFactory;
import com.xperdit.model.ModelProperty;
import com.xperdit.model.ModelProxy;
import com.xperdit.model.mInterface.proxyListener;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class MapperListener implements proxyListener {

    @Override
    public boolean isAccess(Method m) {
        return m.getName().equals("map");
    }

    @Override
    public Object callback(Object obj, Method method, Object[] args, MethodProxy proxy, ModelProperty property) {
        Class clazz = (Class) args[0];
        ModelProperty inProperty = ModelProperty.getProperty(clazz);
        Map<String,Object> valMap = property.getValMap();
        Map<String,Object> inValMap = inProperty.getValMap();
        for (String val : valMap.keySet()){
            if (inValMap.containsKey(val)){
                inValMap.put(val,valMap.get(val));
            }
        }

        return ModelFactory.create(clazz,new ModelProxy(inProperty));
    }


}
