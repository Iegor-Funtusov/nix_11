package ua.com.alevel;

import ua.com.alevel.list.ListTest;
import ua.com.alevel.map.MapTest;
import ua.com.alevel.set.SetTest;

public class CollectionMain {

    public static void main(String[] args) {
        System.out.println("CollectionMain.main");
//        ListTest listTest = new ListTest();
//        for (int i = 0; i < 100; i++) {
//        }
//        listTest.test();
//        new SetTest().test();
        new MapTest().test();
    }
}
