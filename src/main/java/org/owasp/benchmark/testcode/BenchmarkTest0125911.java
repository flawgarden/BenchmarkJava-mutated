// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [561]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01259.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/lambdas/mutation.tmt
// with name nested_unary_lambda_mutation_positive
// Used extensions:
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

@WebServlet(value = "/xss-02/BenchmarkTest01259")
public class BenchmarkTest0125911 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest01259");
        if (param == null) param = "";

        String bar = new Test11().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {bar, "b"};
        response.getWriter().printf("Formatted like: %1$s and %2$s.", obj);
    } // end doPost

    private class Test11 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "safe!";
            java.util.HashMap<String, Object> map26093 = new java.util.HashMap<String, Object>();
            map26093.put("keyA-26093", "a-Value"); // put some stuff in the collection

            UnaryOpClass val89458 =
                    new UnaryOpClass() {
                        @Override
                        public String VirtualCall(String t) {
                            return "";
                        }
                    };

            final String s23423 = bar;
            StringHolder a12341 = new StringHolder();
            UnaryOpMutationInterface lambda1231 =
                    (s) -> {
                        UnaryOpMutationInterface innerLambda1231 =
                                (p) -> {
                                    p.value = "";
                                };
                        innerLambda1231.Mutate(s);
                        s.value = s23423;
                    };
            lambda1231.Mutate(a12341);
            map26093.put("keyB-26093", param); // put it in a collection
            map26093.put("keyC", "another-Value"); // put some stuff in the collection
            bar = (String) map26093.get("keyB-26093"); // get it back out

            bar = a12341.value;

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass