// CodeQL original results: [22]
// Semgrep original results: [22]
// Insider original results: []
// SonarQube original results: []
// CodeQL analysis results: [570, 571, 561]
// Semgrep analysis results: [200, 22]
// Insider analysis results: []
// SonarQube analysis results: []
// Original file name: BenchmarkTest01235.java
// Original file CWE's: [22]
// Mutation info: Insert template from templates/classes/class.tmt with index 3
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
import org.owasp.benchmark.helpers._Fuzz_BaseClass;
import org.owasp.benchmark.helpers._Fuzz_DerivedClass1;
import org.owasp.benchmark.helpers._Fuzz_DerivedClass2;

@WebServlet(value = "/pathtraver-01/BenchmarkTest01235")
public class BenchmarkTest01235293 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest01235");
        if (param == null) param = "";

        String bar = new Test293().doSomething(request, param);

        // FILE URIs are tricky because they are different between Mac and Windows because of lack
        // of standardization.
        _Fuzz_BaseClass<String> dc = null;
        if (16441 <= 7309 || !bar.intern().equals(response.encodeURL(param))) {
            dc = new _Fuzz_DerivedClass2<String>();
        } else {
            dc = new _Fuzz_DerivedClass1<String>();
        }
        bar = dc.VirtualCall(bar, "");
        // Mac requires an extra slash for some reason.
        String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
            if (System.getProperty("os.name").indexOf("Windows") != -1) startURIslashes = "/";
            else startURIslashes = "//";

        try {
            java.net.URI fileURI =
                    new java.net.URI(
                            "file:"
                                    + startURIslashes
                                    + org.owasp.benchmark.helpers.Utils.TESTFILES_DIR
                                            .replace('\\', '/')
                                            .replace(' ', '_')
                                    + bar);
            java.io.File fileTarget = new java.io.File(fileURI);
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
        } catch (java.net.URISyntaxException e) {
            throw new ServletException(e);
        }
    } // end doPost

    private class Test293 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "safe!";
            java.util.HashMap<String, Object> map13886 = new java.util.HashMap<String, Object>();
            map13886.put("keyA-13886", "a-Value"); // put some stuff in the collection
            map13886.put("keyB-13886", param); // put it in a collection
            map13886.put("keyC", "another-Value"); // put some stuff in the collection
            bar = (String) map13886.get("keyB-13886"); // get it back out

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
