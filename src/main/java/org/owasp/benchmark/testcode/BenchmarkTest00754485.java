// CodeQL original results: [501]
// Insider original results: []
// Semgrep original results: []
// SonarQube original results: []
// CodeQL analysis results: [79, 501]
// Semgrep analysis results: [200, 501, 79]
// Insider analysis results: []
// SonarQube analysis results: []
// Original file name: BenchmarkTest00754.java
// Original file CWE's: [501]
// Mutation info: Insert template from templates/collections/streams.tmt with index 12
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
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-00/BenchmarkTest00754")
public class BenchmarkTest00754485 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00754");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = "safe!";
        java.util.HashMap<String, Object> map6425 = new java.util.HashMap<String, Object>();
        map6425.put("keyA-6425", "a-Value"); // put some stuff in the collection
        map6425.put("keyB-6425", param); // put it in a collection
        map6425.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map6425.get("keyB-6425"); // get it back out
        List<String> list787234 = new ArrayList<String>();
        list787234.add(response.getHeader(bar));
        list787234.add("");
        Optional<String> anyElement = list787234.stream().findAny();
        if (anyElement.isPresent() && anyElement.get().equals("")) {
            bar = response.encodeRedirectUrl(param);
        }
        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    }
}
