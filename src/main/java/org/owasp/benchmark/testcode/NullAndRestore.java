package org.owasp.benchmark.testcode;

import java.util.concurrent.locks.*;

public class NullAndRestore {
    private String s;
    private String original;

    public NullAndRestore(String s) {
        this.s = s;
        this.original = s;
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition setToNull = lock.newCondition();

    public void nullMethod() {
        lock.lock();
        this.s = null;
        setToNull.signalAll();
        lock.unlock();
    }

    public void restore() {
        lock.lock();
        while (this.s != null) {
            try {
                setToNull.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.s = this.original;
        lock.unlock();
    }

    public String get() {
        String ret = null;
        lock.lock();
        ret = this.s;
        lock.unlock();
        return ret;
    }
}
