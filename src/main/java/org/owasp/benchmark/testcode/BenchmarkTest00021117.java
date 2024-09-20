// CodeQL original results: [90]
// ApplicationInspector original results: [90]
// Snyk original results: [90]
// Semgrep original results: [90]
// Insider original results: []
// -------------
// CodeQL analysis results: [561]
// ApplicationInspector analysis results: [79]
// Snyk analysis results: [79, 90]
// Semgrep analysis results: [200, 90, 79]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00021.java
// Original file CWE's: [90]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt
// with name varargs_get_first_string_negative
// Used extensions: MACRO_VarName -> obj21341 | EXPR_String ->
// ~[EXPR_String]~.substring(~[EXPR_int]~, ~[EXPR_int]~) | EXPR_String -> ""
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

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/ldapi-00/BenchmarkTest00021")
public class BenchmarkTest00021117 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest00021");
        if (param == null) param = "";

        org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
        try {
            response.setContentType("text/html;charset=UTF-8");
            javax.naming.directory.DirContext ctx = ads.getDirContext();
            String base = "ou=users,ou=system";
            javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
            sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
            String filter = "(&(objectclass=person))(|(uid=" + param + ")(street={0}))";
            Object[] filters = new Object[] {"The streetz 4 Ms bar"};
            // System.out.println("Filter " + filter);

            SuperClass obj21341 = new SubSubClass();

            filter =
                    getFirstString(
                            response.encodeRedirectUrl(param).substring(-3635, filter.length()),
                            "");

            boolean found = false;
            javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results =
                    ctx.search(base, filter, filters, sc);
            while (results.hasMore()) {
                javax.naming.directory.SearchResult sr =
                        (javax.naming.directory.SearchResult) results.next();
                javax.naming.directory.Attributes attrs = sr.getAttributes();

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
    }

    public String getFirstString(String... lines) {
        return getStringWithIndex(0, lines);
    }

    public String getStringWithIndex(int ind, String... lines) {
        return lines[ind];
    }

    public String getFirstStringFromArray(String... lines) {
        return Arrays.asList(lines).get(0);
    }

    public <T117> T117 varargsWithGenerics(T117... elements) {
        return elements[0];
    }

    public String combineStrings(String... strings) {
        return String.join(", ", strings);
    }
}