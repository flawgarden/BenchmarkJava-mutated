// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Semgrep original results: [79]
// Snyk original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [685, 391, 561, 79, 134]
// ApplicationInspector analysis results: []
// Snyk analysis results: [79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00547.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt
// with name two_queues_positive
// Used extensions: MACRO_VarName -> obj12321 | EXPR_String -> "" | EXPR_String ->
// ~[EXPR_String]~.toString()
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-01/BenchmarkTest00547")
public class BenchmarkTest0054792 extends HttpServlet {

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

        String param = "";
        boolean flag = true;
        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);

            Object obj12321 = new ImplementingSuperClass();

            if (values != null) {

                Queue<String> sourceQueue = new ArrayDeque<>();
                Queue<String> targetQueue = new ArrayDeque<>();
                sourceQueue.add("");
                sourceQueue.add(param);
                targetQueue.add(name);
                targetQueue.add(obj12321.toString().toString());
                while (!sourceQueue.isEmpty()) {
                    targetQueue.offer(sourceQueue.poll());
                }
                name = targetQueue.poll();

                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];

                    File f = new File(param.intern());

                    if (value.equals("BenchmarkTest00547")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        String bar = "";
        if (param != null) bar = param.split(" ")[0];

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", "b"};
        response.getWriter().printf(java.util.Locale.US, bar, obj);
    }
}
