// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00302.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/switch.tmt with name switch_operator_any_negative
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new ArrayList<>(); | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[EXPR_~[TYPE@1]~]~); | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Create_Stream -> Stream<~[TYPE@1]~> ~[MACRO_StreamName@1]~ = ~[MACRO_ListName@1]~.stream(); | MACRO_StreamName@1 -> stream787231 | MACRO_ListName@1 -> list787234 | MACRO_Any_String -> ~[EXPR_String]~
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
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-00/BenchmarkTest00302")
public class BenchmarkTest0030215 extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00302");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar;

        String tmpUnique42 = "";
        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;

        switch (bar) {
            case "bbcrm":
                bar = "";
                break;
            default:
                bar = tmpUnique42;
        }

        String cmd = "";
        String osName = System.getProperty("os.name");

        List<String> list787234 = new ArrayList<>();
        list787234.add(cmd);
        list787234.add(request.getRequestURI());
        list787234.add(osName);
        Stream<String> stream787231 = list787234.stream();
        String value7844 = stream787231.reduce((entry1, entry2) -> entry1 + entry2).get();

        if (osName.indexOf("Windows") != -1) {
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
        }

        UnaryOpInterface val89458 =
                new UnaryOpInterface() {
                    @Override
                    public String InterfaceCall(String t) {
                        return response.encodeRedirectUrl(osName);
                    }
                };

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
