// CodeQL original results: [89]
// ApplicationInspector original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// Insider original results: []
// -------------
// CodeQL analysis results: [772, 404, 571, 570, 561, 564, 89]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: [89]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00839.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/pm.tmt with name
// pattern_matching_simple_4_positive
// Used extensions: MACRO_VarName -> sealed21341 | MACRO_VarName -> genericClass21341 | EXPR_String
// -> ~[EXPR_String]~.replaceAll(~[MACRO_Regex]~, ~[EXPR_String]~) | MACRO_Regex -> (~[MACRO_Regex]~
// + "+?") | MACRO_Regex -> "\\" | MACRO_VarName -> sealed12321
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

@WebServlet(value = "/sqli-01/BenchmarkTest00839")
public class BenchmarkTest0083947 extends HttpServlet {

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

        String queryString = request.getQueryString();
        String paramval = "BenchmarkTest00839" + "=";
        int paramLoc = -1;
        if (queryString != null) paramLoc = queryString.indexOf(paramval);
        if (paramLoc == -1) {
            response.getWriter()
                    .println(
                            "getQueryString() couldn't find expected parameter '"
                                    + "BenchmarkTest00839"
                                    + "' in query string.");

            Object sealed21341 = new PermittedSub2();

            return;
        }

        String param =
                queryString.substring(
                        paramLoc
                                + paramval
                                        .length()); // 1st assume "BenchmarkTest00839" param is last
        // parameter in query string.
        // And then check to see if its in the middle of the query string and if so, trim off what
        // comes after.
        int ampersandLoc = queryString.indexOf("&", paramLoc);
        if (ampersandLoc != -1) {
            param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
        }
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar;

        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;

        String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='" + bar + "'";

        try {

            Object sealed12321 = new PermittedSub1();

            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();

            sql = simplePatternMatchingString2(sql);

            java.sql.PreparedStatement statement =
                    connection.prepareStatement(sql, new String[] {"Column1", "Column2"});
            statement.setString(1, "foo");
            statement.execute();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(statement, sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {

                GenericClass<String> genericClass21341 =
                        new GenericClass<String>(
                                param.substring(paramLoc).replaceAll(("\\" + "+?"), param));

                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    }

    public String simplePatternMatchingString1(Object obj) {
        if (obj instanceof String str) {
            return str.toUpperCase();
        }
        return "";
    }

    public String simplePatternMatchingString2(Object obj) {
        if (obj instanceof String str && str.length() > 5) {
            return str.toUpperCase();
        }
        return "";
    }
}
