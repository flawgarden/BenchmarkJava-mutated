// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: []
// Insider original results: []
// -------------
// ApplicationInspector analysis results: []
// Snyk analysis results: [501]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01547.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/conditional/recursion.tmt with name
// recursion_simple_negative
// Used extensions: MACRO_VarName -> obj09823
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

@WebServlet(value = "/trustbound-00/BenchmarkTest01547")
public class BenchmarkTest0154729 extends HttpServlet {

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

        UnaryOpInterface val89458 = (t) -> "";

        String param = scr.getTheParameter("BenchmarkTest01547");
        if (param == null) param = "";

        String bar = new Test29().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");

        bar = paramOrEmpty(-1, bar);
    } // end doPost

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

    private class Test29 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "";
            if (param != null) bar = param.split(" ")[0];

            return bar;
        }

        SuperClass obj09823 = new SubSubClass();
    } // end innerclass Test
} // end DataflowThruInnerClass
