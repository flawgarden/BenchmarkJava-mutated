// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01616.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/concurrency/concurrency.tmt with name null_and_restore_condvar_positive
// Used extensions: MACRO_VarName -> sealed39745 | MACRO_VarName -> obj39745 | MACRO_VarName -> sealed09823
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
import java.util.concurrent.atomic.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-00/BenchmarkTest01616")
public class BenchmarkTest01616190 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest01616");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = new Test190().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)

        Object sealed39745 = new PermittedSub1();

        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test190 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            NullAndRestore a = new NullAndRestore(param);

            Thread thread1 =
                    new Thread(
                            () -> {
                                a.nullMethod();
                            });
            Thread thread2 =
                    new Thread(
                            () -> {
                                a.restore();
                            });

            thread1.start();
            thread2.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
            }
            try {
                thread2.join();
            } catch (InterruptedException e) {
            }

            param = a.get();

            // Chain a bunch of propagators in sequence
            String a53857 = param; // assign

            Object sealed09823 = new SealedSuper();

            StringBuilder b53857 = new StringBuilder(a53857); // stick in stringbuilder
            b53857.append(" SafeStuff"); // append some safe content
            b53857.replace(
                    b53857.length() - "Chars".length(),
                    b53857.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map53857 = new java.util.HashMap<String, Object>();
            map53857.put("key53857", b53857.toString()); // put in a collection
            String c53857 = (String) map53857.get("key53857"); // get it back out

            Object obj39745 = new ImplementingSuperClass();

            String d53857 = c53857.substring(0, c53857.length() - 1); // extract most of it
            String e53857 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d53857.getBytes()))); // B64 encode and decode it
            String f53857 = e53857.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f53857); // reflection

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
