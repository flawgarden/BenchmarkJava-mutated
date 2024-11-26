// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00624.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt with name varargs_get_first_string_from_array_negative
// Used extensions: MACRO_VarName -> sealed21341
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

@WebServlet(value = "/pathtraver-00/BenchmarkTest00624")
public class BenchmarkTest00624130 extends HttpServlet {

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

        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest00624");

        param = getFirstStringFromArray(response.getHeader(param), response.encodeUrl(param));

        if (param == null) param = "";

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

        String fileName = null;
        java.io.FileOutputStream fos = null;

        try {
            fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;

            fos = new java.io.FileOutputStream(new java.io.File(fileName), false);
            response.getWriter()
                    .println(
                            "Now ready to write to file: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName));

        } catch (Exception e) {
            System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
            //			System.out.println("File exception caught and swallowed: " + e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (Exception e) {
                    // we tried...
                }
            }

            Object sealed21341 = new PermittedSub2();
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

    public <T130> T130 varargsWithGenerics(T130... elements) {
        return elements[0];
    }

    public String combineStrings(String... strings) {
        return String.join(", ", strings);
    }
}
