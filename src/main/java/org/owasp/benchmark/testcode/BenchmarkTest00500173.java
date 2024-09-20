// CodeQL original results: [78]
// ApplicationInspector original results: [78]
// Snyk original results: [78]
// Semgrep original results: [78]
// Insider original results: [78]
// -------------
// CodeQL analysis results: [571, 570, 561, 497, 209, 88, 78]
// ApplicationInspector analysis results: [497]
// Snyk analysis results: []
// Semgrep analysis results: []
// Insider analysis results: [78, 532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00500.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/pm.tmt with name
// pattern_matching_simple_2_negative
// Used extensions: MACRO_VarName -> sealed39745 | MACRO_VarName -> genericClass39745 |
// MACRO_VarName -> genericClass12321
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00500")
public class BenchmarkTest00500173 extends HttpServlet {

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
            String[] values = map.get("BenchmarkTest00500");
            if (values != null) param = values[0];
        }

        String bar;

        // Simple if statement that assigns param to bar on true condition
        int num = 196;

        Object sealed39745 = new PermittedSub1();

        if ((500 / 42) + num > 200) bar = param;
        else bar = "This should never happen";

        String cmd = "";
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        }

        String[] argsEnv = {"Foo=bar"};

        GenericClass<String> genericClass39745 = new GenericClass<String>(sealed39745.toString());

        Runtime r = Runtime.getRuntime();

        try {

            bar = simplePatternMatchingString1(num);

            Process p =
                    r.exec(cmd + bar, argsEnv, new java.io.File(System.getProperty("user.dir")));
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {

            GenericClass<Double> genericClass12321 = new GenericClass<Double>(0.3270585624609684);

            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }

    public String simplePatternMatchingString1(Object obj) {
        if (obj instanceof String str) {
            return str.toUpperCase();
        }
        return "";
    }

    public String simplePatternMatchingString2(Object obj) {
        if (obj instanceof String str && str.length() > 5) {
            return str.toUpperCase();
        }
        return "";
    }
}