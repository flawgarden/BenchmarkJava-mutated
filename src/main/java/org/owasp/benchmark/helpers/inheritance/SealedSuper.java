package org.owasp.benchmark.helpers.inheritance;

public sealed class SealedSuper permits PermittedSub1, PermittedSub2 {
    public Object sealedMethod(Object obj) {
        return obj;
    }
}
