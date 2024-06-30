// CodeQL original results: [78]
// Insider original results: [78]
// Semgrep original results: []
// SonarQube original results: []
// Insider analysis results: [78, 532]
// CodeQL analysis results: [209, 497, 88, 78, 454]
// Semgrep analysis results: [78]
// SonarQube analysis results: []
// Original file name: BenchmarkTest00740.java
// Original file CWE's: [78]
// Mutation info: Insert template from templates/inheritance/raw.tmt with index 0
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00740")
public class BenchmarkTest00740321 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00740");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";
        List<String> stringList = new ArrayList<>();
        stringList.add(param);

        if (stringList instanceof ArrayList) {
            ArrayList rawListCast = (ArrayList) stringList;
            for (Object obj : rawListCast) {
                param = (String) obj;
            }
        }
        String bar = "safe!";
        java.util.HashMap<String, Object> map87432 = new java.util.HashMap<String, Object>();
        map87432.put("keyA-87432", "a-Value"); // put some stuff in the collection
        map87432.put("keyB-87432", param); // put it in a collection
        map87432.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map87432.get("keyB-87432"); // get it back out

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());
        String[] args = {cmd};
        String[] argsEnv = {bar};

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args, argsEnv);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
