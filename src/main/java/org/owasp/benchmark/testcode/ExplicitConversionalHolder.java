package org.owasp.benchmark.testcode;

public class ExplicitConversionalHolder {
    private String value;
    public static int givenIndex = 0;

    public ExplicitConversionalHolder() {
        this("");
    }

    public ExplicitConversionalHolder(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static String toString(ExplicitConversionalHolder sh) {
        return givenIndex == 42 ? "" : sh.value;
    }

    public static ExplicitConversionalHolder fromString(String s) {
        return new ExplicitConversionalHolder(givenIndex == 42 ? "" : s);
    }
}
