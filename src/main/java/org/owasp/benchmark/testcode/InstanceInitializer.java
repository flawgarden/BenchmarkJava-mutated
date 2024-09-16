package org.owasp.benchmark.testcode;

import java.util.ArrayList;
import java.util.List;

public class InstanceInitializer {
    public String value;

    public List<String> list;

    {
        value = "";
        list = new ArrayList<>();
        list.add(value);
    }

    public InstanceInitializer(String value) {
        this.value = value;
        list.add(value);
    }
}
