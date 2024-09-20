// CodeQL original results: [78]
// ApplicationInspector original results: [78]
// Snyk original results: [78]
// Semgrep original results: [78]
// Insider original results: []
// -------------
// CodeQL analysis results: [561]
// ApplicationInspector analysis results: [497]
// Snyk analysis results: [78]
// Semgrep analysis results: [78]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02059.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/conditional/recursion.tmt with name
// recursion_mutual_negative
// Used extensions: MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName@1]~ = new
// TreeMap<>(); | MACRO_Add_Element_ToMap -> ~[MACRO_MapName@1]~.put(~[VAR_~[TYPE@1]~]~,
// ~[VAR_~[TYPE@2]~]~); | MACRO_MapName@1 -> map787233
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

@WebServlet(value = "/cmdi-02/BenchmarkTest02059")
public class BenchmarkTest02059143 extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest02059");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        String a1 = "";
        String a2 = "";
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
            a1 = "cmd.exe";
            a2 = "/c";
        } else {
            a1 = "sh";

            UnaryOpInterface val89458 = (t) -> "";

            a2 = "-c";
        }

        a1 = paramOrEmptyMutual2(a1.length(), a1);

        String[] args = {a1, a2, "echo " + bar};

        ProcessBuilder pb = new ProcessBuilder(args);

        try {
            Process p = pb.start();
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println(
                    "Problem executing cmdi - java.lang.ProcessBuilder(java.lang.String[]) Test Case");
            throw new ServletException(e);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        Map<String, String> map787233 = new TreeMap<>();
        map787233.put(param, param);
        map787233.put(request.getServletPath(), param);
        String value7847 = map787233.remove(param);

        String bar = "safe!";
        java.util.HashMap<String, Object> map36421 = new java.util.HashMap<String, Object>();
        map36421.put("keyA-36421", "a-Value"); // put some stuff in the collection
        map36421.put("keyB-36421", param); // put it in a collection
        map36421.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map36421.get("keyB-36421"); // get it back out

        return bar;
    }

    public String paramOrEmpty(int value, String param) {
        if (param.length() == value) {
            return param;
        } else if (value > param.length()) {
            paramOrEmpty(--value, param);
        } else {
            return "";
        }
        return "";
    }

    public String paramOrEmptyMutual1(int value, String param) {
        if (param.length() == value) {
            return param;
        } else if (value > param.length()) {
            paramOrEmptyMutual2(value, param);
        } else {
            return "";
        }
        return "";
    }

    public String paramOrEmptyMutual2(int value, String param) {
        return paramOrEmptyMutual1(--value, param);
    }
}