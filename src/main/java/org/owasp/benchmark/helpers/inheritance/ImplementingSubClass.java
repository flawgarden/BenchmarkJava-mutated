package org.owasp.benchmark.helpers.inheritance;

public class ImplementingSubClass implements SubInterface {
    public String superInterfaceMethod(String param) {
        return param;
    }

    public String subInterfaceMethod(String param) {
        return param;
    }
}
