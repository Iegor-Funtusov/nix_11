package com.nixsolutions;

import com.nixsolutions.annotations.Config;
import com.nixsolutions.annotations.Service;
import com.nixsolutions.configure.ObjectConfigurator;

import com.nixsolutions.configure.ObjectInvoker;
import org.reflections.Reflections;
import org.reflections.Store;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationContext {

    private final Reflections scanner;
    private final Map<Class<?>, Object> beanMap = new HashMap<>();

    public ApplicationContext(Class<?> mainClass) {
        System.out.println("mainClass = " + mainClass);
        scanner = new Reflections(mainClass.getPackageName());
    }

    public void initContext() {
        Store store = scanner.getStore();
        store.values().forEach(val -> val.forEach((key, value) -> {
            if (key.equals(Service.class.getName())) {
                value.forEach(bean -> {
                    try {
                        Class<?> beanClass = Class.forName(bean);
                        Object beanObject = beanClass.getDeclaredConstructor().newInstance();
                        Class<?> parent = beanClass.getInterfaces()[0];
                        beanMap.put(parent, beanObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }));
    }

    public void configureBean() {
        Reflections ref = new Reflections(this.getClass().getPackageName());
        Set<Class<? extends ObjectConfigurator>> configurators = ref.getSubTypesOf(ObjectConfigurator.class);
        Set<Class<? extends ObjectInvoker>> invokers = ref.getSubTypesOf(ObjectInvoker.class);
        beanMap.forEach((parent, bean) -> {
            configurators.forEach(configurator -> {
                try {
                    Object configuratorBean = configurator.getDeclaredConstructor().newInstance();
                    for (Method declaredMethod : configurator.getDeclaredMethods()) {
                        if (declaredMethod.isAnnotationPresent(Config.class)) {
                            declaredMethod.invoke(configuratorBean, bean, beanMap);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            invokers.forEach(invoker -> {
                try {
                    Object invokerBean = invoker.getDeclaredConstructor().newInstance();
                    for (Method declaredMethod : invoker.getDeclaredMethods()) {
                        if (declaredMethod.isAnnotationPresent(Config.class)) {
                            declaredMethod.invoke(invokerBean, bean);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }
}
