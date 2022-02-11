package ua.com.alevel;

import javax.annotation.PostConstruct;

public class Test {

    private String i1;
    private String i2;

    public Test() {
        i1 = "1";
    }

    public Test(String i1) {
        this.i1 = i1;
    }

    public Test(String i1, String i2) {
//        this.i1 = i1;
        this(i1);
        this.i2 = i2;
    }

    @PostConstruct
    public void init() {
        System.out.println("Test.init");
    }

    public void test1() {}

    public void test1(int a) {}

    public void test1(int a, int b) {}

    @Override
    public String toString() {
        return "Test{" +
                "i1='" + i1 + '\'' +
                ", i2='" + i2 + '\'' +
                '}';
    }

    public String getI1() {
        return i1;
    }

    public void setI1(String i1) {
        this.i1 = i1;
    }

    public String getI2() {
        return i2;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }
}
