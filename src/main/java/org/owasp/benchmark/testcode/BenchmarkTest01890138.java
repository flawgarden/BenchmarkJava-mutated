// CodeQL original results: [89]
// ApplicationInspector original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 89, 564]
// ApplicationInspector analysis results: [565, 113]
// Snyk analysis results: [1004]
// Semgrep analysis results: [1004, 89]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01890.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/list.tmt
// with name list_to_array_and_get_negative
// Used extensions: MACRO_VarName -> sealed21341 | MACRO_VarName -> genericClass39745 |
// MACRO_VarName -> sealed12321 | MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new
// ArrayList<>(); | MACRO_Add_CONST_ToList -> ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~@1]~); |
// MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231
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

@WebServlet(value = "/sqli-04/BenchmarkTest01890")
public class BenchmarkTest01890138 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie("BenchmarkTest01890", "bar");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());

        Object sealed12321 = new PermittedSub2();

        response.addCookie(userCookie);
        javax.servlet.RequestDispatcher rd =
                request.getRequestDispatcher("/sqli-04/BenchmarkTest01890.html");
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
                if (theCookie.getName().equals("BenchmarkTest01890")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
                    break;
                }
            }

            GenericClass<String> genericClass39745 = new GenericClass<String>(param.toString());
        }

        String bar = doSomething(request, param);

        String sql = "INSERT INTO users (username, password) VALUES ('foo','" + bar + "')";

        try {
            java.sql.Statement statement =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
            int count = statement.executeUpdate(sql, new String[] {"USERNAME", "PASSWORD"});
            org.owasp.benchmark.helpers.DatabaseHelper.outputUpdateComplete(sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        List<String> list787231 = new ArrayList<>();
        list787231.add("hxjgm");
        param = (String) list787231.toArray()[0];

        String bar = param;

        return bar;
    }

    Object sealed21341 = new SealedSuper();
}
