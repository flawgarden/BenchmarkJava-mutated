/**
 * OWASP Benchmark v1.2
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
package org.owasp.benchmark.testcode.java22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(value = "/sqli-00/BenchmarkTest00008")
public class BenchmarkTest0000843 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // some code
        response.setContentType("text/html;charset=UTF-8");

        String param = "";
        if (request.getHeader("BenchmarkTest00008") != null) {
            param = request.getHeader("BenchmarkTest00008");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        AtomicInteger atomicInteger = new AtomicInteger(0);
        String stringCopy = param;

        if (atomicInteger.get() == 0) {
            param = "123";
        }

        Callable<Object> task1 =
                () -> {
                    atomicInteger.incrementAndGet();
                    return null;
                };
        Callable<Object> task2 =
                () -> {
                    atomicInteger.incrementAndGet();
                    return null;
                };

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = executor.invokeAll(Arrays.asList(task1, task2));
            futures.forEach(
                    (f) -> {
                        try {
                            f.get();
                        } catch (Exception e) {
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (atomicInteger.get() == 2) {
            param = stringCopy;
        }
        String sql = "{call " + param + "}";

        try {
            java.sql.Connection connection =
                    org.owasp.benchmark.helpers.DatabaseHelper.getSqlConnection();
            java.sql.CallableStatement statement = connection.prepareCall(sql);
            java.sql.ResultSet rs = statement.executeQuery();
            org.owasp.benchmark.helpers.DatabaseHelper.printResults(rs, sql, response);

        } catch (java.sql.SQLException e) {
            if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
                response.getWriter().println("Error processing request.");
            } else throw new ServletException(e);
        }
    }
}
