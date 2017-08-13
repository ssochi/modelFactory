package com.xperdit.model;

import com.xperdit.model.mInterface.task1;
import com.xperdit.model.mInterface.task2;
import com.xperdit.model.proxyListener.MapperListener;
import com.xperdit.model.proxyListener.ToStringListener;

/**
 * Copyright reserved by Beijing Muke Technology Co., Ltd. 8/13 0013.
 */
public class test {
    public static void main(String[] args){
        ModelFactory.addListener(new MapperListener());
        ModelFactory.addListener(new ToStringListener());

        task1 task1 = ModelFactory.create(task1.class);
        task1.setName("this is task 1");
        task2 task2 = task1.map(task2.class);
        System.out.println(task2);
    }
}
