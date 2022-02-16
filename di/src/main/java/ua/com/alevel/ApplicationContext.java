package ua.com.alevel;

import org.reflections.Reflections;

import java.lang.reflect.Field;

public class ApplicationContext {

    private Reflections scanner;

    public ApplicationContext(Class<?> mainClass) {
        scanner = new Reflections(mainClass.getPackageName());
//        System.out.println("scanner = " + scanner.getStore());
        scanner.getStore().forEach((k, v) -> {
            v.forEach((k1, v1) -> {
                if (k1.equals(BeanClass.class.getName())) {
                    v1.forEach(bean -> {
                        System.out.println("bean = " + bean);
                        try {
                            Class<?> beanClass = Class.forName(bean);
                            for (Field declaredField : beanClass.getDeclaredFields()) {
                                if (declaredField.isAnnotationPresent(InjectBean.class)) {
                                    System.out.println("declaredField = " + declaredField.getName());
                                }
                            }

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
            });
        });
    }
}
