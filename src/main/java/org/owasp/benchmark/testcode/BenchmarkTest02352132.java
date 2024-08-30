//CodeQL original results: [501]
//ApplicationInspector original results: [501]
//Snyk original results: [501]
//Semgrep original results: []
//Insider original results: []
//-------------
//CodeQL analysis results: [561, 79, 501]
//ApplicationInspector analysis results: []
//Snyk analysis results: [501]
//Semgrep analysis results: [79]
//Insider analysis results: []
//Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02352.java
//Original file CWE's: [501]  
//Original file kind: fail
//Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/for.tmt with name for_operator_change_index_negative 
//Used extensions: MACRO_VarName -> obj12321 | MACRO_VarName -> obj39745
//Program:
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;
import java.io.*;

@WebServlet(value = "/trustbound-01/BenchmarkTest02352")
public class BenchmarkTest02352132 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

SuperClass obj12321 = new SiblingClass();

response.setContentType("text/html;charset=UTF-8");

        String param = "";
        boolean flag = true;

for (int i = 0; i < response.getStatus(); i += response.getStatus()) {
    param = "";
}

java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest02352")) {

Object obj39745 = new ImplementingSuperSideClass();

param = name;
                        flag = false;

BinaryOpInterface val89458 = (t, u) -> "";

}
                }
            }
        }

        String bar = doSomething(request, param);

        // javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
        request.getSession().setAttribute(bar, "10340");

        response.getWriter()
                .println(
                        "Item: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' with value: '10340' saved in session.");
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        return bar;
    }
}
