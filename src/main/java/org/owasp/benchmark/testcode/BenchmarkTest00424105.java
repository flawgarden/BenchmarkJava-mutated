// CodeQL original results: [501]
// Snyk original results: [501]
// Semgrep original results: [501]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561]
// ApplicationInspector analysis results: []
// Snyk analysis results: [501]
// Semgrep analysis results: [200, 501, 79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00424.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/map.tmt
// with name map_simple_get_1_negative
// Used extensions: MACRO_VarName -> sealed39745 | MACRO_VarName -> obj21341 | MACRO_Create_Map ->
// Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName]~ = new TreeMap<>(); | MACRO_MapName -> map787234 |
// MACRO_MapName -> map787234 | MACRO_MapName -> map787234
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

@WebServlet(value = "/trustbound-00/BenchmarkTest00424")
public class BenchmarkTest00424105 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest00424");
        if (param == null) param = "";

        Map<String, String> map787234 = new TreeMap<>();
        map787234.put(response.encodeRedirectURL(param), "mpego");
        param = map787234.get(response.encodeRedirectURL(param));

        String bar = "";
        if (param != null) {
            bar =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            param.getBytes())));
        }

        SuperClass obj21341 = new SubClass();

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");

        Object sealed39745 = new PermittedSub2();
    }
}
