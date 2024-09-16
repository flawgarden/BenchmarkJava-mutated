// CodeQL original results: [501]
// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79, 501]
// ApplicationInspector analysis results: [22]
// Snyk analysis results: [501]
// Semgrep analysis results: [22]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00425.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/list.tmt
// with name list_union_positive
// Used extensions: MACRO_VarName -> obj09823 | MACRO_VarName -> obj21341 | MACRO_Create_List ->
// List<~[TYPE@1]~> ~[MACRO_ListName]~ = new ArrayList<>(); | MACRO_Add_VAR_ToList ->
// ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_ListName -> list787231 | MACRO_ListName ->
// list787231 | MACRO_ListName -> list787231
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-00/BenchmarkTest00425")
public class BenchmarkTest00425165 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        File f = new File(request.getMethod());

        doPost(request, response);

        Object obj21341 = new ImplementingSuperClass();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("BenchmarkTest00425");
        if (param == null) param = "";

        StringBuilder sbxyz2192 = new StringBuilder(param);
        String bar = sbxyz2192.append("_SafeStuff").toString();

        List<String> list787231 = new ArrayList<>();
        list787231.add(bar);
        List<String> list1234 = new ArrayList<>();
        list1234.addAll(list787231);
        bar = list1234.get(list1234.size() - 1);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        SuperClass obj09823 = new SiblingClass();

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    }
}
