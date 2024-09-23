// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00328.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/field/nested.tmt with
// name nested_field_depth_4_array_positive
// Used extensions: MACRO_Regex -> (~[MACRO_Regex]~ + ~[MACRO_Regex]~) | MACRO_Regex -> "[^abc]" |
// MACRO_Regex -> (~[MACRO_Regex]~ + "|" +  ~[MACRO_Regex]~) | MACRO_Regex -> (~[MACRO_Regex]~ +
// "+") | MACRO_Regex -> (~[MACRO_Regex]~ + "|" +  ~[MACRO_Regex]~) | MACRO_Regex -> "[a-z]+" |
// MACRO_Regex -> (~[MACRO_Regex]~ + "??") | MACRO_Regex -> "\0mnn" | MACRO_Regex ->
// (~[MACRO_Regex]~ + "*?") | MACRO_Regex -> "[^abc]" | MACRO_VarName -> obj12321 | MACRO_VarName ->
// obj39745
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/sqli-00/BenchmarkTest00328")
public class BenchmarkTest003281 extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00328");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element

            Object obj39745 = new ImplementingSubClass();
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar;

        String[] arr4124 = new String[] {param};
        NestedFields4 nested7231 = new NestedFields4(arr4124);
        param = nested7231.nested1.nested1.nested1.nested1.values[0];

        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;

        SuperClass obj12321 = new SuperClass();

        String sql = "{call " + bar + "}";

        try {
            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();

            Pattern pattern =
                    Pattern.compile(
                            ("[^abc]"
                                    + (("[a-z]+" + "+")
                                            + "|"
                                            + ((("[^abc]" + "*?") + "??") + "|" + "\0mnn"))));
            Matcher matcher = pattern.matcher(request.changeSessionId());

            java.sql.CallableStatement statement = connection.prepareCall(sql);
            java.sql.ResultSet rs = statement.executeQuery();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);

        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    }
}
