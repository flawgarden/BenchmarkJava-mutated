// CodeQL original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [772, 404, 561, 89, 564]
// ApplicationInspector analysis results: [565, 113]
// Snyk analysis results: [1004]
// Semgrep analysis results: [1004, 200, 89]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00997.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/map.tmt
// with name map_merge_1_positive
// Used extensions: MACRO_VarName -> genericClass09823 | EXPR_String -> ~[EXPR_String]~.trim()
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

@WebServlet(value = "/sqli-02/BenchmarkTest00997")
public class BenchmarkTest00997160 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie(
                        "BenchmarkTest00997", "verifyUserPassword%28%27foo%27%2C%27bar%27%29");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
        response.addCookie(userCookie);
        javax.servlet.RequestDispatcher rd =
                request.getRequestDispatcher("/sqli-02/BenchmarkTest00997.html");
        rd.include(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        javax.servlet.http.Cookie[] theCookies = request.getCookies();

        String param = "noCookieValueSupplied";
        if (theCookies != null) {
            for (javax.servlet.http.Cookie theCookie : theCookies) {
                if (theCookie.getName().equals("BenchmarkTest00997")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        String bar = new Test160().doSomething(request, param);

        String sql = "{call " + bar + "}";

        try {

            GenericClass<String> genericClass09823 =
                    new GenericClass<String>(response.encodeRedirectUrl(param).trim());

            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
            java.sql.CallableStatement statement =
                    connection.prepareCall(
                            sql,
                            java.sql.ResultSet.TYPE_FORWARD_ONLY,
                            java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = statement.executeQuery();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    } // end doPost

    private class Test160 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "";

            Map<String, String> map111 = new HashMap<>();
            Map<String, String> map222 = new HashMap<>();
            map111.put(bar, bar);
            map222.put(bar, param);
            map111.putAll(map222);
            param = map111.get(bar);

            if (param != null) {
                java.util.List<String> valuesList = new java.util.ArrayList<String>();
                valuesList.add("safe");
                valuesList.add(param);
                valuesList.add("moresafe");

                valuesList.remove(0); // remove the 1st safe value

                bar = valuesList.get(0); // get the param value
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass