// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02516.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/lambdas/mutation.tmt
// with name nested_unary_lambda_mutation_negative
// Used extensions: MACRO_Create_Queue -> Queue<~[TYPE@1]~> ~[MACRO_QueueName@1]~ = new
// PriorityQueue<>(); | MACRO_Add_Element_ToQueue -> ~[MACRO_QueueName@1]~.add(~[VAR_~[TYPE@1]~]~);
// | MACRO_QueueName@1 -> queue787231
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

@WebServlet(value = "/cmdi-02/BenchmarkTest02516")
public class BenchmarkTest02516179 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest02516");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        UnaryOpInterface val89458 = (t) -> response.encodeRedirectURL(param);

        String bar = doSomething(request, param);

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());
        String[] argsEnv = {bar};
        Runtime r = Runtime.getRuntime();
        try {
            Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = "safe!";
        java.util.HashMap<String, Object> map74796 = new java.util.HashMap<String, Object>();

        Queue<String> queue787231 = new PriorityQueue<>();
        queue787231.add(bar);
        queue787231.poll();
        String value7842 = queue787231.peek();

        map74796.put("keyA-74796", "a-Value"); // put some stuff in the collection
        map74796.put("keyB-74796", param); // put it in a collection

        StringHolder a12341 = new StringHolder(bar);
        UnaryOpMutationInterface lambda1231 =
                (s) -> {
                    final String inner234234 = s.value;
                    UnaryOpMutationInterface innerLambda1231 =
                            (p) -> {
                                p.value = inner234234;
                            };
                    innerLambda1231.Mutate(s);
                    s.value = "";
                };
        lambda1231.Mutate(a12341);
        map74796.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map74796.get("keyB-74796"); // get it back out

        bar = a12341.value;

        return bar;
    }
}
