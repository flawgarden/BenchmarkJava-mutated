// CodeQL original results: [89]
// Semgrep original results: [89]
// SonarQube original results: [89]
// Insider original results: []
// CodeQL analysis results: [404, 772, 561]
// Semgrep analysis results: [200, 89]
// SonarQube analysis results: [89, 20]
// Insider analysis results: []
// Original file name: BenchmarkTest01462.java
// Original file CWE's: [89]
// Mutation info: Insert template from templates/generics/bounds.tmt with index 1
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

@WebServlet(value = "/sqli-03/BenchmarkTest01462")
public class BenchmarkTest01462590 extends HttpServlet {

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
                    if (value.equals("BenchmarkTest01462")) {
                        param = name;
                        flag = false;
                    }

                    A genericObj = new A();
                    SomeGenericClass<A> obj = new SomeGenericClass<>(genericObj);
                    param = handleGenericClassBounds(obj, response.encodeURL(value));
                }
            }
        }

        String bar = new Test590().doSomething(request, param);

        String sql = "{call " + bar + "}";

        try {
            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
            java.sql.CallableStatement statement =
                    connection.prepareCall(
                            sql,
                            java.sql.ResultSet.TYPE_FORWARD_ONLY,
                            java.sql.ResultSet.CONCUR_READ_ONLY,
                            java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT);
            java.sql.ResultSet rs = statement.executeQuery();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    } // end doPost

    public String handleGenericClassBounds(
            SomeGenericClass<? extends A> genericClassObj, String param) {
        Object obj = genericClassObj.getValue();
        if (obj instanceof B) {
            return param;
        } else {
            return "";
        }
    }

    private class Test590 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = param;

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
