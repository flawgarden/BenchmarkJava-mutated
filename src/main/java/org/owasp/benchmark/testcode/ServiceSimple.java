package org.owasp.benchmark.testcode;

import org.springframework.stereotype.Service;

@Service
public class ServiceSimple implements ServiceI {
    public ServiceSimple(String field) {
        this.field = field;
    }

    private String field;

    @Override
    public String getFieldValue() {
        return field;
    }
}
