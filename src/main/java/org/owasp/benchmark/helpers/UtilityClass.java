package org.owasp.benchmark.helpers;

public class UtilityClass {
    public static String DEFAULT_VALUE = "EMPTY";
    public String value;

    public UtilityClass() {
        this(initialValue());
    }

    private UtilityClass(String value) {
        this.value = value;
    }

    private static String initialValue() {
        return DEFAULT_VALUE;
    }
}
