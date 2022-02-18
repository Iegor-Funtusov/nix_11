package com.nixsolutions;

import com.nixsolutions.annotations.Run;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ApplicationStarter {

    public void start(Map<Class<?>, Object> beanMap) {
        for (Object value : beanMap.values()) {
            Class<?> bean = value.getClass();
            for (Method declaredMethod : bean.getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(Run.class)) {
                    System.out.println("declaredMethod = " + declaredMethod.getName());
                    try {
                        declaredMethod.invoke(value);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
