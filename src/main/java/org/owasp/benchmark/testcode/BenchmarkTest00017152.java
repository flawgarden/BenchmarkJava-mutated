// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00017.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/injection/injection.tmt with name
// const_dependency_injection_positive
// Used extensions: MACRO_Create_Set -> Set<~[TYPE@1]~> ~[MACRO_SetName@1]~ = new LinkedHashSet<>();
// | MACRO_Add_Element_ToSet -> ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~]~); |
// MACRO_Add_Fixed_Element_ToSet -> ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_SetName@1
// -> set787231 | MACRO_VarName -> genericClass39745 | EXPR_String -> ""
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00017")
public class BenchmarkTest00017152 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

        GenericClass<String> genericClass39745 = new GenericClass<String>("ubnhf");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // some code
        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00017");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element

            ServiceI s2 = new ServiceConst("");
            ConsumerInterface c2 = new ConsumerInterface(s2);
            param = c2.getFieldValue();

            File f = new File(param);
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String cmd = "";
        String osName = System.getProperty("os.name");

        Set<String> set787231 = new LinkedHashSet<>();
        set787231.add(param);
        set787231.add(param);
        set787231.remove(param);
        String value7843 = set787231.iterator().next();

        if (osName.indexOf("Windows") != -1) {
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        }

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(cmd + param);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
