package org.owasp.benchmark.helpers;

public class _Fuzz_C_DoubleImplements<T> implements _Fuzz_C_Interface<T>, _Fuzz_C_InterfaceA<T> {
    @Override
    public T InterfaceCall(T l, T r) {
        return l;
    }

    @Override
    public T InterfaceACall(T t) {
        return t;
    }
}
