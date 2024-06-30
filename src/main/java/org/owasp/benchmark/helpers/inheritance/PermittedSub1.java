package org.owasp.benchmark.helpers.inheritance;

public final class PermittedSub1 extends SealedSuper {
    public Object subMethod1(Object obj) {
        return obj;
    }
}
