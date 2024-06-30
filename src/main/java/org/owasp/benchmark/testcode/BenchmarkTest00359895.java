// CodeQL original results: [22]
// Semgrep original results: [22]
// Insider original results: []
// CodeQL analysis results: [570, 571]
// Semgrep analysis results: [200, 22]
// Insider analysis results: []
// Original file name: BenchmarkTest00359.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates/inheritance/sealed.tmt with index 0
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
import org.owasp.benchmark.helpers.inheritance.*;

@WebServlet(value = "/pathtraver-00/BenchmarkTest00359")
public class BenchmarkTest00359895 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest00359");
        if (param == null) param = "";

        String bar;

        // Simple if statement that assigns param to bar on true condition
        int num = 196;
        if ((500 / 42) + num > 200) bar = param;

        SealedSuper obj = new SealedSuper();
        String paramModified = handleSealedSuper(obj, param);
        if (paramModified.equals(param)) {
            bar = paramModified;
        } else bar = "This should never happen";

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

    public String handleSealedSuper(SealedSuper superClassObj, String param) {
        if (superClassObj instanceof PermittedSub1 permittedSubObj1) {
            return (String) permittedSubObj1.subMethod1(param);
        } else if (superClassObj instanceof PermittedSub2 permittedSubObj2) {
            return (String) permittedSubObj2.subMethod2(param);
        } else if (!(superClassObj instanceof SealedSuper)) {
            return "";
        } else {
            return (String) superClassObj.sealedMethod(param);
        }
    }
}
