// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02525.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/field/constructors.tmt with name
// class_with_array_initialization_positive
// Used extensions: MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName@1]~ = new
// TreeMap<>(); | MACRO_Add_Element_ToMap -> ~[MACRO_MapName@1]~.put(~[VAR_~[TYPE@1]~]~,
// ~[VAR_~[TYPE@2]~]~); | MACRO_MapName@1 -> map787231 | MACRO_VarName -> obj12321 | MACRO_VarName
// -> obj21341 | MACRO_Empty_String_Array -> {"", ""}
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

@WebServlet(value = "/trustbound-01/BenchmarkTest02525")
public class BenchmarkTest0252534 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest02525");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");

        SuperClass obj12321 = new SubClass();
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();

        Map<String, String> map787231 = new TreeMap<>();
        map787231.put(param, param);
        map787231.put(request.getRequestedSessionId(), param);

        String[] tmpArrayUnique42 = {"", ""};
        tmpArrayUnique42[0] = param;
        ArrayHolder ah = new ArrayHolder(tmpArrayUnique42);
        String value78410 =
                map787231.entrySet().stream()
                        .filter(entry -> entry.equals("brxqm"))
                        .findFirst()
                        .get()
                        .getValue();

        param = ah.values[0];
        Object obj21341 = new ImplementingSubClass();

        String bar = thing.doSomething(param);

        return bar;
    }
}
