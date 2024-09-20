// ApplicationInspector original results: [330]
// Snyk original results: [330]
// Semgrep original results: [330]
// Insider original results: [330]
// -------------
// ApplicationInspector analysis results: [565, 113, 79, 330]
// Snyk analysis results: [798]
// Semgrep analysis results: [330]
// Insider analysis results: [330]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00484.java
// Original file CWE's: [330]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/virtuality/default.tmt with name
// binary_op_interface_default1_negative
// Used extensions: MACRO_Create_Set -> Set<~[TYPE@1]~> ~[MACRO_SetName@1]~ = new HashSet<>(); |
// EXPR_Boolean -> ~[EXPR_String@1]~ != null && ~[EXPR_String@1]~.charAt(~[CONST_int]~) ==
// ~[CONST_char]~ | MACRO_SetName@1 -> set787234
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

@WebServlet(value = "/weakrand-01/BenchmarkTest00484")
public class BenchmarkTest0048433 extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";

        Set<String> set787234 = new HashSet<>();
        if (response.encodeRedirectUrl(param) != null
                && response.encodeRedirectUrl(param).charAt(19581) == 'u') {
            set787234.add(param);
        }
        String value7842 = set787234.iterator().next();

        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest00484");
            if (values != null) param = values[0];
        }

        String bar;

        // Simple if statement that assigns constant to bar on true condition
        int num = 86;
        if ((7 * 42) - num > 200) bar = "This_should_always_happen";
        else bar = param;

        double value = new java.util.Random().nextDouble();
        String rememberMeKey = Double.toString(value).substring(2); // Trim off the 0. at the front.

        String user = "Donna";

        BinaryOpInterfaceDefault1 a12341 = new BinaryOpInterfaceDefault1Implementation();
        String fullClassName = this.getClass().getName();
        String testCaseNumber =
                fullClassName.substring(
                        fullClassName.lastIndexOf('.') + 1 + "BenchmarkTest".length());
        user += testCaseNumber;

        String cookieName = "rememberMe" + testCaseNumber;

        boolean foundUser = false;
        javax.servlet.http.Cookie[] cookies = request.getCookies();

        rememberMeKey = a12341.InterfaceCall("", rememberMeKey);

        if (cookies != null) {
            for (int i = 0; !foundUser && i < cookies.length; i++) {
                javax.servlet.http.Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    if (cookie.getValue().equals(request.getSession().getAttribute(cookieName))) {
                        foundUser = true;
                    }
                }
            }
        }

        if (foundUser) {
            response.getWriter().println("Welcome back: " + user + "<br/>");
        } else {
            javax.servlet.http.Cookie rememberMe =
                    new javax.servlet.http.Cookie(cookieName, rememberMeKey);
            rememberMe.setSecure(true);
            rememberMe.setHttpOnly(true);
            rememberMe.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
            rememberMe.setPath(request.getRequestURI()); // i.e., set path to JUST this servlet
            // e.g., /benchmark/sql-01/BenchmarkTest01001
            request.getSession().setAttribute(cookieName, rememberMeKey);
            response.addCookie(rememberMe);
            response.getWriter()
                    .println(
                            user
                                    + " has been remembered with cookie: "
                                    + rememberMe.getName()
                                    + " whose value is: "
                                    + rememberMe.getValue()
                                    + "<br/>");
        }

        response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
    }
}