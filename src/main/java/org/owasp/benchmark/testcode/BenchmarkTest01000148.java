// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01000.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/exceptions/tryCatchFinally.tmt with name try_cath_negative
// Used extensions:
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

@WebServlet(value = "/sqli-02/BenchmarkTest01000")
public class BenchmarkTest01000148 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie(
                        "BenchmarkTest01000", "verifyUserPassword%28%27foo%27%2C%27bar%27%29");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
        response.addCookie(userCookie);
        javax.servlet.RequestDispatcher rd =
                request.getRequestDispatcher("/sqli-02/BenchmarkTest01000.html");
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

                UnaryOpInterface val89458 =
                        new UnaryOpInterface() {
                            @Override
                            public String InterfaceCall(String t) {
                                return "";
                            }
                        };

                if (theCookie.getName().equals("BenchmarkTest01000")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        String bar = new Test148().doSomething(request, param);

        String sql = "{call " + bar + "}";

        try {

            try {
                throw new Exception1(param);
            } catch (Exception1 e) {
                sql = "";
            }

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

    private class Test148 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "";
            if (param != null) {
                bar =
                        new String(
                                org.apache.commons.codec.binary.Base64.decodeBase64(
                                        org.apache.commons.codec.binary.Base64.encodeBase64(
                                                param.getBytes())));
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
