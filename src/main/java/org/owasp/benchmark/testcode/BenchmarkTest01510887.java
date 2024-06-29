// CodeQL original results: [79]
// Insider original results: []
// Semgrep original results: []
// CodeQL analysis results: [561, 79]
// Semgrep analysis results: [200]
// Insider analysis results: []
// Original file name: BenchmarkTest01510.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/collections/streams.tmt with index 10
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
 * @author Dave Wichers
 * @created 2015
 */
package org.owasp.benchmark.testcode;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-03/BenchmarkTest01510887")
public class BenchmarkTest01510887 extends HttpServlet {

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
        String param = scr.getTheParameter("BenchmarkTest01510");
        if (param == null) param = "";

        String bar = new Test887().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {bar, "b"};
        List<String> list787234 = new ArrayList<String>();
        list787234.add(response.encodeRedirectUrl(bar));
        list787234.add("");
        boolean noneMatch = list787234.stream().noneMatch(e -> e.length() > 10);
        if (noneMatch) {
            bar = param;
        }
        response.getWriter().printf("Formatted like: %1$s and %2$s.", obj);
    } // end doPost

    private class Test887 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(param);

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
