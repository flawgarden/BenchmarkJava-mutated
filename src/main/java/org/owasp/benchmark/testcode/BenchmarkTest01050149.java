// CodeQL original results: [79]
// ApplicationInspector original results: [79]
// Snyk original results: [79]
// Semgrep original results: [79]
// Insider original results: []
// -------------
// CodeQL analysis results: [391, 561, 79]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: [79]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01050.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt
// with name simple_poll_positive
// Used extensions: MACRO_VarName -> sealed12321 | MACRO_VarName -> obj39745 | MACRO_VarName ->
// obj21341 | MACRO_Create_Queue -> Queue<~[TYPE@1]~> ~[MACRO_QueueName]~ = new ArrayDeque<>(); |
// MACRO_Add_Fixed_VAR_ToQueue -> ~[MACRO_QueueName]~.offer(~[VAR_~[TYPE@1]~@1]~); | MACRO_QueueName
// -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231
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
import java.util.concurrent.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-02/BenchmarkTest01050")
public class BenchmarkTest01050149 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object obj21341 = new ImplementingSuperSideClass();

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object sealed12321 = new PermittedSub2();

        String param = "";
        if (request.getHeader("Referer") != null) {
            param = request.getHeader("Referer");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = new Test149().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().print(bar);
    } // end doPost

    private class Test149 {

        Object obj39745 = new ImplementingSubClass();

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            Queue<String> queue787231 = new ArrayDeque<>();
            queue787231.offer(param);
            param = queue787231.poll();

            StringBuilder sbxyz75528 = new StringBuilder(param);
            String bar = sbxyz75528.append("_SafeStuff").toString();

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
