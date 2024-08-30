package org.owasp.benchmark.testcode;

public class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public Object getObjectValue() {
        return value;
    }

    public T getValue() {
        return value;
    }
}
