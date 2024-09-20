// CodeQL original results: [501]
// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79, 501]
// ApplicationInspector analysis results: [79, 501]
// Snyk analysis results: []
// Semgrep analysis results: [501, 79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01709.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/if.tmt
// with name if_else_operator_neutral
// Used extensions: MACRO_VarName -> obj39745 | MACRO_Create_Set -> Set<~[TYPE@1]~>
// ~[MACRO_SetName@1]~ = new TreeSet<>(); | MACRO_Add_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Add_Fixed_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[EXPR_~[TYPE@1]~@1]~); | MACRO_SetName@1 -> set787231
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

@WebServlet(value = "/trustbound-01/BenchmarkTest01709")
public class BenchmarkTest0170987 extends HttpServlet {

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

        Object obj39745 = new ImplementingSuperClass();

        String queryString = request.getQueryString();
        String paramval = "BenchmarkTest01709" + "=";
        int paramLoc = -1;
        if (queryString != null) paramLoc = queryString.indexOf(paramval);
        if (paramLoc == -1) {
            response.getWriter()
                    .println(
                            "getQueryString() couldn't find expected parameter '"
                                    + "BenchmarkTest01709"
                                    + "' in query string.");
            return;
        }

        String param =
                queryString.substring(
                        paramLoc
                                + paramval
                                        .length()); // 1st assume "BenchmarkTest01709" param is last
        // parameter in query string.
        // And then check to see if its in the middle of the query string and if so, trim off what
        // comes after.
        int ampersandLoc = queryString.indexOf("&", paramLoc);
        if (ampersandLoc != -1) {
            param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
        }
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = new Test87().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test87 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence
            String a15574 = param; // assign

            Set<String> set787231 = new TreeSet<>();
            set787231.add(a15574);
            set787231.add(param);
            String value7844 = "cgqil";

            if (set787231.contains(param)) {
                value7844 = param;
            }

            StringBuilder b15574 = new StringBuilder(a15574); // stick in stringbuilder

            String tmpUnique42 = a15574;
            b15574.append(" SafeStuff"); // append some safe content
            b15574.replace(
                    b15574.length() - "Chars".length(),
                    b15574.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map15574 = new java.util.HashMap<String, Object>();
            map15574.put("key15574", b15574.toString()); // put in a collection
            String c15574 = (String) map15574.get("key15574"); // get it back out
            String d15574 = c15574.substring(0, c15574.length() - 1); // extract most of it

            if (0.34487414F <= 0.089354865F) {
                a15574 = tmpUnique42;
            } else {
                a15574 = "";
            }

            String e15574 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d15574.getBytes()))); // B64 encode and decode it
            String f15574 = e15574.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f15574); // reflection

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass