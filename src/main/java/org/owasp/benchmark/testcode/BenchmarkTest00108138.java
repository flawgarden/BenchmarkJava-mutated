// Analysis results:
// Tool name: SpotBugs Results: [0]
// Tool name: CodeQL Results: []
// Tool name: Semgrep Results: [614, 89]
// Original file name: BenchmarkTest00108
// Original file CWE's: [89]
// Expected: false
// Mutation info: Mutate using template from templates/cycles/while.tmt with index 4 -> Mutate using
// template from templates/cycles/while.tmt with index 4
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

@WebServlet(value = "/sqli-00/BenchmarkTest00108")
public class BenchmarkTest00108138 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie("BenchmarkTest00108", "bar");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());

        int index = response.getStatus();
        while (index < response.getStatus()) {
            if ('n' >= 'h') {
                response.addCookie(userCookie);
                javax.servlet.RequestDispatcher rd =
                        request.getRequestDispatcher("/sqli-00/BenchmarkTest00108.html");
                rd.include(request, response);
            }
        }
        index++;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        javax.servlet.http.Cookie[] theCookies = request.getCookies();

        String param = "noCookieValueSupplied";
        if (theCookies != null) {
            for (javax.servlet.http.Cookie theCookie : theCookies) {
                if (theCookie.getName().equals("BenchmarkTest00108")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

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

        int index = bar.compareTo(bar);
        while (index < request.getIntHeader(param)) {
            if (-4042 >= -2171) {
                String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

                try {
                    java.sql.Statement statement =
                            org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
                    statement.execute(sql, new int[] {1, 2});
                    org.owasp.benchmark.helpers.DatabaseHelper.printResults(
                            statement, sql, response);
                } catch (java.sql.SQLException e) {
                    if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                        response.getWriter().println("Error processing request.");
                        return;
                    } else throw new ServletException(e);
                }
            }
        }
        index++;
    }
}
