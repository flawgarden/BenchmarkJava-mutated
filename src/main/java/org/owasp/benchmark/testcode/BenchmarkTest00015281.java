// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00015.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/field/constructors.tmt with name
// class_with_instance_initializer_negative
// Used extensions: MACRO_Regex -> (~[MACRO_Regex]~ + "{5}") | EXPR_String -> "" | MACRO_Regex ->
// (~[MACRO_Regex]~ + "??") | MACRO_Regex -> (~[MACRO_Regex]~ + "*") | MACRO_Regex ->
// "[a-z&&[^m-p]]" | EXPR_String -> "" | MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~>
// ~[MACRO_MapName@1]~ = new HashMap<>(); | MACRO_MapName@1 -> map787232
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-00/BenchmarkTest00015")
public class BenchmarkTest0001528 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Pattern pattern = Pattern.compile(((("[a-z&&[^m-p]]" + "*") + "??") + "{5}"));
    Matcher matcher = pattern.matcher("");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // some code

        UnaryOpInterface val89458 =
                new UnaryOpInterface() {
                    @Override
                    public String InterfaceCall(String t) {
                        return "";
                    }
                };

        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00015");

        InstanceInitializer ii = new InstanceInitializer(param);
        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        param = ii.list.get(0);
        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        java.util.List<String> argList = new java.util.ArrayList<String>();

        Map<String, String> map787232 = new HashMap<>();
        map787232.put(response.getHeader(param), param);
        String value7841 = map787232.get(response.getHeader(param));

        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
            argList.add("cmd.exe");
            argList.add("/c");
        } else {
            argList.add("sh");
            argList.add("-c");
        }
        argList.add("echo " + param);

        ProcessBuilder pb = new ProcessBuilder();

        pb.command(argList);

        try {
            Process p = pb.start();
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println(
                    "Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
            throw new ServletException(e);
        }
    }
}
