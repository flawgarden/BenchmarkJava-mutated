/**
 * OWASP Benchmark Project v1.2
 *
 * <p>This file is part of the Open Web Application Security Project (OWASP) Benchmark Project. For
 * details, please see <a
 * href="https://owasp.org/www-project-benchmark/">https://owasp.org/www-project-benchmark/</a>.
 *
 * <p>The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation, version 2.
 *
 * <p>The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details.
 *
 * @author Dave Wichers
 * @created 2015
 */
package org.owasp.benchmark.testcode;

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-03/BenchmarkTest01584")
public class BenchmarkTest0158465 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Object obj21341 = new ImplementingSuperClass();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object sealed12321 = new PermittedSub1();

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        File f = new File(request.getQueryString());

        String[] values = request.getParameterValues("BenchmarkTest01584");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = new Test65().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", "b"};
        response.getWriter().format(java.util.Locale.US, bar, obj);
    } // end doPost

    private class Test65 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar;

            // Simple if statement that assigns param to bar on true condition
            int num = 196;
            if ((500 / 42) + num > 200) bar = param;

            AtomicInteger counter = new AtomicInteger(0);

            Thread thread1 = new Thread(() -> counter.incrementAndGet());

            thread1.start();

            Thread thread2 = new Thread(() -> counter.incrementAndGet());

            thread2.start();

            try {
                thread1.join();
            } catch (InterruptedException e) {
            }

            try {
                thread2.join();
            } catch (InterruptedException e) {
            }

            if (counter.get() == 2) {
                bar = "";
            } else bar = "This should never happen";

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
