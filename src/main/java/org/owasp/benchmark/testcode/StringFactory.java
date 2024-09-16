package org.owasp.benchmark.testcode;

public class StringFactory {
    public String val;

    private StringFactory(String val) {
        this.val = val;
    }

    public static StringFactory createInstance(String value) {
        return new StringFactory(value);
    }

    public static StringFactory createInstance() {
        return new StringFactory("");
    }
}
