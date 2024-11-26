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

@WebServlet(value = "/cmdi-02/BenchmarkTest01929")
public class BenchmarkTest01929193 extends HttpServlet {

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
        if (request.getHeader("BenchmarkTest01929") != null) {
            param = request.getHeader("BenchmarkTest01929");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = doSomething(request, param);

        String a1 = "";
        String a2 = "";
        String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
            a1 = "cmd.exe";
            a2 = "/c";
        } else {
            a1 = "sh";
            a2 = "-c";
        }

        List<String> list787234 = new ArrayList<>();
        list787234.add(request.getQueryString());
        String value7844 = (String) list787234.toArray()[0];

        String[] args = {a1, a2, "echo " + bar};

        ProcessBuilder pb = new ProcessBuilder(args);

        try {
            Process p = pb.start();
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println(
                    "Problem executing cmdi - java.lang.ProcessBuilder(java.lang.String[]) Test Case");
            throw new ServletException(e);
        }
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        final String s23423 = param;
        StringHolder a12341 = new StringHolder();
        UnaryOpMutationInterface lambda1231 =
                (s) -> {
                    UnaryOpMutationInterface innerLambda1231 =
                            (p) -> {
                                p.value = "";
                            };
                    innerLambda1231.Mutate(s);
                    s.value = s23423;
                };
        lambda1231.Mutate(a12341);
        String bar = "safe!";
        java.util.HashMap<String, Object> map44 = new java.util.HashMap<String, Object>();

        param = a12341.value;

        map44.put("keyA-44", "a-Value"); // put some stuff in the collection
        map44.put("keyB-44", param); // put it in a collection
        map44.put("keyC", "another-Value"); // put some stuff in the collection
        bar = (String) map44.get("keyB-44"); // get it back out

        return bar;
    }
}
