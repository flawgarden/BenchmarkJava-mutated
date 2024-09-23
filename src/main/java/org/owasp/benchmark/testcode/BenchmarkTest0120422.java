// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01204.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/virtuality/class.tmt
// with name derived_binary_op2_positive
// Used extensions: MACRO_VarName -> sealed09823 | MACRO_Create_List -> List<~[TYPE@1]~>
// ~[MACRO_ListName@1]~ = new ArrayList<>(); | MACRO_Add_Element_ToList ->
// ~[MACRO_ListName@1]~.add(~[EXPR_~[TYPE@1]~]~); | MACRO_ListName@1 -> list787232
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-00/BenchmarkTest01204")
public class BenchmarkTest0120422 extends HttpServlet {

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
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest01204");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        String bar = new Test22().doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private class Test22 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            // Chain a bunch of propagators in sequence

            List<String> list787232 = new ArrayList<>();
            list787232.add(request.getRemoteUser());
            list787232.clear();
            String value7846 = list787232.get(0);

            String a40584 = param; // assign
            StringBuilder b40584 = new StringBuilder(a40584); // stick in stringbuilder
            b40584.append(" SafeStuff"); // append some safe content

            Object sealed09823 = new PermittedSub2();

            b40584.replace(
                    b40584.length() - "Chars".length(),
                    b40584.length(),
                    "Chars"); // replace some of the end content
            java.util.HashMap<String, Object> map40584 = new java.util.HashMap<String, Object>();
            map40584.put("key40584", b40584.toString()); // put in a collection
            String c40584 = (String) map40584.get("key40584"); // get it back out
            String d40584 = c40584.substring(0, c40584.length() - 1); // extract most of it
            String e40584 =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            d40584.getBytes()))); // B64 encode and decode it
            String f40584 = e40584.split(" ")[0]; // split it on a space

            BaseBinaryOpClass a12341 = new DerivedBinaryOpClass2();
            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();

            UnaryOpInterface val89458 = (t) -> c40584;

            f40584 = a12341.VirtualCall("", f40584);

            String bar = thing.doSomething(f40584); // reflection

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
