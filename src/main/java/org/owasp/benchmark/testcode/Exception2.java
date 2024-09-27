package org.owasp.benchmark.testcode;

public class Exception2 extends Exception {
    public Exception2(String errorMessage) {
        super(errorMessage);
        errorMessage = "";
    }
}
