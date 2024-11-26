// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00302.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/field/constructors.tmt with name class_with_string_initialization_positive
// Used extensions: MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName@1]~ = new HashMap<>(); | MACRO_Add_Element_ToMap -> ~[MACRO_MapName@1]~.put(~[VAR_~[TYPE@1]~]~, ~[VAR_~[TYPE@2]~]~); | MACRO_MapName@1 -> map787232
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00302")
public class BenchmarkTest0030224 extends HttpServlet {

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

        StringHolder sh = new StringHolder(param);
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00302");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        param = sh.value;

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar;

        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;

        String cmd = "";
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        }

        Map<String, String> map787232 = new HashMap<>();
        map787232.put(bar, param);
        map787232.put(bar.repeat(num), bar);
        String value78410 =
                map787232.entrySet().stream()
                        .filter(entry -> entry.equals("ylqry"))
                        .findFirst()
                        .get()
                        .getValue();

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(cmd + bar);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
