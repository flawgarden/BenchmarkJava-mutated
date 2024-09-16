// CodeQL original results: [501]
// Snyk original results: [501]
// ApplicationInspector original results: []
// Semgrep original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [476, 561]
// ApplicationInspector analysis results: [79]
// Snyk analysis results: [501]
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01955.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/exceptions/tryCatchFinally.tmt with name
// try_multi_cath_positive
// Used extensions: MACRO_VarName -> obj39745 | MACRO_Regex -> (~[MACRO_Regex]~ + "??") |
// MACRO_Regex -> (~[MACRO_Regex]~ + "*") | MACRO_Regex -> "\0nn" | MACRO_VarName -> sealed21341
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-01/BenchmarkTest01955")
public class BenchmarkTest01955170 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pattern pattern = Pattern.compile((("\0nn" + "*") + "??"));
        Matcher matcher = pattern.matcher("ddhsc");

        doPost(request, response);

        Object sealed21341 = new SealedSuper();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object obj39745 = new ImplementingSubClass();

        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        if (request.getHeader("BenchmarkTest01955") != null) {
            param = request.getHeader("BenchmarkTest01955");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
        request.getSession().putValue(bar, "10340");

        response.getWriter()
                .println(
                        "Item: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' with value: 10340 saved in session.");
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "";

        String tmpUnique42 = bar;
        if (param != null) {
            bar =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            param.getBytes())));
        }

        try {
            if (!param.concat(param).equals(param)) {
                throw new Exception1(request.getMethod());
            } else {
                throw new Exception2(bar.trim());
            }
        } catch (Exception1 | Exception2 e) {
            bar = tmpUnique42;
        }
        return bar;
    }
}
