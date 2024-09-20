// CodeQL original results: [78]
// ApplicationInspector original results: [78]
// Snyk original results: [78]
// Semgrep original results: [78]
// Insider original results: [78]
// -------------
// CodeQL analysis results: [391, 561, 497, 209, 454, 78, 88]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: []
// Insider analysis results: [78, 532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00573.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt
// with name simple_poll_negative
// Used extensions: MACRO_VarName -> sealed09823 | MACRO_VarName -> sealed21341 | MACRO_Create_Queue
// -> Queue<~[TYPE@1]~> ~[MACRO_QueueName]~ = new PriorityQueue<>(); | MACRO_Add_EXPR_ToQueue ->
// ~[MACRO_QueueName]~.offer(~[EXPR_~[TYPE@1]~]~); | MACRO_QueueName -> queue787231 |
// MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | EXPR_String ->
// ~[EXPR_String]~.replaceAll(~[MACRO_Regex]~, ~[EXPR_String]~) | MACRO_Regex -> "\\"
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
import java.util.concurrent.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-00/BenchmarkTest00573")
public class BenchmarkTest0057315 extends HttpServlet {

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
        boolean flag = true;
        java.util.Enumeration<String> names = request.getParameterNames();

        Object sealed09823 = new SealedSuper();

        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest00573")) {
                        param = name;

                        Queue<String> queue787231 = new PriorityQueue<>();
                        queue787231.offer(
                                param.concat(value).replaceAll("\\", param.toLowerCase()));
                        param = queue787231.poll();

                        flag = false;
                    }
                }
            }
        }

        String bar = param;

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());

        String[] argsEnv = {bar};
        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(cmd, argsEnv);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));

            Object sealed21341 = new PermittedSub1();

            return;
        }
    }
}