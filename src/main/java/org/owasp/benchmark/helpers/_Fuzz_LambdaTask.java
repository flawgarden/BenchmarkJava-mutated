package org.owasp.benchmark.helpers;

import java.util.concurrent.*;

public class _Fuzz_LambdaTask<T> implements Runnable {
    public _Fuzz_LambdaTask(_Fuzz_Wrapper<T> t, _Fuzz_WrapperLambda<T> l) {
        wrapper = t;
        lambda = l;
    }

    _Fuzz_Wrapper<T> wrapper;
    _Fuzz_WrapperLambda<T> lambda;

    @Override
    public void run() {
        lambda.Mutate(wrapper);
    }
}
