// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02302.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/field/regularField.tmt with name class_with_string_field_positive
// Used extensions: MACRO_Regex -> (~[MACRO_Regex]~ + "*") | MACRO_Regex -> "\n"
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/pathtraver-02/BenchmarkTest02302")
public class BenchmarkTest02302195 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

        Pattern pattern = Pattern.compile(("\n" + "*"));
        Matcher matcher = pattern.matcher(request.getContextPath());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        boolean flag = true;

        StringHolder sh = new StringHolder();
        sh.value = param;
        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();

            Set<String> set111 = new HashSet<>();
            Set<String> set222 = new HashSet<>();

            NestedRecord nested = new NestedRecord(new SimpleRecord(param), new SimpleRecord(name));

            set111.add(param);
            set222.add(param);
            set222.add(param.toUpperCase());
            set111.removeAll(set222);
            String value7849 = "tbvls";
            if (set111.size() == 0) {
                value7849 = param;
            }

            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest02302")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        param = sh.value;

        String bar = doSomething(request, param);

        java.io.File fileTarget = new java.io.File(bar, "/Test.txt");
        response.getWriter()
                .println(
                        "Access to file: '"
                                + org.owasp
                                        .esapi
                                        .ESAPI
                                        .encoder()
                                        .encodeForHTML(fileTarget.toString())
                                + "' created.");
        if (fileTarget.exists()) {
            response.getWriter().println(" And file already exists.");
        } else {
            response.getWriter().println(" But file doesn't exist yet.");
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        return bar;
    }
}
