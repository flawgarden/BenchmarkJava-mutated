// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00644.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/concurrency/concurrency.tmt with name
// atomic_integer_negative
// Used extensions: MACRO_Regex -> (~[MACRO_Regex]~ + "+") | MACRO_Regex -> "\f" | MACRO_VarName ->
// obj12321 | MACRO_VarName -> sealed12321
// Program:
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
 * @author Nick Sanidas
 * @created 2015
 */
package org.owasp.benchmark.testcode;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-01/BenchmarkTest00644")
public class BenchmarkTest00644133 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest00644");
        if (param == null) param = "";

        Object obj12321 = new ImplementingSuperClass();

        String bar = "";
        if (param != null) bar = param.split(" ")[0];

        Object sealed12321 = new PermittedSub1();

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
            param = "";
        }

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().print(bar);

        Pattern pattern = Pattern.compile(("\f" + "+"));
        Matcher matcher = pattern.matcher(response.encodeURL(param));
    }
}
