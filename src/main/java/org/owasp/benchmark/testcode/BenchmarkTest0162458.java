// CodeQL original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79, 89, 564]
// ApplicationInspector analysis results: []
// Snyk analysis results: [89]
// Semgrep analysis results: []
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01624.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/list.tmt
// with name list_to_array_and_get_positive
// Used extensions: MACRO_VarName -> obj39745 | MACRO_VarName -> obj09823 | MACRO_VarName ->
// sealed12321 | MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new LinkedList<>(); |
// MACRO_Add_VAR_ToList -> ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_ListName ->
// list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/sqli-03/BenchmarkTest01624")
public class BenchmarkTest0162458 extends HttpServlet {

    SuperClass obj39745 = new SubSubClass();

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SuperClass obj09823 = new SubClass();

        response.setContentType("text/html;charset=UTF-8");

        String[] values = request.getParameterValues("BenchmarkTest01624");

        Object sealed12321 = new PermittedSub2();

        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        List<String> list787231 = new LinkedList<>();
        list787231.add(param);
        param = (String) list787231.toArray()[0];

        String bar = new Test58().doSomething(request, param);

        try {
            String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

            org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.batchUpdate(sql);
            response.getWriter()
                    .println(
                            "No results can be displayed for query: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql)
                                    + "<br>"
                                    + " because the Spring batchUpdate method doesn't return results.");
            //		System.out.println("no results for query: " + sql + " because the Spring batchUpdate
            // method doesn't return results.");
        } catch (org.springframework.dao.DataAccessException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    } // end doPost

    private class Test58 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "";
            if (param != null) {
                java.util.List<String> valuesList = new java.util.ArrayList<String>();
                valuesList.add("safe");
                valuesList.add(param);
                valuesList.add("moresafe");

                valuesList.remove(0); // remove the 1st safe value

                bar = valuesList.get(0); // get the param value
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
