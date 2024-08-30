package org.owasp.benchmark.testcode;

public class SettingTask implements Runnable {
    private Wrapper<String> w;
    private String s;

    public SettingTask(Wrapper<String> w, String s) {
        this.w = w;
        this.s = s;
    }

    @Override
    public void run() {
        this.w.i = s;
    }
}
