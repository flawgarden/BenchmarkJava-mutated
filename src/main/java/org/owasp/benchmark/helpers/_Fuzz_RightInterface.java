package org.owasp.benchmark.helpers;

public interface _Fuzz_RightInterface<T> {
    default T InterfaceCall(T l, T r) {
        return r;
    }
}
