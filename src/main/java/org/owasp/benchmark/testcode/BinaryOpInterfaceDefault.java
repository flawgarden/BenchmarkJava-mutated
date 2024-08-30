package org.owasp.benchmark.testcode;

public interface BinaryOpInterfaceDefault
        extends BinaryOpInterfaceDefault1, BinaryOpInterfaceDefault2 {
    default String InterfaceCall(String l, String r) {
        return "";
    }
}
