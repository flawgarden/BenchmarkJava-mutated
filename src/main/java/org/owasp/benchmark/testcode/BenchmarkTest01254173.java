// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79]
// ApplicationInspector analysis results: [79, 22]
// Snyk analysis results: []
// Semgrep analysis results: [79, 22]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01254.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt
// with name varargs_with_generics_positive
// Used extensions: MACRO_VarName -> obj12321
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-02/BenchmarkTest01254")
public class BenchmarkTest01254173 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest01254");
        if (param == null) param = "";

        String bar = new Test173().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().print(bar.toCharArray());
    } // end doPost

    private class Test173 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            param = varargsWithGenerics(param, param.toUpperCase());

            // Chain a bunch of propagators in sequence
            String a23874 = param; // assign
            StringBuilder b23874 = new StringBuilder(a23874); // stick in stringbuilder
            b23874.append(" SafeStuff"); // append some safe content
            b23874.replace(
                    b23874.length() - "Chars".length(),
                    b23874.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map23874 = new java.util.HashMap<String, Object>();
            map23874.put("key23874", b23874.toString()); // put in a collection
            String c23874 = (String) map23874.get("key23874"); // get it back out
            String d23874 = c23874.substring(0, c23874.length() - 1); // extract most of it
            String e23874 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d23874.getBytes()))); // B64 encode and decode it
            String f23874 = e23874.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();

            File f = new File(request.getRequestedSessionId());

            Object obj12321 = new ImplementingSubClass();

            String bar = thing.doSomething(f23874); // reflection

            return bar;
        }

        public String getFirstString(String... lines) {
            return getStringWithIndex(0, lines);
        }

        public String getStringWithIndex(int ind, String... lines) {
            return lines[ind];
        }

        public String getFirstStringFromArray(String... lines) {
            return Arrays.asList(lines).get(0);
        }

        public <T173> T173 varargsWithGenerics(T173... elements) {
            return elements[0];
        }

        public String combineStrings(String... strings) {
            return String.join(", ", strings);
        }
    } // end innerclass Test
} // end DataflowThruInnerClass