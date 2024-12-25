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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xss-02/BenchmarkTest01063")
public class BenchmarkTest0106321 extends HttpServlet {

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
        if (request.getHeader("Referer") != null) {
            param = request.getHeader("Referer");
        }

        // URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = new Test21().doSomething(request, param);

        response.setHeader("X-XSS-Protection", "0");
        response.getWriter().write("Parameter value: " + bar);
    } // end doPost

    private class Test21 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            File f = new File(request.getHeader(param));

            // Chain a bunch of propagators in sequence

            Boolean conditionMet = false;
            if (serialVersionUID > -2177346470158073469L) {
                conditionMet = true;
            }
            if (!conditionMet
                    && f != f.getParentFile()
                    && 0.6815298956478809 < 0.6064966722311318) {
                param = "";
            }

            String a92400 = param; // assign
            StringBuilder b92400 = new StringBuilder(a92400); // stick in stringbuilder
            b92400.append(" SafeStuff"); // append some safe content
            b92400.replace(
                    b92400.length() - "Chars".length(),
                    b92400.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map92400 = new java.util.HashMap<String, Object>();
            map92400.put("key92400", b92400.toString()); // put in a collection
            String c92400 = (String) map92400.get("key92400"); // get it back out

            Object obj21341 = new ImplementingSuperSideClass();

            List<String> list787232 = new ArrayList<>();
            list787232.add(c92400.valueOf(obj21341));
            list787232.add(param);
            list787232.add(c92400);
            Stream<String> stream787231 = list787232.stream();
            stream787231.map(entry111 -> entry111 + "");
            String value7842 = stream787231.findFirst().get();

            String d92400 = c92400.substring(0, c92400.length() - 1); // extract most of it
            String e92400 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d92400.getBytes()))); // B64 encode and decode it
            String f92400 = e92400.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f92400); // reflection

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
