package org.owasp.benchmark.testcode;

public class NestedFields2 {
    public String value;
    public String[] values;
    public NestedFields1 nested1;

    public NestedFields2(String value) {
        this.value = value;
        nested1 = new NestedFields1(value);
    }

    public NestedFields2(String[] initialValues) {
        this.values = initialValues;
        nested1 = new NestedFields1(initialValues);
    }

    public NestedFields2(String[] initialValues, String value) {
        this.values = initialValues;
        this.value = value;
        nested1 = new NestedFields1(initialValues, value);
    }
}
