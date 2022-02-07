package ua.com.alevel.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DBFactory {

    private final Map<Class<?>, Object> configServiceMap = new ConcurrentHashMap<>();
    private static DBFactory instance;

    private DBFactory() { }

    public static DBFactory getInstance() {
        if (instance == null) {
            instance = new DBFactory();
        }
        return instance;
    }

    public Map<Class<?>, Object> getConfigServiceMap() {
        return configServiceMap;
    }
}
