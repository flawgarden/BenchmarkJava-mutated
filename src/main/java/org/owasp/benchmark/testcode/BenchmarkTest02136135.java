// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02136.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt with name queue_poll_negative
// Used extensions: MACRO_VarName -> obj39745 | MACRO_VarName -> obj21341 | MACRO_Create_Queue -> Queue<~[TYPE@1]~> ~[MACRO_QueueName]~ = new PriorityQueue<>(); | MACRO_Add_CONST_ToQueue -> ~[MACRO_QueueName]~.offer(~[CONST_~[TYPE@1]~]~); | MACRO_Add_CONST_ToQueue -> ~[MACRO_QueueName]~.add(~[CONST_~[TYPE@1]~]~); | MACRO_Add_Fixed_VAR_ToQueue -> ~[MACRO_QueueName]~.offer(~[VAR_~[TYPE@1]~@1]~); | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231
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
import java.util.concurrent.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-04/BenchmarkTest02136")
public class BenchmarkTest02136135 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest02136");
        if (param == null) param = "";

        String bar = doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        int length = 1;
        if (bar != null) {

            SuperClass obj39745 = new SuperClass();

            length = bar.length();
            response.getWriter().write(bar, 0, length);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        Queue<String> queue787231 = new PriorityQueue<>();
        queue787231.offer("vmuly");
        queue787231.add("zohdg");
        queue787231.offer(param);
        param = queue787231.poll();

        String bar;

        // Simple ? condition that assigns param to bar on false condition
        int num = 106;

        bar = (7 * 42) - num > 200 ? "This should never happen" : param;

        return bar;
    }
}
