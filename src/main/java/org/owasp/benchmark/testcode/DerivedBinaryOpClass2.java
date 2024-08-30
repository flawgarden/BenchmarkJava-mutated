package org.owasp.benchmark.testcode;

public class DerivedBinaryOpClass2 extends BaseBinaryOpClass {
    @Override
    public String VirtualCall(String l, String r) {
        return r;
    }
}
