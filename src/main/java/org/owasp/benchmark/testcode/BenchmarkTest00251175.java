// CodeQL original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// SonarQube original results: []
// Semgrep analysis results: [200, 501, 79]
// Insider analysis results: []
// CodeQL analysis results: []
// SonarQube analysis results: []
// Original file name: BenchmarkTest00251.java
// Original file CWE's: [501]
// Mutation info: Insert template from templates/inheritance/interfaces.tmt with index 5
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

@WebServlet(value = "/trustbound-00/BenchmarkTest00251")
public class BenchmarkTest00251175 extends HttpServlet {

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
        java.util.Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();

            if (org.owasp.benchmark.helpers.Utils.commonHeaders.contains(name)) {
                continue; // If standard header, move on to next one
            }

            java.util.Enumeration<String> values = request.getHeaders(name);
            if (values != null && values.hasMoreElements()) {
                param = name; // Grabs the name of the first non-standard header as the parameter

                ImplementingSuperSideClass obj = new ImplementingSuperSideClass();
                param = handleSuperInterface(obj, response.encodeRedirectUrl(name));
                // value
                break;
            }
        }
        // Note: We don't URL decode header names because people don't normally do that

        String bar = "";
        if (param != null) bar = param.split(" ")[0];

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    }

    public String handleSuperInterface(SuperInterface superInterfaceObj, String param) {
        if (superInterfaceObj instanceof SubInterface subInterfaceObj) {
            return subInterfaceObj.superInterfaceMethod("");
        } else if (superInterfaceObj instanceof SideInterface sideInterfaceObj) {
            return sideInterfaceObj.sideInterfaceMethod(param);
        } else {
            return "";
        }
    }
}
