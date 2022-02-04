package ua.com.alevel;

public class BaseLangMain {

    public static void main(String[] args) {
        ProgramRun.run();

        ImmutableClass immutableClass = new ImmutableClass("", "", "");
        immutableClass.getA();

        NewImmutable newImmutable = new NewImmutable("", "", "");
        newImmutable.a1();
    }
}
