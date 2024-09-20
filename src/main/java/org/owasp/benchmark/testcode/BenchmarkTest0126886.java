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
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01268.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt
// with name varargs_get_string_with_index_positive
// Used extensions: MACRO_VarName -> obj39745
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

@WebServlet(value = "/xss-02/BenchmarkTest01268")
public class BenchmarkTest0126886 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest01268");
        if (param == null) param = "";

        String bar = new Test86().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        int length = 1;
        if (bar != null) {
            length = bar.length();
            response.getWriter().write(bar, 0, length);
        }
    } // end doPost

    private class Test86 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence

            SuperClass obj39745 = new SubSubClass();

            String a92384 = param; // assign
            StringBuilder b92384 = new StringBuilder(a92384); // stick in stringbuilder
            b92384.append(" SafeStuff"); // append some safe content
            b92384.replace(
                    b92384.length() - "Chars".length(),
                    b92384.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map92384 = new java.util.HashMap<String, Object>();
            map92384.put("key92384", b92384.toString()); // put in a collection
            String c92384 = (String) map92384.get("key92384"); // get it back out
            String d92384 = c92384.substring(0, c92384.length() - 1); // extract most of it
            String e92384 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d92384.getBytes()))); // B64 encode and decode it
            String f92384 = e92384.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();

            f92384 = getStringWithIndex(0, f92384, thing.doSomething(c92384));

            String bar = thing.doSomething(f92384); // reflection

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

        public <T86> T86 varargsWithGenerics(T86... elements) {
            return elements[0];
        }

        public String combineStrings(String... strings) {
            return String.join(", ", strings);
        }
    } // end innerclass Test
} // end DataflowThruInnerClass