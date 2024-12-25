package org.owasp.benchmark.testcode;

public class MultipleInterfaceClass_2Pos implements UnaryOpInterface, UnaryOpInterface2 {
    @Override
    public String InterfaceCall(String s) {
        return "";
    }

    @Override
    public String Interface2Call(String s) {
        return s;
    }
}
