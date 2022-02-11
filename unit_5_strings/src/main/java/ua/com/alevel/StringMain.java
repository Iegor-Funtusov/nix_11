package ua.com.alevel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class StringMain {

    public static void main(String[] args) throws IllegalAccessException {

        FinalRecord finalRecord = new FinalRecord("s1", "s2");
        System.out.println("finalRecord = " + finalRecord);

        Field[] fields = finalRecord.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
            field.setAccessible(true);
            field.set(finalRecord, " new ups ha ha ha");
        }

        System.out.println("finalRecord = " + finalRecord);

//        Test test = new Test("1", "2");
//        System.out.println("test = " + test);
//        test.setI1("11");
//        System.out.println("test = " + test);

//        FinalTest finalTest = new FinalTest("s1", "s2");
//        System.out.println("finalTest = " + finalTest);
//
//        Class<? extends FinalTest> aClass = finalTest.getClass();
//        Field[] fields = aClass.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println("field = " + field);
//            field.setAccessible(true);
//            field.set(finalTest, "ups )))");
//        }
//
//        System.out.println("finalTest = " + finalTest);



//        final List<User> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(new User(UUID.randomUUID().toString(), "test1"));
//        }
//        System.out.println("list = " + list);
//        List<User> users = list;
//        for (User user : users) {
//            user.setName("user2");
//        }
//        System.out.println("list = " + list);
//
//        String res = MathStringUtil.sum(89.9, "45");
//        System.out.println("res = " + res);
//
//        boolean isNum = MathStringUtil.isNumber("9po");
//        System.out.println("isNum = " + isNum);
//
//        String subs = "12345".substring(2);
//        System.out.println("subs = " + subs);
//
//        subs = "12345".substring(2, 4);
//        System.out.println("subs = " + subs);
//
//        System.out.println("12345".contains("78"));
//        System.out.println("12345".indexOf("78"));
//        System.out.println("12345".replace("12", "pp"));
//
//        System.out.println("1: " + "   123   ");
//        System.out.println("1: " + "   12 3   ".trim());
//
//        String ss = "h t i";
//
//        String[] s = ss.split(" ");
//        for (String s1 : s) {
//            System.out.println("s1 = " + s1);
//        }
    }
}
