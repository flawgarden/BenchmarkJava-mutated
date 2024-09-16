// CodeQL original results: [22]
// ApplicationInspector original results: [22]
// Snyk original results: [22]
// Semgrep original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 36, 22, 23, 73]
// ApplicationInspector analysis results: []
// Snyk analysis results: [23]
// Semgrep analysis results: [200, 22]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00528.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/concurrency/concurrency.tmt with name
// null_and_restore_condvar_positive
// Used extensions: MACRO_VarName -> obj09823 | MACRO_VarName -> genericClass39745 | EXPR_Boolean ->
// ~[EXPR_Object]~ instanceof ImplementingSubClass | EXPR_Object -> new ImplementingSubClass()
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/pathtraver-00/BenchmarkTest00528")
public class BenchmarkTest0052814 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    SuperClass obj09823 = new SubSubClass();

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

        GenericClass<Boolean> genericClass39745 =
                new GenericClass<Boolean>(
                        new ImplementingSubClass() instanceof ImplementingSubClass);

        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest00528")) {
                        param = name;
                        flag = false;
                    }

                    NullAndRestore a = new NullAndRestore(param);

                    Thread thread1 =
                            new Thread(
                                    () -> {
                                        a.nullMethod();
                                    });
                    Thread thread2 =
                            new Thread(
                                    () -> {
                                        a.restore();
                                    });

                    thread1.start();
                    thread2.start();
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                    }
                    try {
                        thread2.join();
                    } catch (InterruptedException e) {
                    }

                    param = a.get();
                }
            }
        }

        String bar = "safe!";
        java.util.HashMap<String, Object> map6751 = new java.util.HashMap<String, Object>();
        map6751.put("keyA-6751", "a-Value"); // put some stuff in the collection
        map6751.put("keyB-6751", param); // put it in a collection
        map6751.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map6751.get("keyB-6751"); // get it back out

        // FILE URIs are tricky because they are different between Mac and Windows because of lack
        // of standardization.
        // Mac requires an extra slash for some reason.
        String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
            if (System.getProperty("os.name").indexOf("Windows") != -1) startURIslashes = "/";
            else startURIslashes = "//";

        try {
            java.net.URI fileURI =
                    new java.net.URI(
                            "file",
                            null,
                            startURIslashes
                                    + org.owasp.benchmark.helpers.Utils.TESTFILES_DIR
                                            .replace('\\', java.io.File.separatorChar)
                                            .replace(' ', '_')
                                    + bar,
                            null,
                            null);
            java.io.File fileTarget = new java.io.File(fileURI);

            File f = new File(response.encodeUrl(param));

            response.getWriter()
                    .println(
                            "Access to file: '"
                                    + org.owasp
                                            .esapi
                                            .ESAPI
                                            .encoder()
                                            .encodeForHTML(fileTarget.toString())
                                    + "' created.");
            if (fileTarget.exists()) {
                response.getWriter().println(" And file already exists.");
            } else {
                response.getWriter().println(" But file doesn't exist yet.");
            }
        } catch (java.net.URISyntaxException e) {
            throw new ServletException(e);
        }
    }
}
