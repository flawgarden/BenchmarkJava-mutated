package org.owasp.benchmark.testcode;

public class NewConstrainedClass<T> {
    private T instance;

    public NewConstrainedClass() {
        try {
            instance = (T) Class.forName("HelperGenerics." + T.getClass().getSimpleName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T getInstance() {
        return instance;
    }
}

