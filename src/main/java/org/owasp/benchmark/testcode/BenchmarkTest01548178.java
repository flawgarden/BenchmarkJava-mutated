// CodeQL original results: [501]
// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79, 501]
// ApplicationInspector analysis results: [79, 501]
// Snyk analysis results: []
// Semgrep analysis results: [501]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01548.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt
// with name varargs_with_generics_negative
// Used extensions: EXPR_String -> ~[EXPR_String]~.toLowerCase()
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

@WebServlet(value = "/trustbound-00/BenchmarkTest01548")
public class BenchmarkTest01548178 extends HttpServlet {

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

        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);

        BinaryOpInterface val89458 = (t, u) -> "luejk";

        String param = scr.getTheParameter("BenchmarkTest01548");
        if (param == null) param = "";

        String bar = new Test178().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)

        bar = varargsWithGenerics(request.getMethod().toLowerCase(), scr.getTheParameter(bar));

        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    public String getFirstString(String... lines) {
        return getStringWithIndex(0, lines);
    }

    public String getStringWithIndex(int ind, String... lines) {
        return lines[ind];
    }

    public String getFirstStringFromArray(String... lines) {
        return Arrays.asList(lines).get(0);
    }

    public <T178> T178 varargsWithGenerics(T178... elements) {
        return elements[0];
    }

    public String combineStrings(String... strings) {
        return String.join(", ", strings);
    }

    private class Test178 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar;
            String guess = "ABC";
            char switchTarget = guess.charAt(2);

            // Simple case statement that assigns param to bar on conditions 'A', 'C', or 'D'
            switch (switchTarget) {
                case 'A':
                    bar = param;
                    break;
                case 'B':
                    bar = "bobs_your_uncle";
                    break;
                case 'C':
                case 'D':
                    bar = param;
                    break;
                default:
                    bar = "bobs_your_uncle";
                    break;
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass