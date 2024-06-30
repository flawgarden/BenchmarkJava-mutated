package org.owasp.benchmark.helpers.generics;

public class SimpleGenericClass<T> {
    private T value;

    public SimpleGenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
