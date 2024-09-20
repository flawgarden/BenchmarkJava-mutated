// CodeQL original results: [90]
// ApplicationInspector original results: [90]
// Snyk original results: [90]
// Semgrep original results: [90]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 90, 79]
// ApplicationInspector analysis results: [90, 79, 22]
// Snyk analysis results: []
// Semgrep analysis results: [90, 22, 79]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01241.java
// Original file CWE's: [90]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/injection/injection.tmt with name
// simple_dependency_injection_positive
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new ArrayList<>();
// | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[EXPR_~[TYPE@1]~]~); |
// MACRO_Create_Stream -> Stream<~[TYPE@1]~> ~[MACRO_StreamName@1]~ = ~[MACRO_ListName@1]~.stream();
// | MACRO_StreamName@1 -> stream787231 | MACRO_ListName@1 -> list787232 | MACRO_VarName ->
// genericClass12321
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

@WebServlet(value = "/ldapi-00/BenchmarkTest01241")
public class BenchmarkTest01241182 extends HttpServlet {

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

        GenericClass<String> genericClass12321 =
                new GenericClass<String>(request.changeSessionId());

        String param = request.getParameter("BenchmarkTest01241");
        if (param == null) param = "";

        String bar = new Test182().doSomething(request, param);

        org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
        try {
            response.setContentType("text/html;charset=UTF-8");
            String base = "ou=users,ou=system";
            javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
            sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
            String filter = "(&(objectclass=person))(|(uid=" + bar + ")(street={0}))";
            Object[] filters = new Object[] {"The streetz 4 Ms bar"};

            javax.naming.directory.DirContext ctx = ads.getDirContext();
            javax.naming.directory.InitialDirContext idc =
                    (javax.naming.directory.InitialDirContext) ctx;
            boolean found = false;
            javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results =
                    idc.search(base, filter, filters, sc);
            while (results.hasMore()) {
                javax.naming.directory.SearchResult sr =
                        (javax.naming.directory.SearchResult) results.next();
                javax.naming.directory.Attributes attrs = sr.getAttributes();

                File f = new File(sr.toString());

                javax.naming.directory.Attribute attr = attrs.get("uid");
                javax.naming.directory.Attribute attr2 = attrs.get("street");

                List<String> list787232 = new ArrayList<>();
                list787232.add("zrmnh");
                Stream<String> stream787231 = list787232.stream();
                String value7841 = stream787231.findFirst().get();

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

    private class Test182 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            ServiceSimple service111 = new ServiceSimple(param);
            ConsumerSimple cs111 = new ConsumerSimple(service111);
            param = cs111.getFieldValue();

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