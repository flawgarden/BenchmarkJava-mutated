// CodeQL original results: [89]
// ApplicationInspector original results: [89]
// Snyk original results: [89]
// Semgrep original results: [89]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 79, 564, 89]
// ApplicationInspector analysis results: [22]
// Snyk analysis results: [89]
// Semgrep analysis results: [200, 22]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00033.java
// Original file CWE's: [89]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/collections/streams.tmt with name stream_map_negative
// Used extensions: MACRO_Regex -> "[a-z&&[def]]" | MACRO_Create_List -> List<~[TYPE@1]~>
// ~[MACRO_ListName]~ = new ArrayList<>(); | MACRO_Add_Fixed_VAR_ToList ->
// ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_Add_CONST_ToList ->
// ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~]~); | MACRO_Add_CONST_ToList ->
// ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~]~); | MACRO_Create_Stream -> Stream<~[TYPE@1]~>
// ~[MACRO_StreamName]~ = ~[MACRO_ListName]~.stream(); | MACRO_StreamName -> stream787231 |
// MACRO_StreamName -> stream787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 |
// MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_StreamName -> stream787231 |
// MACRO_ListName -> list787231
// Program:
/**
 * OWASP Benchmark v1.2
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/sqli-00/BenchmarkTest00033")
public class BenchmarkTest0003349 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // some code
        response.setContentType("text/html;charset=UTF-8");

        Pattern pattern = Pattern.compile("[a-z&&[def]]");
        Matcher matcher = pattern.matcher("vlzep");

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest00033");
            if (values != null) param = values[0];
        }

        String sql = "SELECT  * from USERS where USERNAME='foo' and PASSWORD='" + param + "'";
        try {

            File f = new File(request.getPathInfo());

            List<String> list787231 = new ArrayList<>();
            list787231.add(sql);
            list787231.add("ayfba");
            list787231.add("hbccj");
            Stream<String> stream787231 = list787231.stream();
            stream787231.map(entry111 -> "jadwy");
            sql = stream787231.findFirst().get();

            org.springframework.jdbc.support.rowset.SqlRowSet results =
                    org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.queryForRowSet(sql);
            response.getWriter().println("Your results are: ");

            //		System.out.println("Your results are");
            while (results.next()) {
                response.getWriter()
                        .println(
                                org.owasp
                                                .esapi
                                                .ESAPI
                                                .encoder()
                                                .encodeForHTML(results.getString("USERNAME"))
                                        + " ");
                //			System.out.println(results.getString("USERNAME"));
            }
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            response.getWriter()
                    .println(
                            "No results returned for query: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(sql));
        } catch (org.springframework.dao.DataAccessException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");

                File f = new File(response.encodeRedirectUrl(sql));

            } else throw new ServletException(e);
        }
    }
}