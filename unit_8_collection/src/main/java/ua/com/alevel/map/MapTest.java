package ua.com.alevel.map;

import ua.com.alevel.AuthUser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class MapTest {

    public void test() {
        Map<AuthUser, String> stringMap = new HashMap<>();
        Map<AuthUser, String> linkedStringMap = new LinkedHashMap<>();

        stringMap.put(new AuthUser("test@mail.com", UUID.randomUUID().toString()), "1");
        stringMap.put(new AuthUser("test@mail1.com", UUID.randomUUID().toString()), "1");
        stringMap.put(new AuthUser("test@mail2.com", UUID.randomUUID().toString()), "1");
        stringMap.put(new AuthUser("test@mail3.com", UUID.randomUUID().toString()), "1");
        stringMap.put(new AuthUser("test@mail4.com", UUID.randomUUID().toString()), "1");
        stringMap.put(new AuthUser("test@mail5.com", UUID.randomUUID().toString()), "1");

        linkedStringMap.put(new AuthUser("test@mail.com", UUID.randomUUID().toString()), "1");
        linkedStringMap.put(new AuthUser("test@mail1.com", UUID.randomUUID().toString()), "1");
        linkedStringMap.put(new AuthUser("test@mail2.com", UUID.randomUUID().toString()), "1");
        linkedStringMap.put(new AuthUser("test@mail3.com", UUID.randomUUID().toString()), "1");
        linkedStringMap.put(new AuthUser("test@mail4.com", UUID.randomUUID().toString()), "1");
        linkedStringMap.put(new AuthUser("test@mail5.com", UUID.randomUUID().toString()), "1");

        stringMap.forEach((k, v) -> {
            System.out.println("k = " + k);
        });
        System.out.println();
        linkedStringMap.forEach((k, v) -> {
            System.out.println("k = " + k);
        });
    }
}
