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
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01375.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/set.tmt
// with name set_add_simple_negative
// Used extensions: MACRO_VarName -> obj21341 | MACRO_VarName -> sealed12321 | MACRO_Create_Set ->
// Set<~[TYPE@1]~> ~[MACRO_SetName]~ = new LinkedHashSet<>(); | MACRO_Add_Fixed_CONST_ToSet ->
// ~[MACRO_SetName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_SetName -> set787231 | MACRO_SetName ->
// set787231 | MACRO_SetName -> set787231
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

@WebServlet(value = "/trustbound-00/BenchmarkTest01375")
public class BenchmarkTest0137523 extends HttpServlet {

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

        Object obj21341 = new ImplementingSuperSideClass();

        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest01375");
            if (values != null) param = values[0];
        }

        String bar = new Test23().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test23 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence
            String a33070 = param; // assign

            Set<String> set787231 = new LinkedHashSet<>();
            set787231.add(a33070);
            a33070 = set787231.iterator().next();

            StringBuilder b33070 = new StringBuilder(a33070); // stick in stringbuilder
            b33070.append(" SafeStuff"); // append some safe content
            b33070.replace(
                    b33070.length() - "Chars".length(),
                    b33070.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map33070 = new java.util.HashMap<String, Object>();
            map33070.put("key33070", b33070.toString()); // put in a collection
            String c33070 = (String) map33070.get("key33070"); // get it back out
            String d33070 = c33070.substring(0, c33070.length() - 1); // extract most of it
            String e33070 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d33070.getBytes()))); // B64 encode and decode it
            String f33070 = e33070.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f33070); // reflection

            return bar;
        }
    } // end innerclass Test

    Object sealed12321 = new SealedSuper();
} // end DataflowThruInnerClass
