package org.owasp.benchmark.helpers.generics;

public class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public T getMagicValue(T value) {
        if (value instanceof String str) {
            return (T) str;
        } else {
            return this.value;
        }
    }
}
