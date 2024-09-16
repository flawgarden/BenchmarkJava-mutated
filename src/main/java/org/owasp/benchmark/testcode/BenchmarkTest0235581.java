// CodeQL original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [404, 772, 561, 89, 564]
// ApplicationInspector analysis results: [89]
// Snyk analysis results: []
// Semgrep analysis results: [200, 89]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02355.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/lambdas/mutation.tmt
// with name nested_unary_lambda_mutation_negative
// Used extensions: MACRO_VarName -> sealed12321 | MACRO_VarName -> obj39745 | MACRO_Create_List ->
// List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new ArrayList<>(); | MACRO_Add_Element_ToList ->
// ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Add_Element_ToList ->
// ~[MACRO_ListName@1]~.add(~[EXPR_~[TYPE@1]~]~); | MACRO_Add_Element_ToList ->
// ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_Create_Stream -> Stream<~[TYPE@1]~>
// ~[MACRO_StreamName@1]~ = ~[MACRO_ListName@1]~.stream(); | MACRO_StreamName@1 -> stream787231 |
// MACRO_ListName@1 -> list787234
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
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/sqli-05/BenchmarkTest02355")
public class BenchmarkTest0235581 extends HttpServlet {

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
        boolean flag = true;

        List<String> list787234 = new ArrayList<>();
        list787234.add(param);
        list787234.add(response.encodeURL(param));
        list787234.add(param);
        Stream<String> stream787231 = list787234.stream();
        String value7844 = stream787231.max(Comparator.naturalOrder()).get();

        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest02355")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        String bar = doSomething(request, param);

        String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='" + bar + "'";

        try {
            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
            java.sql.PreparedStatement statement =
                    connection.prepareStatement(sql, new String[] {"Column1", "Column2"});
            statement.setString(1, "foo");
            statement.execute();
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

        String bar = "";
        if (param != null) {
            java.util.List<String> valuesList = new java.util.ArrayList<String>();
            valuesList.add("safe");

            Object obj39745 = new ImplementingSuperClass();

            Object sealed12321 = new SealedSuper();

            valuesList.add(param);
            valuesList.add("moresafe");

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
            valuesList.remove(0); // remove the 1st safe value

            bar = valuesList.get(0); // get the param value

            bar = a12341.value;
        }

        return bar;
    }
}
