// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00290.java
// Original file CWE's: [79]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/set.tmt with name set_add_simple_positive
// Used extensions: MACRO_VarName -> sealed12321 | MACRO_VarName -> obj09823 | MACRO_Create_Set -> Set<~[TYPE@1]~> ~[MACRO_SetName]~ = new LinkedHashSet<>(); | MACRO_Add_Fixed_VAR_ToSet -> ~[MACRO_SetName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_SetName -> set787231 | MACRO_SetName -> set787231 | MACRO_SetName -> set787231
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-00/BenchmarkTest00290")
public class BenchmarkTest00290144 extends HttpServlet {

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

        File f = new File("wddgi");

        SuperClass obj09823 = new SiblingClass();

        String param = "";
        java.util.Enumeration<String> headers = request.getHeaders("Referer");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        StringBuilder sbxyz73567 = new StringBuilder(param);
        String bar = sbxyz73567.append("_SafeStuff").toString();

        response.setHeader("X-XSS-Protection", "0");

        Set<String> set787231 = new LinkedHashSet<>();
        set787231.add(bar);
        bar = set787231.iterator().next();

        response.getWriter().write(bar);
    }

    Object sealed12321 = new PermittedSub1();
}
