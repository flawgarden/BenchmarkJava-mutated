package org.owasp.benchmark.helpers.inheritance;

public class ImplementingSuperSideClass implements SuperInterface, SideInterface {
    public String superInterfaceMethod(String param) {
        return param;
    }

    public String sideInterfaceMethod(String param) {
        return param;
    }
}
