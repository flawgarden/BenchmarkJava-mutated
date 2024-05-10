package org.owasp.benchmark.helpers;

import java.util.Optional;

public class OptionalHolder {
    private Optional<String> optionalValue;

    public OptionalHolder(String value) {
        this(Optional.ofNullable(value));
    }

    private OptionalHolder(Optional<String> value) {
        this.optionalValue = value;
    }

    public String getOptionalValue() {
        return optionalValue.orElse("EMPTY");
    }
}
