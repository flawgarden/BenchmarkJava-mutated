// CodeQL original results: [79]
// Insider original results: []
// Semgrep original results: []
// CodeQL analysis results: [561, 79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest01525.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/generics/wildcard.tmt with index 0
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
import org.owasp.benchmark.helpers.generics.*;

@WebServlet(value = "/xss-03/BenchmarkTest01525")
public class BenchmarkTest01525462 extends HttpServlet {

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
        String param = scr.getTheParameter("BenchmarkTest01525");
        if (param == null) param = "";

        String bar = new Test462().doSomething(request, param);

        String genericObj = bar.toLowerCase();
        SimpleGenericClass<String> obj = new SimpleGenericClass<>(genericObj);
        bar = (String) handleGenericClassWildcard(obj);
        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().write("Parameter value: " + bar);
    } // end doPost

    public Object handleGenericClassWildcard(SimpleGenericClass<?> genericClassObj) {
        Object obj = genericClassObj.getValue();
        if (obj instanceof String) {
            return "";
        } else {
            return obj;
        }
    }

    private class Test462 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = param;
            if (param != null && param.length() > 1) {
                StringBuilder sbxyz67457 = new StringBuilder(param);
                bar =
                        sbxyz67457
                                .replace(param.length() - "Z".length(), param.length(), "Z")
                                .toString();
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
