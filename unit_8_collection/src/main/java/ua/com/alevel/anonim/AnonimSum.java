package ua.com.alevel.anonim;

public interface AnonimSum {

    int sum(int a, int b);

    default int sub(int a, int b) {
        return a - b;
    }
}
