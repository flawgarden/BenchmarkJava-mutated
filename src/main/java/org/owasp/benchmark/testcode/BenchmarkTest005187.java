// CodeQL original results: [89]
// ApplicationInspector original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 89, 564]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: [89]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00518.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/virtuality/default.tmt with name
// binary_op_interface_default2_negative
// Used extensions: MACRO_VarName -> obj12321
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
 * @author Nick Sanidas
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

@WebServlet(value = "/sqli-01/BenchmarkTest00518")
public class BenchmarkTest005187 extends HttpServlet {

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

        BinaryOpInterfaceDefault2 a12341 = new BinaryOpInterfaceDefault2Implementation();
        String param = "";

        Object obj12321 = new ImplementingSuperSideClass();

        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest00518");
            if (values != null) param = values[0];
        }

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();

        param = a12341.InterfaceCall(param, "");

        String bar = thing.doSomething(param);

        String sql = "INSERT INTO users (username, password) VALUES ('foo','" + bar + "')";

        try {
            java.sql.Statement statement =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
            int count = statement.executeUpdate(sql, new int[] {1, 2});
            org.owasp.benchmark.helpers.DatabaseHelper.outputUpdateComplete(sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    }
}