package org.owasp.benchmark.helpers;

public class DerivedClass extends BaseClass {
    public DerivedClass() {
        super("EMPTY");
        this.baseValue += "DerivedClass";
    }

    public DerivedClass(String value) {
        super(value);
        this.baseValue += "FROM";
    }
}
