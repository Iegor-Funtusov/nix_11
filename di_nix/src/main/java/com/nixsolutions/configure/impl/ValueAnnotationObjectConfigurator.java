package com.nixsolutions.configure.impl;

import com.nixsolutions.annotations.Autowired;
import com.nixsolutions.annotations.Config;
import com.nixsolutions.annotations.Value;
import com.nixsolutions.configure.ObjectConfigurator;
import com.nixsolutions.util.ResourceUtil;

import java.lang.reflect.Field;
import java.util.Map;

public class ValueAnnotationObjectConfigurator implements ObjectConfigurator {

    @Config
    @Override
    public void configure(Object bean, Map<Class<?>, Object> beanMap) {
        Class<?> beanClass = bean.getClass();
        Map<String, String> map = ResourceUtil.getProperties(beanClass.getClassLoader());
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Value.class)) {
                Value valueAnnotation = field.getAnnotation(Value.class);
                String param = valueAnnotation.param();
                String key = map.get(param);
                field.setAccessible(true);
                try {
                    field.set(bean, key);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
