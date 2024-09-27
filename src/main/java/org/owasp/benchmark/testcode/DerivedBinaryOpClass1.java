package org.owasp.benchmark.testcode;

public class DerivedBinaryOpClass1 extends BaseBinaryOpClass {
    @Override
    public String VirtualCall(String l, String r) {
        return l;
    }
}
