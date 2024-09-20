// Snyk original results: [79]
// Semgrep original results: [79]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// ApplicationInspector analysis results: []
// Snyk analysis results: [79, 134]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00473.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/conditional/switch.tmt with name
// switch_operator_any_negative
// Used extensions: MACRO_VarName -> obj39745 | MACRO_Any_String -> ~[VAR_String]~
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

@WebServlet(value = "/xss-00/BenchmarkTest00473")
public class BenchmarkTest0047359 extends HttpServlet {

    SuperClass obj39745 = new SiblingClass();

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

            String tmpUnique42 = "";
            String[] values = map.get("BenchmarkTest00473");
            if (values != null) param = values[0];

            switch (param) {
                case "iaybg":
                    param = "";
                    break;
                default:
                    param = tmpUnique42;
            }
        }

        String bar = "";
        if (param != null) {
            bar =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            param.getBytes())));
        }

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", "b"};
        response.getWriter().printf(bar, obj);
    }
}