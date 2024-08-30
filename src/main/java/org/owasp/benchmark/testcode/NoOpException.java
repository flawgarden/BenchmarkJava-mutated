package org.owasp.benchmark.testcode;

public class NoOpException extends Exception {
    public NoOpException(String errorMessage) {
        super(errorMessage);
    }
}
