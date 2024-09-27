package org.owasp.benchmark.testcode;

public interface BinaryOpInterfaceDefault1 extends BinaryOpInterfaceDefaultBase {
    default String InterfaceCall(String l, String r) {
        return l;
    }
}
