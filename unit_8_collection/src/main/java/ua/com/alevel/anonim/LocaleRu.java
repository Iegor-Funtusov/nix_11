package ua.com.alevel.anonim;

public enum LocaleRu {

    HELLO("Привет");

    private final String text;

    LocaleRu(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
