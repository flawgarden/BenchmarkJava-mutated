package org.owasp.benchmark.helpers;

public class ModeSelector {
    private Mode mode;

    public ModeSelector() {
        this(Mode.DEFAULT);
    }

    public ModeSelector(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }
}
