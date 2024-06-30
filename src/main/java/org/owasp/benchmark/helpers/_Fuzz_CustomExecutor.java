package org.owasp.benchmark.helpers;

import java.util.concurrent.*;

public class _Fuzz_CustomExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}
