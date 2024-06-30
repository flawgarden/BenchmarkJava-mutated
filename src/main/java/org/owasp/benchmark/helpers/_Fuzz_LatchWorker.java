package org.owasp.benchmark.helpers;

import java.util.List;
import java.util.concurrent.*;

public class _Fuzz_LatchWorker<T> implements Runnable {
    private List<T> outputScraper;
    T element;
    private CountDownLatch countDownLatch;

    public _Fuzz_LatchWorker(List<T> outputScraper, CountDownLatch countDownLatch, T element) {
        this.outputScraper = outputScraper;
        this.element = element;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        outputScraper.add(element);
        countDownLatch.countDown();
    }
}
