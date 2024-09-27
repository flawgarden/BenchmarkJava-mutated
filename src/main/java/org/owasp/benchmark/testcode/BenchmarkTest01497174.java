// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01497.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/conditional/recursion.tmt with name
// recursion_mutual_positive
// Used extensions: MACRO_Regex -> "[a-d[m-p]]" | EXPR_String -> ~[EXPR_SimpleRecord]~.t() |
// EXPR_SimpleRecord -> ~[EXPR_NestedRecord]~.b() | EXPR_NestedRecord -> (new NestedRecord(new
// SimpleRecord(~[EXPR_String]~), new SimpleRecord(~[EXPR_String]~)))
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

@WebServlet(value = "/pathtraver-01/BenchmarkTest01497")
public class BenchmarkTest01497174 extends HttpServlet {

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

        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest01497");
        if (param == null) param = "";

        String bar = new Test174().doSomething(request, param);

        String fileName = null;
        java.io.FileOutputStream fos = null;

        try {
            fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;

            fos = new java.io.FileOutputStream(new java.io.File(fileName));
            response.getWriter()
                    .println(
                            "Now ready to write to file: "
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName));

        } catch (Exception e) {
            System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
            //			System.out.println("File exception caught and swallowed: " + e.getMessage());

            Pattern pattern = Pattern.compile("[a-d[m-p]]");

            bar = paramOrEmptyMutual1(bar.length(), bar);

            Matcher matcher =
                    pattern.matcher(
                            (new NestedRecord(
                                            new SimpleRecord(bar.intern()),
                                            new SimpleRecord("rrbiu")))
                                    .b()
                                    .t());

        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (Exception e) {
                    // we tried...
                }
            }
        }
    } // end doPost

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

    private class Test174 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar = "";
            if (param != null) {
                java.util.List<String> valuesList = new java.util.ArrayList<String>();

                UnaryOpInterface val89458 =
                        new UnaryOpInterface() {
                            @Override
                            public String InterfaceCall(String t) {
                                valuesList.add("safe");
                                valuesList.add(param);

                                return param.valueOf(serialVersionUID);
                            }
                        };

                valuesList.add("moresafe");

                File f = new File(bar);

                valuesList.remove(0); // remove the 1st safe value

                bar = valuesList.get(0); // get the param value
            }

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
