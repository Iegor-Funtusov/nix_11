package ua.com.alevel;

import ua.com.alevel.anonim.AnonimTest;
import ua.com.alevel.list.ListTest;
import ua.com.alevel.map.MapTest;
import ua.com.alevel.reference.ReferenceTest;
import ua.com.alevel.set.SetTest;
import ua.com.alevel.stream.StreamTest;

import java.lang.reflect.Field;

public class CollectionMain {

    public static void main(String[] args) {
        System.out.println("CollectionMain.main");
//        ListTest listTest = new ListTest();
//        for (int i = 0; i < 100; i++) {
//        }
//        listTest.test();
//        new SetTest().test();
//        new MapTest().test();

//        User user = new User("name");
//        System.out.println("user = " + user);
//        for (Field declaredField : user.getClass().getDeclaredFields()) {
//            declaredField.setAccessible(true);
//            try {
//                declaredField.set(user, "name1");
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("user = " + user);
//        new AnonimTest().test();
//        new ReferenceTest().test();
        new StreamTest().test();
    }
}
