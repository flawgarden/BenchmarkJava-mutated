// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01347.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt
// with name varargs_get_string_with_index_negative
// Used extensions: MACRO_VarName -> genericClass09823 | EXPR_String ->
// ~[EXPR_String]~.replaceAll(~[MACRO_Regex]~, ~[EXPR_String]~) | MACRO_Regex -> "[abc]"
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

@WebServlet(value = "/xss-02/BenchmarkTest01347")
public class BenchmarkTest01347153 extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();

        GenericClass<Float> genericClass09823 = new GenericClass<Float>(0.33224452F);

        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest01347");
            if (values != null) param = values[0];
        }

        String bar = new Test153().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().println(bar);
    } // end doPost

    private class Test153 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence
            String a81561 = param; // assign

            a81561 = getStringWithIndex(1, a81561, param.replaceAll("[abc]", param));

            StringBuilder b81561 = new StringBuilder(a81561); // stick in stringbuilder
            b81561.append(" SafeStuff"); // append some safe content
            b81561.replace(
                    b81561.length() - "Chars".length(),
                    b81561.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map81561 = new java.util.HashMap<String, Object>();
            map81561.put("key81561", b81561.toString()); // put in a collection
            String c81561 = (String) map81561.get("key81561"); // get it back out
            String d81561 = c81561.substring(0, c81561.length() - 1); // extract most of it
            String e81561 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d81561.getBytes()))); // B64 encode and decode it
            String f81561 = e81561.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f81561); // reflection

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

        public <T153> T153 varargsWithGenerics(T153... elements) {
            return elements[0];
        }

        public String combineStrings(String... strings) {
            return String.join(", ", strings);
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
