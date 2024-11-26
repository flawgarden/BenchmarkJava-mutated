// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01287.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/field/nested.tmt with name nested_field_simple_array_negative
// Used extensions: MACRO_Regex -> (~[MACRO_Regex]~ + "*") | EXPR_String -> ~[EXPR_String]~.substring(~[EXPR_int]~) | MACRO_Regex -> "\r" | EXPR_int -> 42 | MACRO_VarName -> sealed21341
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cmdi-01/BenchmarkTest01287")
public class BenchmarkTest012871563 extends HttpServlet {

    Object sealed21341 = new SealedSuper();

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

        String param = request.getParameter("BenchmarkTest01287");
        if (param == null) param = "";

        String bar = new Test156().doSomething(request, param);

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());
        String[] args = {cmd};

        Pattern pattern = Pattern.compile(("\r" + "*"));
        Matcher matcher = pattern.matcher(request.getRemoteUser().substring(42));

        String[] argsEnv = {bar};

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args, argsEnv);
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));

            File f = new File(bar);

            return;
        }
    } // end doPost

    private class Test156 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String[] arr4124 = new String[] {""};
            NestedFields1 nested7231 = new NestedFields1(arr4124);
            param = nested7231.nested1.values[0];

            String bar = "";
            if (param != null) {
                bar =
                        new String(
                                org.apache.commons.codec.binary.Base64.decodeBase64(
                                        org.apache.commons.codec.binary.Base64.encodeBase64(
                                                param.getBytes())));
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
