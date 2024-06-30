// CodeQL original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// SonarQube original results: []
// CodeQL analysis results: [571, 570]
// Semgrep analysis results: [200, 79]
// Insider analysis results: []
// SonarQube analysis results: []
// Original file name: BenchmarkTest00276
// Original file CWE's: [79]
// Mutation info: Insert template from templates/primitive/simple.tmt with index 0 -> Insert
// template from templates/cycles/for.tmt with index 6
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

@WebServlet(value = "/xss-00/BenchmarkTest00276230")
public class BenchmarkTest00276230 extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("Referer");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }
        param = String.valueOf(response.encodeRedirectURL(param));
        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar;

        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < bar.lastIndexOf(num); j++) {
                if (i == param.codePointBefore(num) && j == request.getIntHeader(bar)) {
                    param = param.valueOf(num);
                }
            }
        }
        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().print(bar);
    }
}
