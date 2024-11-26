// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01232.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/list.tmt with name list_clear_start_negative
// Used extensions: MACRO_VarName -> obj09823 | MACRO_VarName -> obj12321 | MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new LinkedList<>(); | MACRO_Add_VAR_ToList -> ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231
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

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/pathtraver-01/BenchmarkTest01232")
public class BenchmarkTest0123247 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest01232");
        if (param == null) param = "";

        String bar = new Test47().doSomething(request, param);

        java.io.File fileTarget =
                new java.io.File(
                        new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR), bar);
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

            SuperClass obj09823 = new SubSubClass();

            response.getWriter().println(" And file already exists.");
        } else {
            response.getWriter().println(" But file doesn't exist yet.");
        }
    } // end doPost

    private class Test47 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            List<String> list787231 = new LinkedList<>();
            list787231.add(param);
            list787231.clear();
            param = list787231.get(0);

            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(param);

            Object obj12321 = new ImplementingSuperSideClass();

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
