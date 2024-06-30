package org.owasp.benchmark.helpers;

public class LazyInitialized {
    private volatile String value;

    public String getValue(String val) {
        if (value == null) {
            synchronized (this) {
                if (value == null) {
                    value = "~[EXPR_String]~";
                }
            }
        }
        return value;
    }
}
