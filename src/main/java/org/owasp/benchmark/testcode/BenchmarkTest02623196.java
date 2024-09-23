// CodeQL original results: [501]
// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79, 501]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: [200, 501, 79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02623.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/field/staticField.tmt
// with name class_with_static_string_field_positive
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new ArrayList<>();
// | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[EXPR_~[TYPE@1]~]~); |
// MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); |
// MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Create_Stream
// -> Stream<~[TYPE@1]~> ~[MACRO_StreamName@1]~ = ~[MACRO_ListName@1]~.stream(); |
// MACRO_StreamName@1 -> stream787231 | MACRO_ListName@1 -> list787233
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
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-01/BenchmarkTest02623")
public class BenchmarkTest02623196 extends HttpServlet {

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

        String queryString = request.getQueryString();

        StaticFieldHolder.DEFAULT_VALUE = queryString;
        StaticFieldHolder sfh = new StaticFieldHolder();
        String paramval = "BenchmarkTest02623" + "=";
        int paramLoc = -1;
        if (queryString != null) paramLoc = queryString.indexOf(paramval);

        queryString = sfh.value;

        if (paramLoc == -1) {
            response.getWriter()
                    .println(
                            "getQueryString() couldn't find expected parameter '"
                                    + "BenchmarkTest02623"
                                    + "' in query string.");
            return;
        }

        String param =
                queryString.substring(
                        paramLoc
                                + paramval
                                        .length()); // 1st assume "BenchmarkTest02623" param is last
        // parameter in query string.
        // And then check to see if its in the middle of the query string and if so, trim off what
        // comes after.
        int ampersandLoc = queryString.indexOf("&", paramLoc);
        if (ampersandLoc != -1) {
            param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
        }

        List<String> list787233 = new ArrayList<>();
        list787233.add(response.encodeUrl(paramval));
        list787233.add(param);
        list787233.add(paramval);
        Stream<String> stream787231 = list787233.stream();
        String value7844 = stream787231.reduce((entry1, entry2) -> entry1 + entry2).get();

        File f = new File(paramval);

        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        // javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
        request.getSession().setAttribute("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = param;

        return bar;
    }
}
