package org.owasp.benchmark.testcode;

public class StaticFieldHolder {
    public static String DEFAULT_VALUE = "";
    public String value;

    public StaticFieldHolder() {
        this(DEFAULT_VALUE);
    }

    private StaticFieldHolder(String value) {
        this.value = value;
    }
}
