package org.owasp.benchmark.testcode;

public class NestedFields4 {
    public String value;
    public String[] values;
    public NestedFields3 nested1;

    public NestedFields4(String value) {
        this.value = value;
        nested1 = new NestedFields3(value);
    }

    public NestedFields4(String[] initialValues) {
        this.values = initialValues;
        nested1 = new NestedFields3(initialValues);
    }

    public NestedFields4(String[] initialValues, String value) {
        this.values = initialValues;
        this.value = value;
        nested1 = new NestedFields3(initialValues, value);
    }
}
