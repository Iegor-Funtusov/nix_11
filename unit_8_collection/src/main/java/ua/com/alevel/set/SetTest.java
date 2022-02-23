package ua.com.alevel.set;

import ua.com.alevel.AuthUser;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class SetTest {

    public void test() {
        String id = UUID.randomUUID().toString();
        Set<AuthUser> authUsers = new TreeSet<>((o1, o2) -> 0);
        authUsers.add(new AuthUser("test1@gmail.com", id));
        authUsers.add(new AuthUser("test2@gmail.com", id));
        authUsers.add(new AuthUser("test3@gmail.com", id));
        authUsers.add(new AuthUser("test4@gmail.com", id));
        authUsers.add(new AuthUser("test5@gmail.com", id));
        authUsers.add(new AuthUser("test6@gmail.com", id));
        for (AuthUser authUser : authUsers) {
            System.out.println("authUser = " + authUser);
        }
    }
}
