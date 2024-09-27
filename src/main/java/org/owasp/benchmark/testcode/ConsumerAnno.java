package org.owasp.benchmark.testcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerAnno {

    private final ServiceI service;

    @Autowired
    public ConsumerAnno(ServiceI service) {
        this.service = service;
    }

    public String getFieldValue() {
        return service.getFieldValue();
    }
}
