package org.owasp.benchmark.helpers;

public class _Fuzz_ThrowException {
    public static void ThrowF() {
        try {
            throw new NullPointerException("throw");
        } catch (NullPointerException e) {
            throw e; // rethrowing the exception
        }
    }
}
