// CodeQL original results: [22]
// Semgrep original results: [22]
// Insider original results: []
// Semgrep analysis results: [200, 22]
// CodeQL analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest00262.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates/classes/interface.tmt with index 2
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
import org.owasp.benchmark.helpers._Fuzz_Class1;
import org.owasp.benchmark.helpers._Fuzz_Class2;
import org.owasp.benchmark.helpers._Fuzz_Interface;

@WebServlet(value = "/pathtraver-00/BenchmarkTest00262")
public class BenchmarkTest00262944 extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00262");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        _Fuzz_Interface<String> dc = null;
        if (!param.equals(response.encodeURL(param)) || 0.39862216F > 0.20070717F) {
            dc = new _Fuzz_Class2<String>();
        } else {
            dc = new _Fuzz_Class1<String>();
        }
        param = dc.Call(response.encodeURL(param), response.encodeURL(param));
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar;
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

        java.io.File fileTarget = new java.io.File(bar);
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
