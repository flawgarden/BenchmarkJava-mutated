package org.owasp.benchmark.helpers;

import java.util.*;

public class CollectionHolder {
    public List<String> list;

    public CollectionHolder(String value) {
        this(Arrays.asList(value, "EMPTY"));
    }

    private CollectionHolder(List<String> initialList) {
        this.list = new ArrayList<>(initialList);
    }
}
