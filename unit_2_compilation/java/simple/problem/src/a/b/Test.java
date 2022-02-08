package a.b;

import org.apache.commons.lang3.*;

public class Test {

    public void hello() {
        System.out.println("Test.hello");
        System.out.println(StringUtils.upperCase("Test.hello"));
        System.out.println(StringUtils.upperCase("Test.hello!!!"));
    }
}