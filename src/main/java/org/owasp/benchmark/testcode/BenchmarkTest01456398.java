// CodeQL original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// SonarQube original results: []
// CodeQL analysis results: [570, 571, 561]
// Semgrep analysis results: [200, 501, 79]
// Insider analysis results: []
// SonarQube analysis results: []
// Original file name: BenchmarkTest01456.java
// Original file CWE's: [501]
// Mutation info: Insert template from templates/constructors/factory.tmt with index 0
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
import org.owasp.benchmark.helpers.FactoryExample;

@WebServlet(value = "/trustbound-00/BenchmarkTest01456")
public class BenchmarkTest01456398 extends HttpServlet {

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

        String param = "";
        boolean flag = true;
        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest01456")) {
                        param = name;
                        flag = false;
                    }
                }
            }
            FactoryExample fe = FactoryExample.createInstance(response.encodeUrl(param));
            param = fe.val;
        }

        String bar = new Test398().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test398 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar;

            // Simple if statement that assigns param to bar on true condition
            int num = 196;
            if ((500 / 42) + num > 200) bar = param;
            else bar = "This should never happen";

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
