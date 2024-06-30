// CodeQL original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// CodeQL analysis results: [79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest00729.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/collections/set.tmt with index 0
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

@WebServlet(value = "/xss-01/BenchmarkTest00729")
public class BenchmarkTest00729509 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00729");
        String param = "";
        if (values != null && values.length > 0) param = values[0];
        Set<Integer> a12341 = new HashSet<Integer>();
        a12341.addAll(Arrays.asList(new Integer[] {1, 3, 1}));
        if (a12341.size() == 2) {
            param = param;
        } else param = "";

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().write(bar.toCharArray());
    }
}
