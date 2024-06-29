// CodeQL original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// SonarQube original results: []
// CodeQL analysis results: [571, 570, 79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest00475.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/collections/list.tmt with index 7
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

@WebServlet(value = "/xss-00/BenchmarkTest00475")
public class BenchmarkTest00475882 extends HttpServlet {

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
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest00475");
            if (values != null) param = values[0];
        }

        String bar = "";

        // Simple if statement that assigns param to bar on true condition
        int num = 196;
        if ((500 / 42) + num > 200) bar = param;
        List<String> list787234 = new ArrayList<String>();
        list787234.add(request.getHeader(param));
        list787234.add("");
        Collections.sort(list787234);
        if (list787234.get(0).equals("")) {
            bar = bar;
        } else bar = "This should never happen";

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().println(bar);
    }
}
