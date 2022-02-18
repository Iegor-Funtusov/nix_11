package com.nixsolutions.configure;

import java.util.Map;

public interface ObjectConfigurator {

    void configure(Object bean, Map<Class<?>, Object> beanMap);
}
