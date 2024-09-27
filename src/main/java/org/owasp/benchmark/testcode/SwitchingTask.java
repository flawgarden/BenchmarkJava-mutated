package org.owasp.benchmark.testcode;

public class SwitchingTask implements Runnable {
    private Wrapper<String> w;
    private String s;

    public SwitchingTask(Wrapper<String> w, String s) {
        this.w = w;
        this.s = s;
    }

    @Override
    public void run() {
        synchronized (this.w) {
            if (this.w.i == "") {
                this.w.i = s;
            } else {
                this.w.i = "";
            }
        }
    }
}
