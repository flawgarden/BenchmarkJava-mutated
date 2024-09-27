package org.owasp.benchmark.testcode;

public class NestedFieldsBase {
    public String[] values;
    public String value;

    public NestedFieldsBase(String value) {
        this.value = value;
    }

    public NestedFieldsBase(String[] initialValues) {
        this.values = initialValues;
    }

    public NestedFieldsBase(String[] initialValues, String value) {
        this.values = initialValues;
        this.value = value;
    }
}
