// CodeQL original results: [22]
// Semgrep original results: [22]
// Insider original results: []
// Semgrep analysis results: [22]
// CodeQL analysis results: []
// Insider analysis results: []
// Original file name: BenchmarkTest00040.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates/inheritance/classes.tmt with index 4
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
import org.owasp.benchmark.helpers.inheritance.*;

@WebServlet(value = "/pathtraver-00/BenchmarkTest00040")
public class BenchmarkTest00040916 extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest00040");

        SuperClass obj = new SubClass();
        obj.setSuperField("");
        param = handleSuperClass(obj);
        if (param == null) param = "";

        java.io.File fileTarget = new java.io.File(param);
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

    public String handleSuperClass(SuperClass superClassObj) {
        if (superClassObj instanceof SiblingClass siblingClassObj) {
            return siblingClassObj.superMethod();
        } else if (superClassObj instanceof SubClass subClassObj) {
            return subClassObj.superMethod();
        } else {
            return "";
        }
    }
}
