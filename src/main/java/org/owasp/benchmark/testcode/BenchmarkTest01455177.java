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

@WebServlet(value = "/trustbound-00/BenchmarkTest01455")
public class BenchmarkTest01455177 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleRecord recordEmpty = new SimpleRecord("");

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        BinaryOpInterface val89458 = (t, u) -> "";

        String param = "";
        boolean flag = true;

        Map<String, String> map787231 = new HashMap<>();
        map787231.put(response.encodeUrl(param), param);
        map787231.put(param.concat(param), param);
        String value7847 = map787231.remove(param);

        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest01455")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        String bar = new Test177().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test177 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = param;

            try {
                if (param != null && param.length() > 1) {
                    bar = param.substring(0, param.length() - 1);
                }

                Object x[] = new String[3];
                x[0] = new Integer(0);
            } catch (ArrayStoreException e) {
                bar = "";
            }
            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
