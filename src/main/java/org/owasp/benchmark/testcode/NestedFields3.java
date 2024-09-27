package org.owasp.benchmark.testcode;

public class NestedFields3 {
    public String value;
    public String[] values;
    public NestedFields2 nested1;

    public NestedFields3(String value) {
        this.value = value;
        nested1 = new NestedFields2(value);
    }

    public NestedFields3(String[] initialValues) {
        this.values = initialValues;
        nested1 = new NestedFields2(initialValues);
    }

    public NestedFields3(String[] initialValues, String value) {
        this.values = initialValues;
        this.value = value;
        nested1 = new NestedFields2(initialValues, value);
    }
}
