// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01619.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/collections/streams.tmt with name stream_simple_negative
// Used extensions: MACRO_VarName -> obj21341 | MACRO_Create_List -> List<~[TYPE@1]~>
// ~[MACRO_ListName]~ = new ArrayList<>(); | MACRO_Add_Fixed_CONST_ToList ->
// ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~@1]~); | MACRO_Create_Stream -> Stream<~[TYPE@1]~>
// ~[MACRO_StreamName]~ = ~[MACRO_ListName]~.stream(); | MACRO_StreamName -> stream787231 |
// MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_StreamName -> stream787231 |
// MACRO_ListName -> list787231
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
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-01/BenchmarkTest01619")
public class BenchmarkTest0161999 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    Object obj21341 = new ImplementingSuperClass();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] values = request.getParameterValues("BenchmarkTest01619");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = new Test99().doSomething(request, param);

        // javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
        request.getSession().setAttribute("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test99 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            List<String> list787231 = new ArrayList<>();
            list787231.add("jmxjs");
            Stream<String> stream787231 = list787231.stream();
            param = stream787231.findFirst().get();

            String bar = org.apache.commons.lang.StringEscapeUtils.escapeHtml(param);

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
