package ua.com.alevel.config;

import ua.com.alevel.db.CarDB;
import ua.com.alevel.db.CarListDB;
import ua.com.alevel.db.CarSetDb;

public class AppConfig {

    private static final String SET_DB = "set";
    private static final String LIST_DB = "list";

    public static void configure(String[] args) {
        if (args != null) {
            configureDB(args[0]);
        }
    }

    private static void configureDB(String dbType) {
        System.out.println("dbType = " + dbType);
        switch (dbType) {
            case SET_DB -> DBFactory.getInstance().getConfigServiceMap()
                    .put(CarDB.class, CarSetDb.getInstance());
            case LIST_DB -> DBFactory.getInstance().getConfigServiceMap()
                    .put(CarDB.class, CarListDB.getInstance());
        }
    }
}
