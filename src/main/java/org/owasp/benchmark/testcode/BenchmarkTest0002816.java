// CodeQL original results: [22]
// Snyk original results: [22]
// Semgrep original results: [22]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 22, 73, 36, 23, 79]
// ApplicationInspector analysis results: [73, 79]
// Snyk analysis results: []
// Semgrep analysis results: [22]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00028.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/pm.tmt with name
// pattern_matching_simple_1_positive
// Used extensions: MACRO_VarName -> sealed09823 | MACRO_VarName -> obj21341 | MACRO_VarName ->
// obj39745
// Program:
/**
 * OWASP Benchmark v1.2
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
 * @author Dave Wichers
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

@WebServlet(value = "/pathtraver-00/BenchmarkTest00028")
public class BenchmarkTest0002816 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    SuperClass obj39745 = new SubClass();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // some code
        response.setContentType("text/html;charset=UTF-8");

        Object sealed09823 = new SealedSuper();

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest00028");
            if (values != null) param = values[0];
        }

        String fileName = null;
        java.io.FileOutputStream fos = null;

        param = simplePatternMatchingString1(param);

        try {
            fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + param;

            Object obj21341 = new ImplementingSuperClass();

            fos = new java.io.FileOutputStream(fileName, false);
            response.getWriter()
                    .println(
                            "Now ready to write to file: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName));

        } catch (Exception e) {
            System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
            //			System.out.println("File exception caught and swallowed: " + e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (Exception e) {
                    // we tried...
                }
            }
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
