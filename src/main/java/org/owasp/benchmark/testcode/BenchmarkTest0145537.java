// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01455.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/map.tmt with name map_clear_negative
// Used extensions: MACRO_VarName -> obj21341 | MACRO_VarName -> obj39745 | MACRO_VarName -> sealed21341 | MACRO_Create_Map -> Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName]~ = new TreeMap<>(); | MACRO_Add_EXPR_ToMap -> ~[MACRO_MapName]~.put(~[EXPR_~[TYPE@1]~@1]~, ~[EXPR_~[TYPE@2]~@2]~); | MACRO_MapName -> map787234 | MACRO_MapName -> map787234 | MACRO_MapName -> map787234 | MACRO_MapName -> map787234 | MACRO_MapName -> map787234
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

@WebServlet(value = "/trustbound-00/BenchmarkTest01455")
public class BenchmarkTest0145537 extends HttpServlet {

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

        String param = "";
        boolean flag = true;
        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);

            Object sealed21341 = new PermittedSub1();

            if (values != null) {

                Map<String, String> map787234 = new TreeMap<>();
                map787234.put(sealed21341.toString(), response.encodeUrl(param));
                map787234.put(response.encodeUrl(param), name);
                map787234.clear();
                name = map787234.get(response.encodeUrl(param));

                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest01455")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        String bar = new Test37().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");

        Object obj39745 = new ImplementingSuperSideClass();
    } // end doPost

    private class Test37 {

        SuperClass obj21341 = new SubSubClass();

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = param;
            if (param != null && param.length() > 1) {
                bar = param.substring(0, param.length() - 1);
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
