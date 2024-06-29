// CodeQL original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// CodeQL analysis results: [561]
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: BenchmarkTest01335.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/generics/bounds.tmt with index 2
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

@WebServlet(value = "/xss-02/BenchmarkTest01335")
public class BenchmarkTest0133579 extends HttpServlet {

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
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest01335");
            if (values != null) param = values[0];
        }

        String bar = new Test79().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", bar};
        java.io.PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html>\n<html>\n<body>\n<p>");
        out.format(java.util.Locale.US, "Formatted like: %1$s and %2$s.", obj);
        out.write("\n</p>\n</body>\n</html>");
    } // end doPost

    private class Test79 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "safe!";
            java.util.HashMap<String, Object> map45376 = new java.util.HashMap<String, Object>();

            C genericObj = new C();
            SomeGenericClass<C> obj = new SomeGenericClass<>(genericObj);
            param = handleGenericClassBounds(obj, param);
            map45376.put("keyA-45376", "a-Value"); // put some stuff in the collection
            map45376.put("keyB-45376", param); // put it in a collection
            map45376.put("keyC", "another-Value"); // put some stuff in the collection
            bar = (String) map45376.get("keyB-45376"); // get it back out

            return bar;
        }

        public String handleGenericClassBounds(
                SomeGenericClass<? super C> genericClassObj, String param) {
            Object obj = genericClassObj.getValue();
            if (obj instanceof B) {
                return param;
            } else {
                return "";
            }
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
