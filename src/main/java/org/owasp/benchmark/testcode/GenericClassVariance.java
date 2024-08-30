package org.owasp.benchmark.testcode;

public class GenericClassVariance {
    public static boolean extendsVariance(GenericClass<? extends A> genericClassObj) {
        return genericClassObj.getObjectValue() instanceof B;
    }

    public static boolean superVariance(GenericClass<? super C> genericClassObj) {
        return genericClassObj.getObjectValue() instanceof B;
    }

    public static boolean wildcardVariance(GenericClass<?> genericClassObj) {
        return genericClassObj.getObjectValue() instanceof B;
    }
}
