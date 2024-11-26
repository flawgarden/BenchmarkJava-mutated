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

@WebServlet(value = "/xss-00/BenchmarkTest00148")
public class BenchmarkTest0014867 extends HttpServlet {

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

        String tmpUnique42 = param;
        Object sealed09823 = new PermittedSub1();

        if (request.getHeader("Referer") != null) {
            param = request.getHeader("Referer");
        }

        if (param == response.encodeUrl(param)) {
            param = tmpUnique42;
        } else if (param == response.encodeUrl(param)) {
            param =
                    sealed09823
                            .toString()
                            .trim()
                            .replace('/', '.')
                            .replace(param.charAt(request.getIntHeader(param)), 'o');
        } else {
            param = "";
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar;

        UnaryOpInterface val89458 = (t) -> "";

        // Simple if statement that assigns param to bar on true condition
        int num = 196;

        GenericClass<Integer> genericClass39745 = new GenericClass<Integer>(18800);

        if ((500 / 42) + num > 200) bar = param;
        else bar = "This should never happen";

        response.setHeader("X-XSS-Protection", "0");
        Object[] obj = {"a", bar};
        response.getWriter().format("Formatted like: %1$s and %2$s.", obj);
    }
}
