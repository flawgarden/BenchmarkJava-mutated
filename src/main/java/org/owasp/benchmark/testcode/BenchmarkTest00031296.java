// CodeQL original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// SonarQube original results: []
// Semgrep analysis results: [501, 79]
// Insider analysis results: []
// CodeQL analysis results: []
// SonarQube analysis results: []
// Original file name: BenchmarkTest00031.java
// Original file CWE's: [501]
// Mutation info: Insert template from templates/classes/interface.tmt with index 0
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
import org.owasp.benchmark.helpers._Fuzz_Class1;
import org.owasp.benchmark.helpers._Fuzz_Interface;

@WebServlet(value = "/trustbound-00/BenchmarkTest00031")
public class BenchmarkTest00031296 extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest00031");
            if (values != null) param = values[0];
            _Fuzz_Interface<String> dc = new _Fuzz_Class1<String>();
            param = dc.Call(response.getHeader(param), response.getHeader(param));
        }

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", param);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(param)
                                + "' saved in session.");
    }
}
