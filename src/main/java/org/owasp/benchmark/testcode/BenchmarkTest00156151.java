// CodeQL original results: [79]
// Snyk original results: [79]
// ApplicationInspector original results: []
// Semgrep original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561]
// ApplicationInspector analysis results: []
// Snyk analysis results: [79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00156.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/exceptions/tryCatchFinally.tmt with name
// try_cath_positive
// Used extensions: MACRO_VarName -> sealed12321 | MACRO_Regex -> "[a-z&&[^m-p]]" | MACRO_VarName ->
// obj21341
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

@WebServlet(value = "/xss-00/BenchmarkTest00156")
public class BenchmarkTest00156151 extends HttpServlet {

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

        String param = "";
        if (request.getHeader("Referer") != null) {
            param = request.getHeader("Referer");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().

        Pattern pattern = Pattern.compile("[a-z&&[^m-p]]");
        Matcher matcher = pattern.matcher(request.getRequestURI());

        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = "";

        String tmpUnique42 = bar;
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("safe");
            valuesList.add(param);
            valuesList.add("moresafe");

            valuesList.remove(0); // remove the 1st safe value

            bar = valuesList.get(0); // get the param value
        }

        response.setHeader("X-XSS-Protection", "0");

        SuperClass obj21341 = new SiblingClass();

        try {
            throw new Exception1(bar.toLowerCase());
        } catch (Exception1 e) {
            bar = tmpUnique42;
        }

        response.getWriter().write(bar.toCharArray());

        Object sealed12321 = new SealedSuper();
    }
}
