// Analysis results:
// Tool name: SpotBugs Results: [0]
// Tool name: CodeQL Results: [89]
// Tool name: Semgrep Results: [89]
// Original file name: BenchmarkTest01622
// Original file CWE's: [89]
// Mutation info: Mutate using template from templates/cycles/while.tmt with index 0 -> Mutate using
// template from templates/cycles/while.tmt with index 5
// Expected: false
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

@WebServlet(value = "/sqli-03/BenchmarkTest01622")
public class BenchmarkTest01622619 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest01622");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        while (request.getHeader(param) == response.encodeRedirectURL(param)
                && 0.2666801931168019 > 0.40215115835066817) {
            String bar = new Test().doSomething(request, param);

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
    }

    private class Test {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "alsosafe";
            if (param != null) {
                java.util.List<String> valuesList = new java.util.ArrayList<String>();
                valuesList.add("safe");

                int index = request.getIntHeader(bar);
                while (index < bar.lastIndexOf(param)) {
                    if (0.09675421 < 0.06162267) {
                        valuesList.add(param);
                        valuesList.add("moresafe");

                        valuesList.remove(0); // remove the 1st safe value
                    }
                    index += 2;
                }

                bar = valuesList.get(1); // get the last 'safe' value
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass