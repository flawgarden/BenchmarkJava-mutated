package org.owasp.benchmark.helpers;

public interface _Fuzz_LeftInterface<T> {
    default T InterfaceCall(T l, T r) {
        return l;
    }
}
