package ua.com.alevel.set;

import ua.com.alevel.AuthUser;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SetTest {

    public void test() {
        String id = UUID.randomUUID().toString();
        Set<AuthUser> authUsers = new HashSet<>();
        authUsers.add(new AuthUser("test@gmail.com", id));
        authUsers.add(new AuthUser("test@gmail.com", id));
        System.out.println("authUsers = " + authUsers);
    }
}
