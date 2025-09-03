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
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-01/BenchmarkTest00547117")
public class BenchmarkTest00547117 extends HttpServlet {

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

        Object obj21341 = new ImplementingSuperClass();

        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];

                    Map<String, String> map787232 = new TreeMap<>();
                    map787232.put(param, value);
                    map787232.put(response.getHeader(name), value);
                    map787232.putIfAbsent(response.getHeader(name), param);
                    String value7846 = map787232.get(response.getHeader(name));

                    if (value.equals("BenchmarkTest00547")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        String bar = "";
        if (param != null) bar = param.split(" ")[0];

        SimpleRecord record = new SimpleRecord(bar);
        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", "b"};

        bar = record.t();

        response.getWriter().printf(java.util.Locale.US, bar, obj);
    }
}
