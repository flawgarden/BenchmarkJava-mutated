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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-00/BenchmarkTest01375")
public class BenchmarkTest0137593 extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";

        UnaryOpInterface val89458 =
                new UnaryOpInterface() {
                    @Override
                    public String InterfaceCall(String t) {
                        return "";
                    }
                };

        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest01375");
            if (values != null) param = values[0];
        }

        String bar = new Test93().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test93 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            GenericClass<String> genericClass39745 = new GenericClass<String>(request.getMethod());

            // Chain a bunch of propagators in sequence
            String a33070 = param; // assign
            StringBuilder b33070 = new StringBuilder(a33070); // stick in stringbuilder
            b33070.append(" SafeStuff"); // append some safe content
            b33070.replace(
                    b33070.length() - "Chars".length(),
                    b33070.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map33070 = new java.util.HashMap<String, Object>();
            map33070.put("key33070", b33070.toString()); // put in a collection
            String c33070 = (String) map33070.get("key33070"); // get it back out
            String d33070 = c33070.substring(0, c33070.length() - 1); // extract most of it

            d33070 = paramOrEmpty(-1, d33070);

            String e33070 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d33070.getBytes()))); // B64 encode and decode it
            String f33070 = e33070.split(" ")[0]; // split it on a space
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(f33070); // reflection

            return bar;
        }

        public String paramOrEmpty(int value, String param) {
            if (param.length() == value) {
                return param;
            } else if (value > param.length()) {
                paramOrEmpty(--value, param);
            } else {
                return "";
            }
            return "";
        }

        public String paramOrEmptyMutual1(int value, String param) {
            if (param.length() == value) {
                return param;
            } else if (value > param.length()) {
                paramOrEmptyMutual2(value, param);
            } else {
                return "";
            }
            return "";
        }

        public String paramOrEmptyMutual2(int value, String param) {
            return paramOrEmptyMutual1(--value, param);
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
