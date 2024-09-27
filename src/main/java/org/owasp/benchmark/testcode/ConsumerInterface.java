package org.owasp.benchmark.testcode;

public class ConsumerInterface {

    private final ServiceI service;

    public ConsumerInterface(ServiceI service) {
        this.service = service;
    }

    public String getFieldValue() {
        return service.getFieldValue();
    }
}
