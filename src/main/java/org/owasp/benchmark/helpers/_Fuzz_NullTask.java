package org.owasp.benchmark.helpers;

public class _Fuzz_NullTask<T> implements Runnable {
    public _Fuzz_NullTask(_Fuzz_Wrapper<T> t) {
        wrapper = t;
    }

    _Fuzz_Wrapper<T> wrapper;

    @Override
    public void run() {
        wrapper.i = null;
    }
}
