// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79]
// ApplicationInspector analysis results: [22]
// Snyk analysis results: []
// Semgrep analysis results: [22, 79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01438.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/conditional/recursion.tmt with name
// recursion_simple_negative
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

@WebServlet(value = "/xss-02/BenchmarkTest01438")
public class BenchmarkTest01438153 extends HttpServlet {

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

        Object obj12321 = new ImplementingSuperSideClass();

        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest01438")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        File f = new File(param.toUpperCase());

        String bar = new Test153().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().write("Parameter value: " + bar);
    } // end doPost

    private class Test153 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence
            String a32762 = param; // assign
            StringBuilder b32762 = new StringBuilder(a32762); // stick in stringbuilder
            b32762.append(" SafeStuff"); // append some safe content
            b32762.replace(
                    b32762.length() - "Chars".length(),
                    b32762.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map32762 = new java.util.HashMap<String, Object>();
            map32762.put("key32762", b32762.toString()); // put in a collection
            String c32762 = (String) map32762.get("key32762"); // get it back out
            String d32762 = c32762.substring(0, c32762.length() - 1); // extract most of it
            String e32762 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d32762.getBytes()))); // B64 encode and decode it

            e32762 = paramOrEmpty(-1, e32762);

            String f32762 = e32762.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f32762); // reflection

            return bar;
        }

        public String paramOrEmpty(int value, String param) {
            if (param.length() == value) {
                return param;
            } else if (value > param.length()) {
                paramOrEmpty(--value, param);
            } else {
                return "";
            }
            return "";
        }

        public String paramOrEmptyMutual1(int value, String param) {
            if (param.length() == value) {
                return param;
            } else if (value > param.length()) {
                paramOrEmptyMutual2(value, param);
            } else {
                return "";
            }
            return "";
        }

        public String paramOrEmptyMutual2(int value, String param) {
            return paramOrEmptyMutual1(--value, param);
        }
    } // end innerclass Test
} // end DataflowThruInnerClass