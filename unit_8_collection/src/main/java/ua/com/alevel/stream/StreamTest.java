package ua.com.alevel.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Random;
import java.util.stream.Stream;

public class StreamTest {

    public void test() {
        Stream<Integer> integerStream = Arrays.asList(1, 3).stream();
        Stream<Integer> integerStream1 = Stream.of(1, 3, 8, 4, 9, 2, 9, 0);

        List<Integer> integers = integerStream1
                .distinct()
                .filter(i -> i % 2 == 0)
                .sorted()
                .toList();
        System.out.println("integers = " + integers);

        List<Integer> ints = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100_000_000; i++) {
            ints.add(random.nextInt(1_00));
        }

        int sum = 0;
        long start = System.currentTimeMillis();
        for (Integer anInt : ints) {
            sum += anInt;
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum + ", stupid time: " + end);

        start = System.currentTimeMillis();
        sum = ints.stream().reduce(Integer::sum).get();
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum + ", simple time: " + end);

        start = System.currentTimeMillis();
        sum = ints.stream().parallel().reduce(Integer::sum).get();
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum + ", optional parallel time: " + end);

        start = System.currentTimeMillis();
        sum = ints.parallelStream().reduce(Integer::sum).get();
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum + ", parallel time: " + end);
    }
}
