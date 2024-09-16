// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79]
// ApplicationInspector analysis results: [79]
// Snyk analysis results: []
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01261.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt
// with name varargs_get_first_string_from_array_positive
// Used extensions: MACRO_VarName -> obj12321 | MACRO_VarName -> sealed21341
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

@WebServlet(value = "/xss-02/BenchmarkTest01261")
public class BenchmarkTest01261141 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest01261");
        if (param == null) param = "";

        String bar = new Test141().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().println(bar.toCharArray());

        SimpleRecord recordEmpty = new SimpleRecord("");
    } // end doPost

    private class Test141 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence

            SuperClass obj12321 = new SiblingClass();

            String a34194 = param; // assign
            StringBuilder b34194 = new StringBuilder(a34194); // stick in stringbuilder
            b34194.append(" SafeStuff"); // append some safe content
            b34194.replace(
                    b34194.length() - "Chars".length(),
                    b34194.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map34194 = new java.util.HashMap<String, Object>();
            map34194.put("key34194", b34194.toString()); // put in a collection
            String c34194 = (String) map34194.get("key34194"); // get it back out

            Object sealed21341 = new PermittedSub1();

            String d34194 = c34194.substring(0, c34194.length() - 1); // extract most of it
            String e34194 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d34194.getBytes()))); // B64 encode and decode it
            String f34194 = e34194.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f34194); // reflection

            bar = getFirstStringFromArray(bar, bar);

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

        public <T141> T141 varargsWithGenerics(T141... elements) {
            return elements[0];
        }

        public String combineStrings(String... strings) {
            return String.join(", ", strings);
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
