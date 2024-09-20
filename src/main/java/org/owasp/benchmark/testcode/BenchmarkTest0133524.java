// CodeQL original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 400, 730]
// Snyk analysis results: [400, 730, 79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01335.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/set.tmt
// with name set_union_negative
// Used extensions: MACRO_VarName -> sealed39745 | MACRO_VarName -> obj39745 | EXPR_String -> ""
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

@WebServlet(value = "/xss-02/BenchmarkTest01335")
public class BenchmarkTest0133524 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

        Object sealed39745 = new PermittedSub1();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest01335");
            if (values != null) param = values[0];
        }

        String bar = new Test24().doSomething(request, param);

        Object obj39745 = new ImplementingSubClass();

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", bar};
        java.io.PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html>\n<html>\n<body>\n<p>");

        UnaryOpInterface val89458 =
                new UnaryOpInterface() {
                    @Override
                    public String InterfaceCall(String t) {
                        out.format(java.util.Locale.US, "Formatted like: %1$s and %2$s.", obj);
                        out.write("\n</p>\n</body>\n</html>");

                        return "";
                    }
                };
    } // end doPost

    private class Test24 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "safe!";
            java.util.HashMap<String, Object> map45376 = new java.util.HashMap<String, Object>();
            map45376.put("keyA-45376", "a-Value"); // put some stuff in the collection
            map45376.put("keyB-45376", param); // put it in a collection
            map45376.put("keyC", "another-Value"); // put some stuff in the collection
            bar = (String) map45376.get("keyB-45376"); // get it back out

            Set<String> set111 = new HashSet<>();
            Set<String> set222 = new HashSet<>();
            set111.add(param.replaceAll(bar, bar));
            set222.add(bar);
            set111.addAll(set222);
            String value7847 = "usbmw";
            if (set111.contains(bar)) {
                bar = "bnkxi";
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass