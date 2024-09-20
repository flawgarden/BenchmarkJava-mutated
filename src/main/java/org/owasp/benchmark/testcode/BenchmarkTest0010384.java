// CodeQL original results: [89]
// ApplicationInspector original results: [89]
// Semgrep original results: [89]
// Insider original results: []
// -------------
// CodeQL analysis results: [570, 571, 477, 561, 79, 564, 89]
// ApplicationInspector analysis results: [89, 565, 113, 79]
// Semgrep analysis results: [1004]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00103.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt
// with name varargs_get_first_string_negative
// Used extensions: MACRO_VarName -> obj12321 | MACRO_VarName -> obj21341 | EXPR_String -> ""
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

@WebServlet(value = "/sqli-00/BenchmarkTest00103")
public class BenchmarkTest0010384 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie("BenchmarkTest00103", "bar");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
        response.addCookie(userCookie);
        javax.servlet.RequestDispatcher rd =
                request.getRequestDispatcher("/sqli-00/BenchmarkTest00103.html");
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
                if (theCookie.getName().equals("BenchmarkTest00103")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
                    break;
                }
            }
        }

        String bar;

        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        SimpleRecord recordEmpty = new SimpleRecord("");

        SuperClass obj21341 = new SubSubClass();

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;

        Object obj12321 = new ImplementingSuperSideClass();

        String sql =
                "SELECT TOP 1 USERNAME from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
        try {
            Object results = sql = getFirstString("", request.getPathTranslated());

            org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForObject(
                    sql, new Object[] {}, String.class);
            response.getWriter().println("Your results are: ");

            //		System.out.println("Your results are");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(results.toString()));
            //		System.out.println(results.toString());
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            response.getWriter()
                    .println(
                            "No results returned for query: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql));
        } catch (org.springframework.dao.DataAccessException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    }

    public String getFirstString(String... lines) {
        return getStringWithIndex(0, lines);
    }

    public String getStringWithIndex(int ind, String... lines) {
        return lines[ind];
    }

    public String getFirstStringFromArray(String... lines) {
        return Arrays.asList(lines).get(0);
    }

    public <T84> T84 varargsWithGenerics(T84... elements) {
        return elements[0];
    }

    public String combineStrings(String... strings) {
        return String.join(", ", strings);
    }
}