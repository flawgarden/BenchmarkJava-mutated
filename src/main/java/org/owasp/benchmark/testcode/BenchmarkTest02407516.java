// CodeQL original results: [79]
// Insider original results: []
// Semgrep original results: []
// CodeQL analysis results: [79, 730, 400]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest02407.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/collections/map.tmt with index 10
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-04/BenchmarkTest02407516")
public class BenchmarkTest02407516 extends HttpServlet {

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
        String param = scr.getTheParameter("BenchmarkTest02407");
        if (param == null) param = "";

        String bar = doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().println(bar);
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = param;
        if (param != null && param.length() > 1) {
            StringBuilder sbxyz58438 = new StringBuilder(param);
            bar = sbxyz58438.replace(param.length() - "Z".length(), param.length(), "Z").toString();
            Map<String, String> map10 = new HashMap<>();
            map10.put(request.getRequestedSessionId(), bar.replaceFirst(param, bar));
            int size10 = map10.size();
            if (size10 > 0) {
                bar = bar.intern();
            }
        }

        return bar;
    }
}
