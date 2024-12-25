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
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-02/BenchmarkTest01260")
public class BenchmarkTest01260102 extends HttpServlet {

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

        String param = request.getParameter("BenchmarkTest01260");

        SuperClass obj09823 = new SubClass();

        if (param == null) param = "";

        String bar = new Test102().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {bar, "b"};
        response.getWriter().printf("Formatted like: %1$s and %2$s.", obj);
    } // end doPost

    private class Test102 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "";

            BinaryOpInterfaceDefault a12341 = new BinaryOpInterfaceDefaultImplementation();
            UnaryOpClass val89458 =
                    new UnaryOpClass() {
                        @Override
                        public String VirtualCall(String t) {
                            return (new NestedRecord(
                                            new SimpleRecord(param.toString()),
                                            new SimpleRecord(request.getPathInfo())))
                                    .b()
                                    .t();
                        }
                    };

            if (param != null) bar = param.split(" ")[0];

            Map<Float, String> map111 = new HashMap<>();
            Map<Float, String> map222 = new HashMap<>();

            bar = a12341.InterfaceCall(bar, bar);

            map111.put(0.108694285F, param);
            map222.put(0.108694285F, bar);
            map111.putAll(map222);
            String value7844 = map111.get(0.108694285F);

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
