// CodeQL original results: [78]
// ApplicationInspector original results: [78]
// Snyk original results: [78]
// Semgrep original results: [78]
// Insider original results: [78]
// -------------
// CodeQL analysis results: [561, 497, 209, 78, 88]
// ApplicationInspector analysis results: [497]
// Snyk analysis results: []
// Semgrep analysis results: []
// Insider analysis results: [78, 532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00176.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/assignment.tmt with
// name assignment_negative
// Used extensions:
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00176")
public class BenchmarkTest00176163 extends HttpServlet {

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
        if (request.getHeader("BenchmarkTest00176") != null) {
            param = request.getHeader("BenchmarkTest00176");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().

        String tmpUnique42 = "";
        param = java.net.URLDecoder.decode(param, "UTF-8");

        UnaryOpInterface val89458 =
                new UnaryOpInterface() {
                    @Override
                    public String InterfaceCall(String t) {
                        return "";
                    }
                };

        param = tmpUnique42;

        String bar = param;

        String cmd = "";
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        }

        String[] argsEnv = {"Foo=bar"};
        Runtime r = Runtime.getRuntime();

        try {
            Process p =
                    r.exec(cmd + bar, argsEnv, new java.io.File(System.getProperty("user.dir")));
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
