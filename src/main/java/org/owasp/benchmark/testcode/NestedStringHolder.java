package org.owasp.benchmark.testcode;

public class NestedStringHolder {
    private InnerStringHolder innerObject;

    public NestedStringHolder(String value) {
        this.innerObject = this.new InnerStringHolder(value);
    }

    public NestedStringHolder() {
        this.innerObject = this.new InnerStringHolder("");
    }

    public String getValue() {
        return innerObject.innerValue;
    }

    public class InnerStringHolder {
        public String innerValue;

        InnerStringHolder(String value) {
            this.innerValue = value;
        }
    }
}
