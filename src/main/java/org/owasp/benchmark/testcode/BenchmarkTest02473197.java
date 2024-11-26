// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02473.java
// Original file CWE's: [330]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt with name queue_poll_negative
// Used extensions: MACRO_VarName -> obj39745 | MACRO_VarName -> sealed39745 | MACRO_Create_Queue -> Queue<~[TYPE@1]~> ~[MACRO_QueueName]~ = new ArrayDeque<>(); | MACRO_Add_CONST_ToQueue -> ~[MACRO_QueueName]~.add(~[CONST_~[TYPE@1]~]~); | MACRO_Add_CONST_ToQueue -> ~[MACRO_QueueName]~.add(~[CONST_~[TYPE@1]~]~); | MACRO_Add_Fixed_VAR_ToQueue -> ~[MACRO_QueueName]~.offer(~[VAR_~[TYPE@1]~@1]~); | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231
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
import java.util.concurrent.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/weakrand-05/BenchmarkTest02473")
public class BenchmarkTest02473197 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest02473");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = doSomething(request, param);

        double value = java.lang.Math.random();
        String rememberMeKey = Double.toString(value).substring(2); // Trim off the 0. at the front.

        Queue<String> queue787231 = new ArrayDeque<>();
        queue787231.add("rxetp");
        queue787231.add("bdeny");
        queue787231.offer(rememberMeKey);
        rememberMeKey = queue787231.poll();

        String user = "Doug";
        String fullClassName = this.getClass().getName();
        String testCaseNumber =
                fullClassName.substring(
                        fullClassName.lastIndexOf('.') + 1 + "BenchmarkTest".length());
        user += testCaseNumber;

        String cookieName = "rememberMe" + testCaseNumber;

        boolean foundUser = false;
        javax.servlet.http.Cookie[] cookies = request.getCookies();
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

            Object obj39745 = new ImplementingSuperSideClass();

        } else {

            Object sealed39745 = new SealedSuper();

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
        response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "safe!";
        java.util.HashMap<String, Object> map91880 = new java.util.HashMap<String, Object>();
        map91880.put("keyA-91880", "a-Value"); // put some stuff in the collection
        map91880.put("keyB-91880", param); // put it in a collection
        map91880.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map91880.get("keyB-91880"); // get it back out

        return bar;
    }
}
