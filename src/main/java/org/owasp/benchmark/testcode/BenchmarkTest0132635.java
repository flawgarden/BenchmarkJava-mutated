// CodeQL original results: [90]
// ApplicationInspector original results: [90]
// Snyk original results: [90]
// Semgrep original results: [90]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 90, 79]
// ApplicationInspector analysis results: []
// Snyk analysis results: [90, 79]
// Semgrep analysis results: []
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01326.java
// Original file CWE's: [90]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/collections/streams.tmt with name stream_map_positive
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new ArrayList<>(); |
// MACRO_Add_Fixed_EXPR_ToList -> ~[MACRO_ListName]~.add(~[EXPR_~[TYPE@1]~@1]~); |
// MACRO_Add_Fixed_CONST_ToList -> ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~@1]~); |
// MACRO_Add_Fixed_VAR_ToList -> ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_Create_Stream
// -> Stream<~[TYPE@1]~> ~[MACRO_StreamName]~ = ~[MACRO_ListName]~.stream(); | MACRO_StreamName ->
// stream787231 | MACRO_StreamName -> stream787231 | MACRO_ListName -> list787231 | MACRO_ListName
// -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_StreamName ->
// stream787231 | MACRO_ListName -> list787231
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/ldapi-00/BenchmarkTest01326")
public class BenchmarkTest0132635 extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest01326");
            if (values != null) param = values[0];
        }

        String bar = new Test35().doSomething(request, param);

        List<String> list787231 = new ArrayList<>();
        list787231.add(param);
        list787231.add("wcgbs");
        list787231.add(bar);
        Stream<String> stream787231 = list787231.stream();
        stream787231.map(entry111 -> entry111 + "mcbgw");
        bar = stream787231.findFirst().get();

        org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
        try {
            response.setContentType("text/html;charset=UTF-8");
            javax.naming.directory.DirContext ctx = ads.getDirContext();
            String base = "ou=users,ou=system";
            javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
            sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
            String filter = "(&(objectclass=person))(|(uid=" + bar + ")(street={0}))";
            Object[] filters = new Object[] {"The streetz 4 Ms bar"};
            // System.out.println("Filter " + filter);
            boolean found = false;
            javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results =
                    ctx.search(base, filter, filters, sc);
            while (results.hasMore()) {
                javax.naming.directory.SearchResult sr =
                        (javax.naming.directory.SearchResult) results.next();
                javax.naming.directory.Attributes attrs = sr.getAttributes();

                File f = new File("fqmag");

                javax.naming.directory.Attribute attr = attrs.get("uid");
                javax.naming.directory.Attribute attr2 = attrs.get("street");
                if (attr != null) {
                    response.getWriter()
                            .println(
                                    "LDAP query results:<br>"
                                            + "Record found with name "
                                            + attr.get()
                                            + "<br>"
                                            + "Address: "
                                            + attr2.get()
                                            + "<br>");
                    // System.out.println("record found " + attr.get());
                    found = true;
                }
            }
            if (!found) {
                response.getWriter()
                        .println(
                                "LDAP query results: nothing found for query: "
                                        + org.owasp.esapi.ESAPI.encoder().encodeForHTML(filter));
            }
        } catch (javax.naming.NamingException e) {
            throw new ServletException(e);
        } finally {
            try {
                ads.closeDirContext();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    } // end doPost

    private class Test35 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

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
    } // end innerclass Test
} // end DataflowThruInnerClass
