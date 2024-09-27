package org.owasp.benchmark.testcode;

public class ConsumerSimple {

    private final ServiceSimple service;

    public ConsumerSimple(ServiceSimple service) {
        this.service = service;
    }

    public String getFieldValue() {
        return service.getFieldValue();
    }
}
