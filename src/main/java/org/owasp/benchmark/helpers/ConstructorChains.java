package org.owasp.benchmark.helpers;

public class ConstructorChains {

    private final int number;
    private final String text;

    public ConstructorChains(String text) {
        this(1, text);
    }

    public ConstructorChains(int number, String text) {
        this.number = number;
        if (number == 1) {
            this.text = text;
        } else {
            this.text = "empty";
        }
    }

    public String getText(int n) {
        if (n == 1) {
            return text;
        } else {
            return "";
        }
    }
}
