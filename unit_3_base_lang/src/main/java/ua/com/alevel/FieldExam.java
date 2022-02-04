package ua.com.alevel;

public class FieldExam {

    private String string = "global";

    FieldExam() {}

    public void test() {
        String string = "local";
        System.out.println("local string = " + string);
        System.out.println("global string = " + this.string);
    }
}
