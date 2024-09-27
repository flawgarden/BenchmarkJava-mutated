package org.owasp.benchmark.testcode;

public class NestedFields1 {
    public String value;
    public String[] values;
    public NestedFieldsBase nested1;

    public NestedFields1(String value) {
        this.value = value;
        nested1 = new NestedFieldsBase(value);
    }

    public NestedFields1(String[] initialValues) {
        this.values = initialValues;
        nested1 = new NestedFieldsBase(initialValues);
    }

    public NestedFields1(String[] initialValues, String value) {
        this.values = initialValues;
        this.value = value;
        nested1 = new NestedFieldsBase(initialValues, value);
    }
}
