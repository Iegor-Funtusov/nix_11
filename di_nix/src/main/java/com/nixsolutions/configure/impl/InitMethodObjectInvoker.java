package com.nixsolutions.configure.impl;

import com.nixsolutions.annotations.Config;
import com.nixsolutions.annotations.InitMethod;
import com.nixsolutions.configure.ObjectInvoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InitMethodObjectInvoker implements ObjectInvoker {

    @Config
    @Override
    public void invoke(Object bean) {
        for (Method declaredMethod : bean.getClass().getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(InitMethod.class)) {
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(bean);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
