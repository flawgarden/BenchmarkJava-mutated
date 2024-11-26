// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00007.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/virtuality/default.tmt with name binary_op_interface_default_negative
// Used extensions:
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-00/BenchmarkTest00007")
public class BenchmarkTest00007141 extends HttpServlet {

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

        String param = "";
        if (request.getHeader("BenchmarkTest00007") != null) {
            param = request.getHeader("BenchmarkTest00007");
        }

        BinaryOpInterfaceDefault a12341 = new BinaryOpInterfaceDefaultImplementation();
        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        SimpleRecord record = new SimpleRecord(param.valueOf(serialVersionUID));

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());
        String[] args = {cmd};

        param = a12341.InterfaceCall(param, param);

        String[] argsEnv = {param};

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args, argsEnv);

            File f = new File(param);

            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
