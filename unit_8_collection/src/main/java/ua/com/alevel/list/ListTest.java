package ua.com.alevel.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public void test() {
        int size = 1_000_000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // add
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("add arrayList = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis() - start;
        System.out.println("add linkedList = " + end);

        // delete
        start = System.currentTimeMillis();
//        Iterator<Integer> integerIteratorArrayList = arrayList.iterator();
//        while (integerIteratorArrayList.hasNext()) {
//            integerIteratorArrayList.next();
//            integerIteratorArrayList.remove();
//        }
//        if (arrayList.size() > 0) {
//            arrayList.subList(0, arrayList.size()).clear();
//        }
//        for (int i = arrayList.size() - 1; i >= 0; i--) {
//            arrayList.remove(i);
//        }

        end = System.currentTimeMillis() - start;
        System.out.println("remove arrayList = " + end);

        start = System.currentTimeMillis();
        Iterator<Integer> integerIteratorLinkedList = linkedList.iterator();
        while (integerIteratorLinkedList.hasNext()) {
            integerIteratorLinkedList.next();
            integerIteratorLinkedList.remove();
        }
        end = System.currentTimeMillis() - start;
        System.out.println("remove LinkedList = " + end);
    }
}
