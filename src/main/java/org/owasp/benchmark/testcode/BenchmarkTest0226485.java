// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02264.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/exceptions/tryCatchFinally.tmt with name
// try_multi_cath_positive
// Used extensions: MACRO_VarName -> sealed39745 | MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~>
// ~[MACRO_MapName@1]~ = new HashMap<>(); | MACRO_MapName@1 -> map787234
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

@WebServlet(value = "/sqli-04/BenchmarkTest02264")
public class BenchmarkTest0226485 extends HttpServlet {

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

        Object sealed39745 = new PermittedSub2();

        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest02264");
            if (values != null) param = values[0];
        }

        String bar = doSomething(request, param);

        String sql = "{call " + bar + "}";

        try {
            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
            java.sql.CallableStatement statement = connection.prepareCall(sql);
            java.sql.ResultSet rs = statement.executeQuery();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);

        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");

                Map<String, String> map787234 = new HashMap<>();
                map787234.put(response.getHeader(bar), bar);
                String value7842 = map787234.get(sql);

                return;
            } else throw new ServletException(e);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "";
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("safe");
            valuesList.add(param);
            valuesList.add("moresafe");

            String tmpUnique42 = bar;
            valuesList.remove(0); // remove the 1st safe value

            bar = valuesList.get(0); // get the param value

            try {
                if (request.getDateHeader(bar) < serialVersionUID) {
                    throw new Exception1(bar.toLowerCase());
                } else {
                    throw new Exception2(request.getContextPath());
                }
            } catch (Exception1 | Exception2 e) {
                bar = tmpUnique42;
            }
        }

        return bar;
    }
}
