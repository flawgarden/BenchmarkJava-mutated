// CodeQL original results: [501]
// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79, 501]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02525.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/map.tmt
// with name map_put_if_absent_negative
// Used extensions: MACRO_VarName -> sealed12321 | MACRO_Regex -> (~[MACRO_Regex]~ + "+") |
// MACRO_Regex -> "[abc]" | MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName]~ = new
// TreeMap<>(); | MACRO_MapName -> map787234 | MACRO_MapName -> map787234 | MACRO_MapName ->
// map787234 | MACRO_MapName -> map787234
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

@WebServlet(value = "/trustbound-01/BenchmarkTest02525")
public class BenchmarkTest0252595 extends HttpServlet {

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

        Pattern pattern = Pattern.compile(("[abc]" + "+"));
        Matcher matcher = pattern.matcher("qqzlq");

        String[] values = request.getParameterValues("BenchmarkTest02525");

        Object sealed12321 = new PermittedSub2();

        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        Map<String, String> map787234 = new TreeMap<>();
        map787234.put(sealed12321.toString(), "zjcal");
        map787234.putIfAbsent(sealed12321.toString(), param);
        param = map787234.get(sealed12321.toString());

        String bar = doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        return bar;
    }
}