// CodeQL original results: [89]
// Semgrep original results: [89]
// Insider original results: []
// CodeQL analysis results: [89, 564]
// Semgrep analysis results: [89]
// Insider analysis results: []
// Original file name: BenchmarkTest00435.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from templates/inheritance/interfaces.tmt with index 0
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.benchmark.helpers.inheritance.*;

@WebServlet(value = "/sqli-00/BenchmarkTest00435")
public class BenchmarkTest0043524 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest00435");
        if (param == null) param = "";

        String bar = "safe!";
        java.util.HashMap<String, Object> map86691 = new java.util.HashMap<String, Object>();
        map86691.put("keyA-86691", "a-Value"); // put some stuff in the collection
        map86691.put("keyB-86691", param); // put it in a collection
        map86691.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map86691.get("keyB-86691"); // get it back out

        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";

        try {
            ImplementingSuperClass obj = new ImplementingSuperClass();
            String superString = obj.superInterfaceMethod(sql);
            if (superString.equals(sql)) {
                sql = superString;
            }
            java.sql.Statement statement =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
            statement.addBatch(sql);
            int[] counts = statement.executeBatch();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(sql, counts, response);
        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
                return;
            } else throw new ServletException(e);
        }
    }
}
