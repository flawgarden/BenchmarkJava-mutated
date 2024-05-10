package org.owasp.benchmark.helpers;

import java.util.ArrayList;
import java.util.List;

public class InstanceInitializer {

    public static String value;

    private List<String> list;

    {
        list = new ArrayList<>();
        list.add(value);
    }

    public String getValue() {
        return list.get(0);
    }

    public InstanceInitializer() {}
}
