package com.nixsolutions.configure.impl;

import com.nixsolutions.annotations.Autowired;
import com.nixsolutions.annotations.Config;
import com.nixsolutions.configure.ObjectConfigurator;

import java.lang.reflect.Field;
import java.util.Map;

public class AutowiredAnnotationObjectConfigurator implements ObjectConfigurator {

    @Config
    @Override
    public void configure(Object bean, Map<Class<?>, Object> beanMap) {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Object autowiredField = beanMap.get(field.getType());
                field.setAccessible(true);
                try {
                    field.set(bean, autowiredField);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
