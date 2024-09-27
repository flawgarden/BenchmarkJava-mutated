package org.owasp.benchmark.testcode;

public class ArrayHolder {
    public String[] values;

    public ArrayHolder(String value) {
        this(new String[] {value, ""});
    }

    public ArrayHolder(String[] initialValues) {
        this.values = initialValues;
    }
}
