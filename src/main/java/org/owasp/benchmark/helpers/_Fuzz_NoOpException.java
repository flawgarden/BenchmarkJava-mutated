package org.owasp.benchmark.helpers;

// Distinct from all other exceptions
public class _Fuzz_NoOpException extends Exception {
    public _Fuzz_NoOpException(String errorMessage) {
        super(errorMessage);
    }
}
