// CodeQL original results: [78]
// ApplicationInspector original results: [78]
// Snyk original results: [78]
// Semgrep original results: [78]
// Insider original results: [78]
// -------------
// CodeQL analysis results: [391, 561, 209, 497]
// ApplicationInspector analysis results: [497]
// Snyk analysis results: []
// Semgrep analysis results: [78]
// Insider analysis results: [78, 532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01441.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/virtuality/interface.tmt with name
// impl_binary_op_interface_class1_negative
// Used extensions: MACRO_Create_Queue -> Queue<~[TYPE@1]~> ~[MACRO_QueueName@1]~ = new
// PriorityQueue<>(); | MACRO_Add_Element_ToQueue ->
// ~[MACRO_QueueName@1]~.offer(~[EXPR_~[TYPE@1]~]~); | MACRO_Add_Fixed_Element_ToQueue ->
// ~[MACRO_QueueName@1]~.offer(~[VAR_~[TYPE@1]~@1]~); | MACRO_QueueName@1 -> queue787231
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
 * @author Dave Wichers
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

@WebServlet(value = "/cmdi-01/BenchmarkTest01441")
public class BenchmarkTest01441112 extends HttpServlet {

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
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest01441")) {
                        param = name;
                        flag = false;

                        Queue<String> queue787231 = new PriorityQueue<>();
                        queue787231.offer(request.getServletPath());
                        queue787231.offer(name);
                        String value7846 = "utvmo";

                        if (queue787231.contains(param)) {
                            value7846 = name;
                        }
                    }
                }
            }
        }

        String bar = new Test112().doSomething(request, param);

        String cmd = "";
        String a1 = "";
        String a2 = "";
        String[] args = null;
        String osName = System.getProperty("os.name");

        if (osName.indexOf("Windows") != -1) {
            a1 = "cmd.exe";
            a2 = "/c";
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("echo");
            args = new String[] {a1, a2, cmd, bar};
        } else {
            a1 = "sh";
            a2 = "-c";
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("ping -c1 ");
            args = new String[] {a1, a2, cmd + bar};
        }

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    } // end doPost

    private class Test112 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            BinaryOpInterface a12341 = new ImplBinaryOpInterfaceClass1();
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();

            param = a12341.InterfaceCall("", param);
            String bar = thing.doSomething(param);

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass