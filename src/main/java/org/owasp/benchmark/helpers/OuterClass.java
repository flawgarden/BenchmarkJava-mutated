package org.owasp.benchmark.helpers;

public class OuterClass {
    private InnerClass innerObject;
    private String value;

    public OuterClass(String value) {
        this.innerObject = this.new InnerClass(value);
    }

    public InnerClass getInnerObject() {
        return innerObject;
    }

    public class InnerClass {
        public String innerValue;

        InnerClass(String value) {
            this.innerValue = value;
        }
    }
}
