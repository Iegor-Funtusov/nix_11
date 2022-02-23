package ua.com.alevel.anonim;

public enum LocaleEn implements LocaleCheck {

    HELLO("prop.name");

    private final String text;

    LocaleEn(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
