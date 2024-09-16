// CodeQL original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01049.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/map.tmt
// with name map_put_if_absent_negative
// Used extensions: MACRO_VarName -> obj09823 | MACRO_VarName -> genericClass21341 |
// MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName]~ = new HashMap<>(); |
// MACRO_MapName -> map787234 | MACRO_MapName -> map787234 | MACRO_MapName -> map787234 |
// MACRO_MapName -> map787234
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-02/BenchmarkTest01049")
public class BenchmarkTest0104928 extends HttpServlet {

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
        if (request.getHeader("Referer") != null) {
            param = request.getHeader("Referer");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = new Test28().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", bar};
        response.getWriter().format("Formatted like: %1$s and %2$s.", obj);
    } // end doPost

    private class Test28 {

        SuperClass obj09823 = new SubSubClass();

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "";
            if (param != null) {
                java.util.List<String> valuesList = new java.util.ArrayList<String>();
                valuesList.add("safe");

                GenericClass<String> genericClass21341 =
                        new GenericClass<String>(bar.replaceFirst(bar, bar));

                Map<String, String> map787234 = new HashMap<>();
                map787234.put(request.changeSessionId(), "fscdy");
                map787234.putIfAbsent(request.changeSessionId(), param);
                param = map787234.get(request.changeSessionId());

                valuesList.add(param);
                valuesList.add("moresafe");

                valuesList.remove(0); // remove the 1st safe value

                bar = valuesList.get(0); // get the param value
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
