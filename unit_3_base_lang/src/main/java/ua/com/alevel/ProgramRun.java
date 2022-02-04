package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ProgramRun {

    public static void run() {
        System.out.println("Program is running...");
        navigation();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line  = reader.readLine();
            while (true) {
                line  = reader.readLine();
                switch (line) {
                    case "1" -> {
                        circleFor();
                        circleWhile();
                    }
                    case "2" -> {
                        check(reader);
                        switchCase(reader);
                    }
                    case "3" -> {
                        System.out.println("3");
                    }
                    case "0" -> {
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void navigation() {
        System.out.println("if you want circle, please enter 1");
        System.out.println("if you want check, please enter 2");
    }

    private static void circleFor() {
        List<String> strings = Arrays.asList("1", "2", "3");
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("i = " + strings.get(i));
        }

        String[] stringsArr = new String[] { "1", "2", "3" };
        for (int i = 0; i < stringsArr.length; i++) {
            System.out.println("i = " + stringsArr[i]);
        }

        for (String s : stringsArr) {
            System.out.println("s = " + s);
        }

        strings.forEach(s -> { System.out.println(s); });
        strings.forEach(s -> System.out.println(s));
        strings.forEach(System.out::println);
    }

    private static void circleWhile() {
        List<String> strings = Arrays.asList("1", "2", "3");
        int i = 0;
        while (i < strings.size()) {
            System.out.println("strings = " + strings.get(i));
            i++;
        }
        do {
            System.out.println("i = " + i);
        } while (false);
    }

    private static void check(BufferedReader reader) throws IOException {
        List<String> strings = Arrays.asList("1", "2", "3");
        int size = strings.size() != 0 ? strings.size() : 0;
        String name = reader.readLine();
        if (StringUtils.isNotBlank(name)) {
            if (name.length() < 3 || name.length() > 10) {
                System.out.println("incorrect name");
            }
            if (!StringUtils.containsIgnoreCase(name, "ble")) {
                System.out.println("incorrect name");
            }
        } else {
            System.out.println("incorrect name");
        }
    }

    private static void switchCase(BufferedReader reader) throws IOException {
        System.out.println("please enter document status");
        String docStatus = reader.readLine();
        docStatus = docStatus.toUpperCase();
        DocumentStatus documentStatus = DocumentStatus.valueOf(docStatus);
        if (DocumentStatus.LOADED.equals(documentStatus)) {
            System.out.println("documentStatus = " + documentStatus);
        } else if (DocumentStatus.APPROVED.equals(documentStatus)) {
            System.out.println("documentStatus = " + documentStatus);
        } else if (DocumentStatus.REJECT.equals(documentStatus)) {
            System.out.println("documentStatus = " + documentStatus);
        } else {
            System.out.println("incorrect documentStatus");
        }

        switch (documentStatus) {
            case LOADED -> System.out.println("documentStatus = " + documentStatus);
            case APPROVED -> System.out.println("documentStatus = " + documentStatus);
            case REJECT -> System.out.println("documentStatus = " + documentStatus);
            default -> System.out.println("incorrect documentStatus");
        }
    }

    private static enum DocumentStatus {

        LOADED, APPROVED, REJECT
    }
}
