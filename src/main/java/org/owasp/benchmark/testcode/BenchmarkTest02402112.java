// CodeQL original results: [79]
// Insider original results: []
// Semgrep original results: []
// SonarQube original results: []
// CodeQL analysis results: [561, 79, 134]
// Semgrep analysis results: [79]
// SonarQube analysis results: [400, 1333]
// Insider analysis results: []
// Original file name: BenchmarkTest02402.java
// Original file CWE's: [79]
// Mutation info: Insert template from templates/strings/regex.tmt with index 10
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

@WebServlet(value = "/xss-04/BenchmarkTest02402")
public class BenchmarkTest02402112 extends HttpServlet {

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

        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest02402");
        if (param == null) param = "";

        String bar = doSomething(request, param);
        Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
        Matcher matcher = pattern.matcher("123-456");
        if (matcher.find()) {
            int start = matcher.start(0);
            bar = bar.substring(0, start);
        }
        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", "b"};
        response.getWriter().printf(java.util.Locale.US, bar, obj);
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "safe!";
        java.util.HashMap<String, Object> map55396 = new java.util.HashMap<String, Object>();
        map55396.put("keyA-55396", "a-Value"); // put some stuff in the collection
        map55396.put("keyB-55396", param); // put it in a collection
        map55396.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map55396.get("keyB-55396"); // get it back out

        return bar;
    }
}
