package org.owasp.benchmark.testcode;

public class MultipleInterfaceClass_2Neg implements UnaryOpInterface, UnaryOpInterface2 {
    @Override
    public String InterfaceCall(String s) {
        return s;
    }

    @Override
    public String Interface2Call(String s) {
        return "";
    }
}
