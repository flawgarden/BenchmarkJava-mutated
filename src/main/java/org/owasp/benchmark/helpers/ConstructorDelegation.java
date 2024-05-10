package org.owasp.benchmark.helpers;

public class ConstructorDelegation {
    private String a, b, c;

    public ConstructorDelegation(String value) {
        this(value, " ADD "); // Default values
    }

    private ConstructorDelegation(String a, String b) {
        this(a, b, a + b); // Calculate c based on a and b
    }

    private ConstructorDelegation(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getC() {
        return c;
    }
}
