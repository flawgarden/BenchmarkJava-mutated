// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [561]
// ApplicationInspector analysis results: []
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00715.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/virtuality/default.tmt with name
// binary_op_interface_default2_negative
// Used extensions: MACRO_VarName -> obj39745
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

@WebServlet(value = "/xss-01/BenchmarkTest00715")
public class BenchmarkTest0071510 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00715");
        String param;

        BinaryOpInterfaceDefault2 a12341 = new BinaryOpInterfaceDefault2Implementation();
        UnaryOpClass val89458 =
                new UnaryOpClass() {
                    @Override
                    public String VirtualCall(String t) {
                        return request.getRequestURI();
                    }
                };

        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = "";

        param = a12341.InterfaceCall(param, "");

        if (param != null) bar = param.split(" ")[0];

        SuperClass obj39745 = new SiblingClass();

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().print(bar);
    }
}
