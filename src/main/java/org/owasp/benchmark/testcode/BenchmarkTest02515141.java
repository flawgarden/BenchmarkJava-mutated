// CodeQL original results: [78]
// ApplicationInspector original results: [78]
// Snyk original results: [78]
// Semgrep original results: [78]
// Insider original results: [78]
// -------------
// CodeQL analysis results: [561, 497, 209]
// ApplicationInspector analysis results: [22]
// Snyk analysis results: []
// Semgrep analysis results: [22, 78]
// Insider analysis results: [78, 532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02515.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/virtuality/interface.tmt with name
// base_binary_op_interface_negative
// Used extensions: MACRO_VarName -> sealed09823
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-02/BenchmarkTest02515")
public class BenchmarkTest02515141 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest02515");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = doSomething(request, param);

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());

        String[] argsEnv = {bar};

        File f = new File(param.toLowerCase());

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(cmd, argsEnv);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        Object sealed09823 = new PermittedSub2();

        BinaryOpInterface a12341 =
                (request.isRequestedSessionIdFromURL() == request.isRequestedSessionIdValid())
                        ? new ImplBinaryOpInterfaceClass1()
                        : new ImplBinaryOpInterfaceClass2();
        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();

        param = a12341.InterfaceCall("", "");
        String bar = thing.doSomething(param);

        return bar;
    }
}
