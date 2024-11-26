// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00568.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/list.tmt with name list_to_array_and_get_positive
// Used extensions: MACRO_VarName -> sealed12321 | MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new LinkedList<>(); | MACRO_Add_VAR_ToList -> ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00568")
public class BenchmarkTest00568154 extends HttpServlet {

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
                    if (value.equals("BenchmarkTest00568")) {
                        param = name;
                        flag = false;
                    }
                }

                List<String> list787231 = new LinkedList<>();
                list787231.add(param);
                param = (String) list787231.toArray()[0];
            }
        }

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        String cmd = "";
        String a1 = "";
        String a2 = "";
        String[] args = null;
        String osName = System.getProperty("os.name");

        if (osName.indexOf("Windows") != -1) {
            a1 = "cmd.exe";
            a2 = "/c";
            cmd = "echo ";
            args = new String[] {a1, a2, cmd, bar};
        } else {
            a1 = "sh";
            a2 = "-c";
            cmd = org.owasp.benchmark.helpers.Utils.getOSCommandString("ls ");
            args = new String[] {a1, a2, cmd + bar};
        }

        String[] argsEnv = {"foo=bar"};

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args, argsEnv);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);

            Object sealed12321 = new PermittedSub1();

        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
