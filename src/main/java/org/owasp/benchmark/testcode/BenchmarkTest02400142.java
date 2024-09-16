// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Snyk original results: []
// Semgrep original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79]
// ApplicationInspector analysis results: []
// Snyk analysis results: [79]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02400.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/list.tmt
// with name list_union_positive
// Used extensions: MACRO_VarName -> sealed21341 | MACRO_VarName -> sealed09823 | MACRO_VarName ->
// sealed12321 | MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new ArrayList<>(); |
// MACRO_Add_VAR_ToList -> ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_ListName ->
// list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231
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

@WebServlet(value = "/xss-04/BenchmarkTest02400")
public class BenchmarkTest02400142 extends HttpServlet {

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

        Object sealed21341 = new SealedSuper();

        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest02400");
        if (param == null) param = "";

        String bar = doSomething(request, param);

        List<String> list787231 = new ArrayList<>();
        list787231.add(bar);
        List<String> list1234 = new ArrayList<>();
        list1234.addAll(list787231);
        bar = list1234.get(list1234.size() - 1);

        response.setHeader("X-XSS-Protection", "0");

        Object sealed12321 = new SealedSuper();

        Object[] obj = {"a", bar};

        Object sealed09823 = new PermittedSub1();

        response.getWriter().printf(java.util.Locale.US, "Formatted like: %1$s and %2$s.", obj);
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "";
        if (param != null) bar = param.split(" ")[0];

        return bar;
    }
}
