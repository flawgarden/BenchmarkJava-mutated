// CodeQL original results: [89]
// ApplicationInspector original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// Insider original results: []
// -------------
// CodeQL analysis results: [772, 404, 561, 564, 89]
// ApplicationInspector analysis results: []
// Snyk analysis results: [89]
// Semgrep analysis results: [200, 89]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02635.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/for.tmt
// with name for_operator_change_index_negative
// Used extensions: MACRO_VarName -> genericClass21341 | MACRO_VarName -> obj39745 | EXPR_int ->
// ~[EXPR_String]~.length()
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/sqli-05/BenchmarkTest02635")
public class BenchmarkTest0263551 extends HttpServlet {

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

        SuperClass obj39745 = new SiblingClass();

        String queryString = request.getQueryString();
        String paramval = "BenchmarkTest02635" + "=";
        int paramLoc = -1;
        if (queryString != null) paramLoc = queryString.indexOf(paramval);
        if (paramLoc == -1) {
            response.getWriter()
                    .println(
                            "getQueryString() couldn't find expected parameter '"
                                    + "BenchmarkTest02635"
                                    + "' in query string.");

            BinaryOpInterface val89458 = (t, u) -> "";

            return;
        }

        String param =
                queryString.substring(
                        paramLoc
                                + paramval
                                        .length()); // 1st assume "BenchmarkTest02635" param is last
        // parameter in query string.
        // And then check to see if its in the middle of the query string and if so, trim off what
        // comes after.
        int ampersandLoc = queryString.indexOf("&", paramLoc);
        if (ampersandLoc != -1) {
            param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);

            for (int i = 0;
                    i < response.encodeURL(queryString).length();
                    i += queryString.offsetByCodePoints(ampersandLoc, paramLoc)) {
                queryString = "";
            }
        }
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='" + bar + "'";

        GenericClass<String> genericClass21341 =
                new GenericClass<String>(response.encodeUrl(paramval));

        try {
            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
            java.sql.PreparedStatement statement =
                    connection.prepareStatement(
                            sql,
                            java.sql.ResultSet.TYPE_FORWARD_ONLY,
                            java.sql.ResultSet.CONCUR_READ_ONLY,
                            java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT);
            statement.setString(1, "foo");
            statement.execute();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(statement, sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar;
        String guess = "ABC";
        char switchTarget = guess.charAt(2);

        // Simple case statement that assigns param to bar on conditions 'A', 'C', or 'D'
        switch (switchTarget) {
            case 'A':
                bar = param;
                break;
            case 'B':
                bar = "bobs_your_uncle";
                break;
            case 'C':
            case 'D':
                bar = param;
                break;
            default:
                bar = "bobs_your_uncle";
                break;
        }

        return bar;
    }
}
