package org.owasp.benchmark.testcode;

public class InterfaceConstrainedClass<T extends BinaryOpInterface> {
    private T chooser;

    public InterfaceConstrainedClass(T ch) {
        chooser = ch;
    }

    public String chooseFrom(String l, String r) {
        return chooser.InterfaceCall(l, r);
    }

    public String chooseNone(String l, String r) {
        return chooser.InterfaceCall("", "");
    }
}
