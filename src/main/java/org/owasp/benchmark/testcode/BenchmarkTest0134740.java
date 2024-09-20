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
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01347.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/assignment.tmt with
// name assignment_negative
// Used extensions: MACRO_Regex -> (~[MACRO_Regex]~ + "*") | EXPR_String ->
// ~[EXPR_String]~.toLowerCase() | MACRO_Regex -> "\f" | MACRO_Create_Set -> Set<~[TYPE@1]~>
// ~[MACRO_SetName@1]~ = new HashSet<>(); | MACRO_Add_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Add_Fixed_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[EXPR_~[TYPE@1]~@1]~); | MACRO_SetName@1 -> set787232 | MACRO_Create_Set
// -> Set<~[TYPE@1]~> ~[MACRO_SetName@1]~ = new HashSet<>(); | MACRO_Add_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Add_Fixed_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[EXPR_~[TYPE@1]~@1]~); | MACRO_SetName@1 -> set787233
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-02/BenchmarkTest01347")
public class BenchmarkTest0134740 extends HttpServlet {

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

        Pattern pattern = Pattern.compile(("\f" + "*"));
        Matcher matcher = pattern.matcher(request.getRequestedSessionId().toLowerCase());

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest01347");
            if (values != null) param = values[0];
        }

        String bar = new Test40().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().println(bar);
    } // end doPost

    private class Test40 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence

            Set<String> set787232 = new HashSet<>();
            set787232.add(param);

            Set<String> set787233 = new HashSet<>();
            set787233.add(param);
            set787233.add(param.toString());

            String tmpUnique42 = "";
            set787233.remove(param);
            String value7843 = set787233.iterator().next();

            set787232.add(param);
            String value7846 = "sdloz";

            if (set787232.size() == 2) {
                value7846 = set787232.iterator().next();
            }

            String a81561 = param; // assign
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

            param = tmpUnique42;

            String f81561 = e81561.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f81561); // reflection

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass