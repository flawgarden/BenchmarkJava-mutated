// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// -------------
// ApplicationInspector analysis results: [79, 501]
// Snyk analysis results: []
// Semgrep analysis results: [501, 79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01616.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/field/constructors.tmt with name
// class_with_nested_string_initialization_negative
// Used extensions: MACRO_VarName -> obj21341 | MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~>
// ~[MACRO_MapName@1]~ = new TreeMap<>(); | MACRO_Add_Element_ToMap ->
// ~[MACRO_MapName@1]~.put(~[VAR_~[TYPE@1]~]~, ~[VAR_~[TYPE@2]~]~); | MACRO_MapName@1 -> map787234 |
// MACRO_VarName -> sealed09823
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

@WebServlet(value = "/trustbound-00/BenchmarkTest01616")
public class BenchmarkTest0161692 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest01616");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = new Test92().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test92 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence
            String a53857 = param; // assign
            StringBuilder b53857 = new StringBuilder(a53857); // stick in stringbuilder
            b53857.append(" SafeStuff"); // append some safe content

            Object sealed09823 = new SealedSuper();

            b53857.replace(
                    b53857.length() - "Chars".length(),
                    b53857.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map53857 = new java.util.HashMap<String, Object>();
            map53857.put("key53857", b53857.toString()); // put in a collection
            String c53857 = (String) map53857.get("key53857"); // get it back out

            SuperClass obj21341 = new SubClass();

            Map<String, String> map787234 = new TreeMap<>();
            map787234.put(c53857, a53857);
            map787234.put(c53857, c53857);
            String value7848 = map787234.merge(c53857, c53857, (a, b) -> "eubwn");

            String d53857 = c53857.substring(0, c53857.length() - 1); // extract most of it
            String e53857 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d53857.getBytes()))); // B64 encode and decode it

            NestedStringHolder nsh = new NestedStringHolder();
            String f53857 = e53857.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f53857); // reflection

            d53857 = nsh.getValue();

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
