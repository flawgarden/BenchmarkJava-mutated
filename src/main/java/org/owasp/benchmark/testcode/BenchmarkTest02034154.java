// CodeQL original results: [22]
// Snyk original results: [22]
// Semgrep original results: [22]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [404, 772, 571, 570, 561, 23, 73, 36, 22, 79]
// ApplicationInspector analysis results: [73, 79]
// Snyk analysis results: []
// Semgrep analysis results: [22]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02034.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/pm.tmt with name
// pattern_matching_simple_4_positive
// Used extensions: MACRO_VarName -> obj09823
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

@WebServlet(value = "/pathtraver-02/BenchmarkTest02034")
public class BenchmarkTest02034154 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    BinaryOpInterface val89458 = (t, u) -> "";

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest02034");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element

            param = simplePatternMatchingString2(param);
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike
        // req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        String fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;

        try (
        // Create the file first so the test won't throw an exception if it doesn't
        // exist.
        // Note: Don't actually do this because this method signature could cause a tool
        // to find
        // THIS file constructor
        // as a vuln, rather than the File signature we are trying to actually test.
        // If necessary, just run the benchmark twice. The 1st run should create all the
        // necessary
        // files.
        // new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR +
        // bar).createNewFile();

        java.io.FileOutputStream fos =
                new java.io.FileOutputStream(new java.io.FileInputStream(fileName).getFD()); ) {
            response.getWriter()
                    .println(
                            "Now ready to write to file: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName));

        } catch (Exception e) {

            Object obj09823 = new ImplementingSubClass();

            System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar;

        // Simple if statement that assigns param to bar on true condition
        int num = 196;
        if ((500 / 42) + num > 200) bar = param;
        else bar = "This should never happen";

        return bar;
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
