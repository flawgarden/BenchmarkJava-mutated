// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00159.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/concurrency/concurrency.tmt with name
// atomic_integer_restore_positive
// Used extensions: MACRO_Regex -> "\t" | MACRO_VarName -> obj12321 | MACRO_VarName -> obj39745
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
import java.util.concurrent.atomic.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-00/BenchmarkTest00159")
public class BenchmarkTest00159148 extends HttpServlet {

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

        Pattern pattern = Pattern.compile("\t");
        Matcher matcher = pattern.matcher(request.getContextPath());

        if (request.getHeader("BenchmarkTest00159") != null) {
            param = request.getHeader("BenchmarkTest00159");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().

        AtomicInteger counter = new AtomicInteger(0);
        String stringCopy = param;

        if (counter.get() == 0) {
            param = "";
        }

        Thread thread1 = new Thread(() -> counter.incrementAndGet());

        thread1.start();

        Thread thread2 = new Thread(() -> counter.incrementAndGet());

        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
        }

        if (counter.get() == 2) {
            param = stringCopy;
        }

        param = java.net.URLDecoder.decode(param, "UTF-8");

        org.owasp.benchmark.helpers.ThingInterface thing =
                org.owasp.benchmark.helpers.ThingFactory.createThing();
        String bar = thing.doSomething(param);

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

        SuperClass obj12321 = new SubSubClass();

        String[] args = {a1, a2, "echo " + bar};

        ProcessBuilder pb = new ProcessBuilder(args);

        try {
            Process p = pb.start();
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);

            SuperClass obj39745 = new SiblingClass();

        } catch (IOException e) {
            System.out.println(
                    "Problem executing cmdi - java.lang.ProcessBuilder(java.lang.String[]) Test Case");
            throw new ServletException(e);
        }
    }
}
