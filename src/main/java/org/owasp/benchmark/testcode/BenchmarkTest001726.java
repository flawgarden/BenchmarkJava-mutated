// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00172.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt
// with name queue_remove_if_positive
// Used extensions: MACRO_VarName -> sealed21341 | MACRO_Create_Queue -> Queue<~[TYPE@1]~>
// ~[MACRO_QueueName]~ = new PriorityQueue<>(); | MACRO_Add_Fixed_CONST_ToQueue ->
// ~[MACRO_QueueName]~.add(~[CONST_~[TYPE@1]~@1]~); | MACRO_Add_Fixed_VAR_ToQueue ->
// ~[MACRO_QueueName]~.offer(~[VAR_~[TYPE@1]~@1]~); | MACRO_QueueName -> queue787231 |
// MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231
// | MACRO_QueueName -> queue787231
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00172")
public class BenchmarkTest001726 extends HttpServlet {

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

        String param = "";
        if (request.getHeader("BenchmarkTest00172") != null) {
            param = request.getHeader("BenchmarkTest00172");

            Queue<String> queue787231 = new PriorityQueue<>();
            queue787231.add("mzmhu");
            queue787231.offer(param);
            queue787231.removeIf(item -> item.equals("mzmhu"));
            param = queue787231.poll();
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = "safe!";
        java.util.HashMap<String, Object> map59408 = new java.util.HashMap<String, Object>();
        map59408.put("keyA-59408", "a-Value"); // put some stuff in the collection
        map59408.put("keyB-59408", param); // put it in a collection
        map59408.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map59408.get("keyB-59408"); // get it back out

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());
        String[] args = {cmd};
        String[] argsEnv = {bar};

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args, argsEnv, new java.io.File(System.getProperty("user.dir")));
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
