// CodeQL original results: [79]
// Insider original results: []
// Semgrep original results: []
// CodeQL analysis results: [79, 134]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest00467.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/collections/set.tmt with index 4
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

@WebServlet(value = "/xss-00/BenchmarkTest00467")
public class BenchmarkTest0046783 extends HttpServlet {

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
            String[] values = map.get("BenchmarkTest00467");
            if (values != null) param = values[0];
            Set<Integer> a12341 = new HashSet<Integer>();
            a12341.addAll(Arrays.asList(new Integer[] {1, 3, 1}));
            String tmp45745 = param;
            param = param.toLowerCase();
            Set<Integer> a23488 = new HashSet<Integer>();
            a12341.removeAll(a23488);
            if (a12341.isEmpty()) {
                param = tmp45745;
            }
        }

        String bar = "safe!";
        java.util.HashMap<String, Object> map88136 = new java.util.HashMap<String, Object>();
        map88136.put("keyA-88136", "a-Value"); // put some stuff in the collection
        map88136.put("keyB-88136", param); // put it in a collection
        map88136.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map88136.get("keyB-88136"); // get it back out

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", "b"};
        response.getWriter().format(java.util.Locale.US, bar, obj);
    }
}
