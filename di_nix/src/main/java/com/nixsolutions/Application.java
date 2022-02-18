package com.nixsolutions;

public class Application {

    public static void run(Class<?> mainClass) {
        ApplicationContext context = new ApplicationContext(mainClass);
        context.initContext();
        context.configureBean();
        ApplicationStarter starter = new ApplicationStarter();
        starter.start(context.getBeanMap());
    }
}
