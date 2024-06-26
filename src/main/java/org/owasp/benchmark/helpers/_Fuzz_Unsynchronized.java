package org.owasp.benchmark.helpers;

import java.util.concurrent.*;

public class _Fuzz_Unsynchronized<T> {
    T a;
    T b;

    public void SetA(T value) {
        a = value;
    }

    public T GetA() {
        return a;
    }

    public void SetB(T value) {
        b = value;
    }

    public T GetB() {
        return b;
    }
}
