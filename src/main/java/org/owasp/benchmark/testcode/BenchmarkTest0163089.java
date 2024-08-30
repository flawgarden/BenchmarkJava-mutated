//CodeQL original results: [89]
//ApplicationInspector original results: [89]
//Snyk original results: [89]
//Semgrep original results: [89]
//Insider original results: []
//-------------
//CodeQL analysis results: [561, 89, 564]
//ApplicationInspector analysis results: []
//Snyk analysis results: []
//Semgrep analysis results: [89]
//Insider analysis results: []
//Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01630.java
//Original file CWE's: [89]  
//Original file kind: fail
//Mutation info: Insert template from templates-db/languages/java/sensitivity/pm.tmt with name pattern_matching_simple_4_negative 
//Used extensions: 
//Program:
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.*;
import java.util.*;

@WebServlet(value = "/sqli-03/BenchmarkTest01630")
public class BenchmarkTest0163089 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest01630");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = new Test89().doSomething(request, param);

        String sql = "INSERT INTO users (username, password) VALUES ('foo','" + bar + "')";

SimpleRecord recordEmpty = new SimpleRecord("");

UnaryOpInterface val89458 = (t) -> param;

try {
            java.sql.Statement statement =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
            int count = statement.executeUpdate(sql, new int[] {1, 2});
            org.owasp.benchmark.helpers.DatabaseHelper.outputUpdateComplete(sql, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    } // end doPost

    private class Test89 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

param = simplePatternMatchingString2("xytwy");

String bar = "";
            if (param != null) {
                bar =
                        new String(
                                org.apache.commons.codec.binary.Base64.decodeBase64(
                                        org.apache.commons.codec.binary.Base64.encodeBase64(
                                                param.getBytes())));
            }

            return bar;
        }
public String simplePatternMatchingString1(Object obj) {
    if (obj instanceof String str) {
        return str.toUpperCase();
    }
    return "";
}
public String simplePatternMatchingString2(Object obj) {
    if (obj instanceof String str && str.length() > 5) {
        return str.toUpperCase();
    }
    return "";
}

    } // end innerclass Test
} // end DataflowThruInnerClass
