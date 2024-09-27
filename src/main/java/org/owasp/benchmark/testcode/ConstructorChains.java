package org.owasp.benchmark.testcode;

public class ConstructorChains {

    private final boolean condition;
    private final String text;

    public ConstructorChains() {
        this(true, "");
    }

    public ConstructorChains(String text) {
        this(true, text);
    }

    public ConstructorChains(boolean condition, String text) {
        this.condition = condition;
        if (condition) {
            this.text = text;
        } else {
            this.text = "";
        }
    }

    public String getText(boolean condition) {
        if (this.condition || condition) {
            return text;
        } else {
            return "";
        }
    }
}
