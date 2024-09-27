package org.owasp.benchmark.testcode;

public class ServiceConst implements ServiceI {
    public ServiceConst(String field) {
        this.field = field;
    }

    private String field;

    @Override
    public String getFieldValue() {
        return "123";
    }
}
