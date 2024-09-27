package org.owasp.benchmark.testcode;

public interface BinaryOpInterfaceDefault2 extends BinaryOpInterfaceDefaultBase {
    default String InterfaceCall(String l, String r) {
        return r;
    }
}
