// CodeQL original results: [501]
// ApplicationInspector original results: [501]
// Snyk original results: [501]
// Semgrep original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [571, 570, 391, 561, 79, 730, 400, 501]
// ApplicationInspector analysis results: []
// Snyk analysis results: [400, 730]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00426.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt
// with name simple_poll_negative
// Used extensions: MACRO_VarName -> obj39745 | MACRO_Create_Queue -> Queue<~[TYPE@1]~>
// ~[MACRO_QueueName]~ = new ArrayDeque<>(); | MACRO_Add_EXPR_ToQueue ->
// ~[MACRO_QueueName]~.offer(~[EXPR_~[TYPE@1]~]~); | MACRO_QueueName -> queue787231 |
// MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231
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
import java.util.concurrent.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-00/BenchmarkTest00426")
public class BenchmarkTest0042657 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest00426");
        if (param == null) param = "";

        String bar;

        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;

        // javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)

        Queue<String> queue787231 = new ArrayDeque<>();
        queue787231.offer(param.replaceAll(param, bar));
        bar = queue787231.poll();

        request.getSession().setAttribute(bar, "10340");

        Object obj39745 = new ImplementingSuperClass();

        File f = new File(obj39745.toString());

        response.getWriter()
                .println(
                        "Item: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' with value: '10340' saved in session.");
    }
}