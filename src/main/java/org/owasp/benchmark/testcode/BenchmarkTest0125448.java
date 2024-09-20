// CodeQL original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79]
// Snyk analysis results: []
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01254.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/map.tmt
// with name map_remove_1_positive
// Used extensions: MACRO_VarName -> sealed09823 | MACRO_VarName -> obj09823 | MACRO_Create_Map ->
// Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName]~ = new TreeMap<>(); | MACRO_MapName -> map787234 |
// MACRO_MapName -> map787234 | MACRO_MapName -> map787234 | MACRO_MapName -> map787234
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

@WebServlet(value = "/xss-02/BenchmarkTest01254")
public class BenchmarkTest0125448 extends HttpServlet {

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

        Object sealed09823 = new SealedSuper();

        String bar = new Test48().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");

        Object obj09823 = new ImplementingSuperSideClass();

        response.getWriter().print(bar.toCharArray());
    } // end doPost

    private class Test48 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

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

            Map<String, String> map787234 = new TreeMap<>();
            map787234.put(f23874.toString(), f23874);
            if (map787234.containsKey(f23874.toString())) {
                f23874 = map787234.remove(f23874.toString());
            }

            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f23874); // reflection

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass