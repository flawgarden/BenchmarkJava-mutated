// CodeQL original results: [22]
// Semgrep original results: [22]
// Insider original results: []
// CodeQL analysis results: [570, 571]
// Semgrep analysis results: [22]
// Insider analysis results: []
// Original file name: BenchmarkTest00698.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates/exceptions/two_exceptions.tmt with index 3
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
import org.owasp.benchmark.helpers._Fuzz_Exception1;
import org.owasp.benchmark.helpers._Fuzz_Exception2;

@WebServlet(value = "/pathtraver-00/BenchmarkTest00698")
public class BenchmarkTest00698763 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00698");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        try {
            if (serialVersionUID > -6581896250199196500L && 'u' < 'f') {
                throw new _Fuzz_Exception1(param);
            } else {
                throw new _Fuzz_Exception2(param);
            }
        } catch (_Fuzz_Exception1 | _Fuzz_Exception2 e) {
            param = "";
        } finally {
            param = param;
        }
        String bar = thing.doSomething(param);

        java.io.File fileTarget = new java.io.File(bar, "/Test.txt");
        response.getWriter()
                .println(
                        "Access to file: '"
                                + org.owasp
                                        .esapi
                                        .ESAPI
                                        .encoder()
                                        .encodeForHTML(fileTarget.toString())
                                + "' created.");
        if (fileTarget.exists()) {
            response.getWriter().println(" And file already exists.");
        } else {
            response.getWriter().println(" But file doesn't exist yet.");
        }
    }
}
