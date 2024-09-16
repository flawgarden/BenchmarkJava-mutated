// CodeQL original results: [78]
// ApplicationInspector original results: [78]
// Snyk original results: [78]
// Semgrep original results: [78]
// Insider original results: [78]
// -------------
// CodeQL analysis results: [561, 497, 209]
// ApplicationInspector analysis results: []
// Snyk analysis results: []
// Semgrep analysis results: []
// Insider analysis results: [78, 532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00174.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/lambdas/mutation.tmt
// with name nested_unary_lambda_mutation_negative
// Used extensions: EXPR_String -> ~[EXPR_String]~.substring(~[EXPR_int]~)
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00174")
public class BenchmarkTest00174127 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BinaryOpInterface val89458 = (t, u) -> "nttkp".substring(response.getStatus());

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = "";

        StringHolder a12341 = new StringHolder(param);
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
        if (request.getHeader("BenchmarkTest00174") != null) {
            param = request.getHeader("BenchmarkTest00174");
        }

        param = a12341.value;
        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());

        File f = new File(bar);

        String[] argsEnv = {bar};
        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(cmd, argsEnv);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
