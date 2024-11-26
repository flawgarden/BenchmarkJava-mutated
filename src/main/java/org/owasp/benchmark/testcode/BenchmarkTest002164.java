// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00216.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/queue.tmt with name queue_poll_all_positive
// Used extensions: MACRO_VarName -> obj09823 | MACRO_VarName -> obj21341 | MACRO_Create_Queue -> Queue<~[TYPE@1]~> ~[MACRO_QueueName]~ = new LinkedList<>(); | MACRO_Add_EXPR_ToQueue -> ~[MACRO_QueueName]~.add(~[EXPR_~[TYPE@1]~]~); | MACRO_Add_EXPR_ToQueue -> ~[MACRO_QueueName]~.offer(~[EXPR_~[TYPE@1]~]~); | MACRO_Add_Fixed_VAR_ToQueue -> ~[MACRO_QueueName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | MACRO_QueueName -> queue787231 | EXPR_String -> ~[EXPR_String]~.toString() | MACRO_QueueName -> queue787231
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

@WebServlet(value = "/pathtraver-00/BenchmarkTest00216")
public class BenchmarkTest002164 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SuperClass obj21341 = new SuperClass();

        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        java.util.Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();

            if (org.owasp.benchmark.helpers.Utils.commonHeaders.contains(name)) {
                continue; // If standard header, move on to next one
            }

            java.util.Enumeration<String> values = request.getHeaders(name);
            if (values != null && values.hasMoreElements()) {

                Queue<String> queue787231 = new LinkedList<>();
                queue787231.add(response.encodeRedirectURL(param));
                queue787231.offer(param.valueOf(serialVersionUID).toString());
                queue787231.add(name);
                String value7847 = "iufvp";
                while (!queue787231.isEmpty()) {
                    value7847 = queue787231.poll();
                }
                name = value7847;

                param = name; // Grabs the name of the first non-standard header as the parameter

                SuperClass obj09823 = new SiblingClass();

                // value
                break;
            }
        }
        // Note: We don't URL decode header names because people don't normally do that

        String bar;

        // Simple if statement that assigns param to bar on true condition
        int num = 196;
        if ((500 / 42) + num > 200) bar = param;
        else bar = "This should never happen";

        java.io.File fileTarget =
                new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR, bar);
        response.getWriter()
                .println(
                        "Access to file: '"
                                + org.owasp
                                        .esapi
                                        .ESAPI
                                        .encoder()
                                        .encodeForHTML(fileTarget.toString())
                                + "' created.");
        if (fileTarget.exists()) {
            response.getWriter().println(" And file already exists.");
        } else {
            response.getWriter().println(" But file doesn't exist yet.");
        }
    }
}
