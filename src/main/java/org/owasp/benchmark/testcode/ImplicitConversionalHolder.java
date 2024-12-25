package org.owasp.benchmark.testcode;

public class ImplicitConversionalHolder {
    private String value;
    public static int givenIndex = 0;

    public ImplicitConversionalHolder() {
        this("");
    }

    public ImplicitConversionalHolder(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static String toString(ImplicitConversionalHolder sh) {
        return givenIndex == 42 ? sh.value : "";
    }

    public static ImplicitConversionalHolder fromString(String s) {
        return new ImplicitConversionalHolder(givenIndex == 42 ? s : "");
    }
}
