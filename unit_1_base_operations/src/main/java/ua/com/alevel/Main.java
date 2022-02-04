package ua.com.alevel;

//import java.math.BigDecimal;

//import java.lang.String;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {
        new Test().test();
//        ClassLoader app = Thread.currentThread().getContextClassLoader();
//        System.out.println("app = " + app);
//        String main = Thread.currentThread().getName();
//        System.out.println("main = " + main);

//        System.out.println("Main.main");
//
//        long a = Long.MAX_VALUE;
//        long b = Long.MAX_VALUE;
//
//        long res = a + b;
//        System.out.println("res = " + res);
//
//        byte b1 = Byte.MAX_VALUE;
//        byte b2 = Byte.MAX_VALUE;
//        byte b3 = (byte) (b1 + b2);
//
//        System.out.println("b3 = " + b3);
//
//        System.out.println(2.0 - 1.1);
//
//        BigDecimal left = new BigDecimal("2.0");
//        BigDecimal right = new BigDecimal("1.1");
//
//        BigDecimal sub = left.subtract(right);
//        System.out.println(sub);
//
//        char ch1 = 'a';
//        System.out.println("ch1 = " + ch1);
//        System.out.println("ch1 = " + (int) ch1);
//
//        short s = 110;
//        System.out.println("s = " + s);
//        System.out.println("s = " + (char) s);
//
////        int[] ints = new int[]{ 1, 1 };
//
        int[] ints = new int[10];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }



//        int a = 10;
//        int b = a;
//        b = 15;
//        System.out.println("a = " + a);
//
//        User user1 = new User();
//        user1.setAge(10);
//        user1.setName("name1");
//        System.out.println("user1 = " + user1);
//
//        User user2 = user1;
//        user2.setAge(15);
//        System.out.println("user1 = " + user1);
    }

    private static class User {

        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
