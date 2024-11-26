// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02092.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/lambdas/mutation.tmt with name nested_unary_lambda_mutation_positive
// Used extensions: MACRO_Regex -> "[^abc]" | MACRO_Regex -> "[a-d[m-p]]"
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

@WebServlet(value = "/sqli-04/BenchmarkTest02092")
public class BenchmarkTest02092107 extends HttpServlet {

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

        String param = "";
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest02092");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

        try {
            java.sql.Statement statement =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
            statement.execute(sql);

            Pattern pattern = Pattern.compile("[a-d[m-p]]");
            Matcher matcher = pattern.matcher(response.getHeader(param));

            org.owasp.benchmark.helpers.DatabaseHelper.printResults(statement, sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        BinaryOpInterface val89458 = (t, u) -> param.replaceFirst(param, param);

        String bar = "";
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("safe");

            final String s23423 = bar;
            StringHolder a12341 = new StringHolder();
            UnaryOpMutationInterface lambda1231 =
                    (s) -> {
                        UnaryOpMutationInterface innerLambda1231 =
                                (p) -> {
                                    p.value = "";
                                };
                        innerLambda1231.Mutate(s);
                        s.value = s23423;
                    };
            lambda1231.Mutate(a12341);
            valuesList.add(param);
            valuesList.add("moresafe");

            Pattern pattern = Pattern.compile("[^abc]");
            Matcher matcher = pattern.matcher(request.getPathInfo());

            valuesList.remove(0); // remove the 1st safe value

            bar = valuesList.get(0); // get the param value

            bar = a12341.value;
        }

        return bar;
    }
}
