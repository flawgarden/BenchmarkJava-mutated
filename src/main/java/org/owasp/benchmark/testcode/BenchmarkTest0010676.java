// CodeQL original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 564, 89]
// ApplicationInspector analysis results: [565, 113]
// Snyk analysis results: [1004]
// Semgrep analysis results: [1004, 89]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00106.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/collections/streams.tmt with name stream_simple_negative
// Used extensions: MACRO_VarName -> obj12321 | MACRO_VarName -> obj12321 | MACRO_Regex ->
// "[a-z&&[^bc]]" | MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new ArrayList<>(); |
// MACRO_Add_Fixed_CONST_ToList -> ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~@1]~); |
// MACRO_Create_Stream -> Stream<~[TYPE@1]~> ~[MACRO_StreamName]~ = ~[MACRO_ListName]~.stream(); |
// MACRO_StreamName -> stream787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 |
// MACRO_StreamName -> stream787231 | MACRO_ListName -> list787231
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
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/sqli-00/BenchmarkTest00106")
public class BenchmarkTest0010676 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie("BenchmarkTest00106", "bar");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
        response.addCookie(userCookie);
        javax.servlet.RequestDispatcher rd =
                request.getRequestDispatcher("/sqli-00/BenchmarkTest00106.html");

        SuperClass obj12321 = new SiblingClass();

        rd.include(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        javax.servlet.http.Cookie[] theCookies = request.getCookies();

        Pattern pattern = Pattern.compile("[a-z&&[^bc]]");
        Matcher matcher = pattern.matcher("tvkww");

        String param = "noCookieValueSupplied";
        if (theCookies != null) {
            for (javax.servlet.http.Cookie theCookie : theCookies) {
                if (theCookie.getName().equals("BenchmarkTest00106")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        List<String> list787231 = new ArrayList<>();
        list787231.add("isazx");
        Stream<String> stream787231 = list787231.stream();
        param = stream787231.findFirst().get();

        String bar = "";
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("safe");
            valuesList.add(param);
            valuesList.add("moresafe");

            Object obj12321 = new ImplementingSuperClass();

            valuesList.remove(0); // remove the 1st safe value

            bar = valuesList.get(0); // get the param value
        }

        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

        try {
            java.sql.Statement statement =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
            statement.execute(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(statement, sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    }
}
