package org.owasp.benchmark.helpers.generics;

public class SomeGenericClass<T> {
    private T value;

    public SomeGenericClass(T value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
