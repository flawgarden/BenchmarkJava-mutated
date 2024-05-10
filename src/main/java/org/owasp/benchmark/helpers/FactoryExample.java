package org.owasp.benchmark.helpers;

public class FactoryExample {
    public String val;

    private FactoryExample(String val) {
        if (val.contains("USERS")) {
            this.val = val;
        } else {
            this.val = "EMPTY";
        }
    }

    public static FactoryExample createInstance(String value) {
        return new FactoryExample(value);
    }
}
