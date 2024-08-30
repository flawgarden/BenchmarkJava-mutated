//CodeQL original results: [330]
//ApplicationInspector original results: [330]
//Snyk original results: [330]
//Semgrep original results: [330]
//Insider original results: [330]
//-------------
//CodeQL analysis results: [561, 338, 330, 79, 335]
//ApplicationInspector analysis results: [565, 113]
//Snyk analysis results: [330, 798, 1004]
//Semgrep analysis results: [1004, 330, 22]
//Insider analysis results: [330]
//Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00081.java
//Original file CWE's: [330]  
//Original file kind: fail
//Mutation info: Insert template from templates-db/languages/java/sensitivity/concurrency/concurrency.tmt with name atomic_integer_restore_positive 
//Used extensions: MACRO_Regex -> (~[MACRO_Regex]~ + "*?") | EXPR_String -> ~[EXPR_String]~.trim() | MACRO_Regex -> "\f"
//Program:
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.*;

@WebServlet(value = "/weakrand-00/BenchmarkTest00081")
public class BenchmarkTest0008146 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        javax.servlet.http.Cookie userCookie =
                new javax.servlet.http.Cookie("BenchmarkTest00081", "whatever");
        userCookie.setMaxAge(60 * 3); // Store cookie for 3 minutes
        userCookie.setSecure(true);
        userCookie.setPath(request.getRequestURI());
        userCookie.setDomain(new java.net.URL(request.getRequestURL().toString()).getHost());
        response.addCookie(userCookie);
        javax.servlet.RequestDispatcher rd =
                request.getRequestDispatcher("/weakrand-00/BenchmarkTest00081.html");
        rd.include(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        javax.servlet.http.Cookie[] theCookies = request.getCookies();

Pattern pattern = Pattern.compile(("\f" + "*?"));
Matcher matcher = pattern.matcher(request.getRequestURI().trim());

String param = "noCookieValueSupplied";
        if (theCookies != null) {
            for (javax.servlet.http.Cookie theCookie : theCookies) {
                if (theCookie.getName().equals("BenchmarkTest00081")) {
                    param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");


AtomicInteger counter = new AtomicInteger(0);
String stringCopy = param;

if (counter.get() == 0) {
  param = "";
}

Thread thread1 = new Thread(() -> counter.incrementAndGet());

thread1.start();

Thread thread2 = new Thread(() -> counter.incrementAndGet());

thread2.start();

try {
  thread1.join();
} catch (InterruptedException e) {
}
try {
  thread2.join();
} catch (InterruptedException e) {
}

if (counter.get() == 2) {
  param = stringCopy;
}


break;
                }

File f = new File(param);

}
        }

        String bar = org.springframework.web.util.HtmlUtils.htmlEscape(param);

        double stuff = new java.util.Random().nextGaussian();
        String rememberMeKey = Double.toString(stuff).substring(2); // Trim off the 0. at the front.

        String user = "Gayle";
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
        } else {
            javax.servlet.http.Cookie rememberMe =
                    new javax.servlet.http.Cookie(cookieName, rememberMeKey);
            rememberMe.setSecure(true);
            rememberMe.setHttpOnly(true);
            rememberMe.setPath(request.getRequestURI()); // i.e., set path to JUST this servlet
            // e.g., /benchmark/sql-01/BenchmarkTest01001
            request.getSession().setAttribute(cookieName, rememberMeKey);

File f = new File(request.getContextPath());

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

        response.getWriter()
                .println("Weak Randomness Test java.util.Random.nextGaussian() executed");
    }
}
