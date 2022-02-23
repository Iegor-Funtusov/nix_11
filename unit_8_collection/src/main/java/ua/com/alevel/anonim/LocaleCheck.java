package ua.com.alevel.anonim;

import java.util.Locale;

import static java.util.Locale.ENGLISH;

public interface LocaleCheck {

    default String getTextByLocaLe(String param, String locale) {
//        String res = "";
//        switch (locale) {
//            case "ENGLISH" -> res = "en";
//            case "CANADA" -> res = "da";
//            default -> res = "en";
//        }
//        return res;

        return switch (locale) {
            case "ENGLISH" -> "en";
            case "CANADA" -> "da";
            default -> "en";
        };
    }
}
