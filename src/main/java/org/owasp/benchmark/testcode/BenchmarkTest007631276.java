// Analysis results:
// Tool name: SpotBugs Results: [89, 0]
// Tool name: CodeQL Results: []
// Tool name: Semgrep Results: []
// Original file name: BenchmarkTest00763
// Original file CWE's: [89]
// Expected: false
// Mutation info: Mutate using template from templates/cycles/while.tmt with index 4
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

@WebServlet(value = "/sqli-01/BenchmarkTest00763")
public class BenchmarkTest007631276 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00763");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar;
        String guess = "ABC";
        char switchTarget = guess.charAt(1); // condition 'B', which is safe

        // Simple case statement that assigns param to bar on conditions 'A', 'C', or 'D'
        switch (switchTarget) {
            case 'A':
                bar = param;
                break;
            case 'B':
                bar = "bob";
                break;
            case 'C':
            case 'D':
                bar = param;
                break;
            default:
                bar = "bob's your uncle";

                int index = response.getStatus();
                while (index < guess.lastIndexOf(param)) {
                    if (!request.getRemoteUser().equals(response.encodeRedirectURL(guess))
                            || !bar.equals(param)) {
                        break;
                    }

                    String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='" + bar + "'";

                    try {
                        java.sql.Connection connection =
                                org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
                        java.sql.PreparedStatement statement =
                                connection.prepareStatement(sql, new int[] {1, 2});
                        statement.setString(1, "foo");
                        statement.execute();
                        org.owasp.benchmark.helpers.DatabaseHelper.printResults(
                                statement, sql, response);
                    } catch (java.sql.SQLException e) {
                        if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                            response.getWriter().println("Error processing request.");
                            return;
                        } else throw new ServletException(e);
                    }
                }
                index++;
        }
    }
}