// CodeQL original results: [90]
// Insider original results: []
// Semgrep original results: [90]
// SonarQube original results: []
// Insider analysis results: [532]
// CodeQL analysis results: [561]
// Semgrep analysis results: [200, 90, 79]
// SonarQube analysis results: []
// Original file name: BenchmarkTest02472.java
// Original file CWE's: [90]
// Mutation info: Insert template from templates/classes/two_interfaces.tmt with index 2
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
import org.owasp.benchmark.helpers._Fuzz_ImplementBoth;
import org.owasp.benchmark.helpers._Fuzz_RightInterface;

@WebServlet(value = "/ldapi-00/BenchmarkTest02472")
public class BenchmarkTest02472582 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest02472");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";
        _Fuzz_RightInterface<String> i = new _Fuzz_ImplementBoth<String>();
        param = i.InterfaceCall(response.encodeURL(param), response.encodeURL(param));
        String bar = doSomething(request, param);

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

    private static String doSomething(HttpServletRequest request, String param)
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
}