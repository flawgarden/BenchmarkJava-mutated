package org.owasp.benchmark.testcode;

public class GenericTwoClass {
    public static <T, S> boolean tIsAssignableFromS(Class<T> t, S sParam) {
        return t.isAssignableFrom(sParam.getClass());
    }

    public static <T, S> boolean sIsAssignableFromT(Class<S> s, T tParam) {
        return s.isAssignableFrom(tParam.getClass());
    }

    public static <T, S> boolean tIsAssignableFromT(Class<T> t, T tParam) {
        return t.isAssignableFrom(tParam.getClass());
    }

    public static <T, S> boolean sIsAssignableFromS(Class<T> t, S sParam) {
        return t.isAssignableFrom(sParam.getClass());
    }
}
