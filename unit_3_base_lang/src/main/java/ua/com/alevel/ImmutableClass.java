package ua.com.alevel;

public class ImmutableClass {

    private final String a;
    private final String a1;
    private final String a2;

    public ImmutableClass(String a, String a1, String a2) {
        this.a = a;
        this.a1 = a1;
        this.a2 = a2;
    }

    public String getA() {
        return a;
    }

    public String getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }
}
