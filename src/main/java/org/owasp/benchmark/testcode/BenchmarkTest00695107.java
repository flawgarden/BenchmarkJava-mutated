// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00695.java
// Original file CWE's: [90]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/concurrency/concurrency.tmt with name
// atomic_integer_negative
// Used extensions: MACRO_VarName -> obj12321 | MACRO_VarName -> obj09823 | MACRO_VarName ->
// obj39745
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
import java.util.concurrent.atomic.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/ldapi-00/BenchmarkTest00695")
public class BenchmarkTest00695107 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest00695");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = "safe!";
        java.util.HashMap<String, Object> map9400 = new java.util.HashMap<String, Object>();
        map9400.put("keyA-9400", "a-Value"); // put some stuff in the collection

        SuperClass obj39745 = new SiblingClass();

        map9400.put("keyB-9400", param); // put it in a collection

        AtomicInteger counter = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> counter.incrementAndGet());

        thread1.start();

        Thread thread2 = new Thread(() -> counter.incrementAndGet());

        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
        }

        if (counter.get() == 2) {
            param = "";
        }

        map9400.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map9400.get("keyB-9400"); // get it back out

        org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
        try {
            response.setContentType("text/html;charset=UTF-8");
            javax.naming.directory.DirContext ctx = ads.getDirContext();
            String base = "ou=users,ou=system";
            javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
            sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
            String filter = "(&(objectclass=person)(uid=" + bar + "))";
            // System.out.println("Filter " + filter);
            boolean found = false;
            javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results =
                    ctx.search(base, filter, sc);
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

            SuperClass obj09823 = new SuperClass();

            throw new ServletException(e);
        } finally {
            try {
                ads.closeDirContext();
            } catch (Exception e) {

                Object obj12321 = new ImplementingSuperSideClass();

                throw new ServletException(e);
            }
        }
    }
}
