package org.owasp.benchmark.helpers;

public class _Fuzz_C_ExtendsImplements<T> extends _Fuzz_C_BaseClass<T>
        implements _Fuzz_C_Interface<T> {
    @Override
    public T ClassCall(T l, T r) {
        return l;
    }

    @Override
    public T InterfaceCall(T l, T r) {
        return r;
    }
}
