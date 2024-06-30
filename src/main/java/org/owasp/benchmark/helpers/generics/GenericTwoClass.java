package org.owasp.benchmark.helpers.generics;

public class GenericTwoClass<T, S> {
    private Class<T> t;
    private Class<S> s;
    private T tValue;
    private S sValue;

    public GenericTwoClass(Class<T> t, Class<S> s, T tParam, S sParam) {
        this.t = t;
        this.s = s;
        this.tValue = tParam;
        this.sValue = sParam;
    }

    public Object getAndSetMagicValue(T tParam, S sParam) {
        if (s.isAssignableFrom(tParam.getClass())) {
            this.sValue = (S) tParam;
        }
        if (t.isAssignableFrom(sParam.getClass())) {
            this.tValue = (T) sParam;
        }
        if (s.isAssignableFrom(tParam.getClass())) {
            return this.tValue;
        }
        if (t.isAssignableFrom(sParam.getClass())) {
            return this.sValue;
        }
        return "";
    }
}
