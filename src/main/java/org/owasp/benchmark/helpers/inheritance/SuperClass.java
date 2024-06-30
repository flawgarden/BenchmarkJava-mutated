package org.owasp.benchmark.helpers.inheritance;

public class SuperClass {
    String superField;

    public void setSuperField(String param) {
        superField = param;
    }

    public String superMethod() {
        return superField;
    }
}
