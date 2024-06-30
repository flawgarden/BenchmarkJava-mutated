package org.owasp.benchmark.helpers;

import java.util.concurrent.*;

public class _Fuzz_Synchronized<T> {
    T a;
    T b;

    public synchronized void SetA(T value) {
        a = value;
    }

    public synchronized T GetA() {
        return a;
    }

    public synchronized void SetB(T value) {
        b = value;
    }

    public synchronized T GetB() {
        return b;
    }
}
