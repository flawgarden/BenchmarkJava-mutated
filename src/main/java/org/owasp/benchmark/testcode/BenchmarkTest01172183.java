// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01172.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/while.tmt
// with name while_operator_negative
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new ArrayList<>();
// | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); |
// MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); |
// MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Create_Stream
// -> Stream<~[TYPE@1]~> ~[MACRO_StreamName@1]~ = ~[MACRO_ListName@1]~.stream(); |
// MACRO_StreamName@1 -> stream787231 | MACRO_ListName@1 -> list787233 | MACRO_Create_Set ->
// Set<~[TYPE@1]~> ~[MACRO_SetName@1]~ = new TreeSet<>(); | MACRO_Add_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Add_Fixed_Element_ToSet ->
// ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_SetName@1 -> set787233 | MACRO_VarName ->
// genericClass09823
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-02/BenchmarkTest01172")
public class BenchmarkTest01172183 extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("Referer");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().

        while (!request.getRequestedSessionId().equals(param) || 30498 >= -29140) {
            param = "";
        }

        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = new Test183().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", bar};
        response.getWriter().format("Formatted like: %1$s and %2$s.", obj);
    } // end doPost

    private class Test183 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "safe!";
            java.util.HashMap<String, Object> map35084 = new java.util.HashMap<String, Object>();
            map35084.put("keyA-35084", "a-Value"); // put some stuff in the collection
            map35084.put("keyB-35084", param); // put it in a collection
            map35084.put("keyC", "another-Value"); // put some stuff in the collection
            bar = (String) map35084.get("keyB-35084"); // get it back out

            GenericClass<String> genericClass09823 =
                    new GenericClass<String>(param.valueOf(serialVersionUID));

            List<String> list787233 = new ArrayList<>();

            Set<String> set787233 = new TreeSet<>();
            set787233.add(bar);
            set787233.add(bar);
            String value7845 = "juglv";

            if (set787233.contains(bar)) {
                value7845 = bar;
            }

            list787233.add(bar);
            list787233.add(bar);
            list787233.add(bar);
            Stream<String> stream787231 = list787233.stream();
            String value7844 = stream787231.reduce((entry1, entry2) -> entry1 + entry2).get();

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
