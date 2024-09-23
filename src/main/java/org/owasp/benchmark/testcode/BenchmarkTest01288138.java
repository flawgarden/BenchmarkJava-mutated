// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01288.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/field/regularField.tmt with name
// class_with_string_field_positive
// Used extensions: MACRO_VarName -> obj39745 | MACRO_VarName -> obj12321
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

@WebServlet(value = "/cmdi-01/BenchmarkTest01288")
public class BenchmarkTest01288138 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SuperClass obj39745 = new SubClass();

        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("BenchmarkTest01288");
        if (param == null) param = "";

        String bar = new Test138().doSomething(request, param);

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());
        String[] args = {cmd};
        String[] argsEnv = {bar};

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args, argsEnv, new java.io.File(System.getProperty("user.dir")));
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }

        SuperClass obj12321 = new SuperClass();
    } // end doPost

    private class Test138 {

        UnaryOpInterface val89458 =
                new UnaryOpInterface() {
                    @Override
                    public String InterfaceCall(String t) {
                        return "";
                    }
                };

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "safe!";
            java.util.HashMap<String, Object> map58555 = new java.util.HashMap<String, Object>();
            map58555.put("keyA-58555", "a-Value"); // put some stuff in the collection

            StringHolder sh = new StringHolder();
            sh.value = bar;
            map58555.put("keyB-58555", param); // put it in a collection
            map58555.put("keyC", "another-Value"); // put some stuff in the collection
            bar = (String) map58555.get("keyB-58555"); // get it back out

            bar = sh.value;

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
