// CodeQL original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// CodeQL analysis results: [79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest00724.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates/generics/wildcard.tmt with index 1
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
import org.owasp.benchmark.helpers.generics.*;

@WebServlet(value = "/xss-01/BenchmarkTest00724")
public class BenchmarkTest00724371 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00724");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar;

        String genericObj = param;
        SimpleGenericClass<String> obj = new SimpleGenericClass<>(genericObj);
        param = (String) handleGenericClassWildcard(obj);
        String guess = "ABC";
        char switchTarget = guess.charAt(2);

        // Simple case statement that assigns param to bar on conditions 'A', 'C', or 'D'
        switch (switchTarget) {
            case 'A':
                bar = param;
                break;
            case 'B':
                bar = "bobs_your_uncle";
                break;
            case 'C':
            case 'D':
                bar = param;
                break;
            default:
                bar = "bobs_your_uncle";
                break;
        }

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().println(bar);
    }

    public Object handleGenericClassWildcard(SimpleGenericClass<?> genericClassObj) {
        if (genericClassObj instanceof SubGenericClass<?>) {
            return "";
        } else {
            return genericClassObj.getValue();
        }
    }
}
