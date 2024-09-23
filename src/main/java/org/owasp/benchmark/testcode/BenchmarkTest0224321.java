// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02243.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/while.tmt
// with name while_operator_positive
// Used extensions: MACRO_Create_Queue -> Queue<~[TYPE@1]~> ~[MACRO_QueueName@1]~ = new
// PriorityQueue<>(); | MACRO_Add_Element_ToQueue -> ~[MACRO_QueueName@1]~.add(~[EXPR_~[TYPE@1]~]~);
// | MACRO_Add_Element_ToQueue -> ~[MACRO_QueueName@1]~.offer(~[EXPR_~[TYPE@1]~]~); |
// MACRO_Add_Fixed_Element_ToQueue -> ~[MACRO_QueueName@1]~.add(~[VAR_~[TYPE@1]~@1]~); |
// MACRO_QueueName@1 -> queue787231 | MACRO_VarName -> obj12321 | MACRO_VarName -> obj09823
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
import java.util.concurrent.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-02/BenchmarkTest02243")
public class BenchmarkTest0224321 extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest02243");
            if (values != null) param = values[0];

            Queue<String> queue787231 = new PriorityQueue<>();
            queue787231.add(param);
            queue787231.offer(request.getServletPath());
            queue787231.add(param);
            String value7847 = "roecv";
            while (!queue787231.isEmpty()) {
                value7847 = queue787231.poll();
            }
        }

        String bar = doSomething(request, param);

        java.util.List<String> argList = new java.util.ArrayList<String>();

        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {

            SuperClass obj09823 = new SubClass();

            argList.add("cmd.exe");
            argList.add("/c");
        } else {
            argList.add("sh");
            argList.add("-c");
        }
        argList.add("echo " + bar);

        ProcessBuilder pb = new ProcessBuilder(argList);

        try {
            Process p = pb.start();
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println(
                    "Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
            throw new ServletException(e);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "safe!";
        java.util.HashMap<String, Object> map19941 = new java.util.HashMap<String, Object>();

        String tmpUnique42 = param;
        map19941.put("keyA-19941", "a-Value"); // put some stuff in the collection
        map19941.put("keyB-19941", param); // put it in a collection
        map19941.put("keyC", "another-Value"); // put some stuff in the collection

        while (param == bar || 85 != 58) {
            param = tmpUnique42;
        }

        SuperClass obj12321 = new SuperClass();

        bar = (String) map19941.get("keyB-19941"); // get it back out

        return bar;
    }
}
