package org.owasp.benchmark.testcode;


public class InheritanceConstrainedClass<T extends V, V extends BaseBinaryOpClass> {
    private T chooser;

    public InheritanceConstrainedClass(T ch) {
        chooser = ch;
    }

    public String chooseFrom(String l, String r) {
        return chooser.VirtualCall(l, r);
    }

    public String chooseNone(String l, String r) {
        return chooser.VirtualCall("", "");
    }
}
