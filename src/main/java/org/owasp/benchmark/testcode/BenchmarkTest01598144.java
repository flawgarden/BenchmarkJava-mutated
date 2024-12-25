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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-03/BenchmarkTest01598")
public class BenchmarkTest01598144 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest01598");

        SuperClass obj21341 = new SubClass();

        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        String bar = new Test144().doSomething(request, param);

        SuperClass obj09823 = new SubClass();

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().write(bar);
    } // end doPost

    private class Test144 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence

            List<String> list787231 = new ArrayList<>();
            list787231.add("geqrm");
            param = list787231.set(0, param);

            String a75770 = param; // assign
            StringBuilder b75770 = new StringBuilder(a75770); // stick in stringbuilder
            b75770.append(" SafeStuff"); // append some safe content
            b75770.replace(
                    b75770.length() - "Chars".length(),
                    b75770.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map75770 = new java.util.HashMap<String, Object>();
            map75770.put("key75770", b75770.toString()); // put in a collection
            String c75770 = (String) map75770.get("key75770"); // get it back out

            Object sealed09823 = new SealedSuper();

            String d75770 = c75770.substring(0, c75770.length() - 1); // extract most of it
            String e75770 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d75770.getBytes()))); // B64 encode and decode it
            String f75770 = e75770.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f75770); // reflection

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
