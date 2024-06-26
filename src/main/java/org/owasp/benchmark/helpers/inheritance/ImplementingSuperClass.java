package org.owasp.benchmark.helpers.inheritance;

public class ImplementingSuperClass implements SuperInterface {
    public String superInterfaceMethod(String param) {
        return param;
    }
}
