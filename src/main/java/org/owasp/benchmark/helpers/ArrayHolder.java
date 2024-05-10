package org.owasp.benchmark.helpers;

public class ArrayHolder {
    private String[] values;

    public ArrayHolder(String value) {
        this(new String[] {value, "A", "B"}); // Dynamic initialization
    }

    public ArrayHolder(String[] initialValues) {
        this.values = initialValues;
    }

    public String[] getValues() {
        return values;
    }
}
