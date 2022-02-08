package a;

import a.b.Test;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main.main");
        Test test = new Test();
        test.hello();
    }
}