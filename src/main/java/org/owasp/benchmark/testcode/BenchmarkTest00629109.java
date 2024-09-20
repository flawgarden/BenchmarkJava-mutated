// CodeQL original results: [22]
// Snyk original results: [22]
// ApplicationInspector original results: []
// Semgrep original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [571, 570, 561, 209, 497, 79]
// ApplicationInspector analysis results: [73, 79]
// Snyk analysis results: [23]
// Semgrep analysis results: [200]
// Insider analysis results: [532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00629.java
// Original file CWE's: [22]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/for.tmt
// with name for_operator_strcpy_positive
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new LinkedList<>();
// | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_ListName@1 ->
// list787232 | MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new ArrayList<>(); |
// MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); |
// MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); |
// MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[EXPR_~[TYPE@1]~]~); | MACRO_Create_Stream
// -> Stream<~[TYPE@1]~> ~[MACRO_StreamName@1]~ = ~[MACRO_ListName@1]~.stream(); |
// MACRO_StreamName@1 -> stream787231 | MACRO_ListName@1 -> list787232 | EXPR_String ->
// ~[EXPR_String]~.toLowerCase()
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

import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/pathtraver-00/BenchmarkTest00629")
public class BenchmarkTest00629109 extends HttpServlet {

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
        String param = scr.getTheParameter("BenchmarkTest00629");
        if (param == null) param = "";

        String bar;

        // Simple if statement that assigns param to bar on true condition

        String tmpUnique42 = param;
        param = "";
        for (int i = 0; i < tmpUnique42.length(); i++) {
            char c = tmpUnique42.charAt(i);
            param = param + c;
        }

        int num = 196;
        if ((500 / 42) + num > 200) bar = param;
        else bar = "This should never happen";

        String fileName = org.owasp.benchmark.helpers.Utils.TESTFILES_DIR + bar;
        java.io.InputStream is = null;

        try {
            java.nio.file.Path path = java.nio.file.Paths.get(fileName);

            List<String> list787232 = new LinkedList<>();
            list787232.add(fileName);
            List<String> list1234 = new ArrayList<>();
            list1234.addAll(list787232);
            String value7846 = list1234.get(list1234.size() - 1);

            is = java.nio.file.Files.newInputStream(path, java.nio.file.StandardOpenOption.READ);
            byte[] b = new byte[1000];
            int size = is.read(b);
            response.getWriter()
                    .println(
                            "The beginning of file: '"
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(fileName)
                                    + "' is:\n\n");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(b, 0, size)));
            is.close();
        } catch (Exception e) {
            System.out.println("Couldn't open InputStream on file: '" + fileName + "'");
            response.getWriter()
                    .println(
                            "Problem getting InputStream: "
                                    + org.owasp
                                            .esapi
                                            .ESAPI
                                            .encoder()
                                            .encodeForHTML(e.getMessage()));
        } finally {
            if (is != null) {
                try {
                    is.close();

                    List<String> list787232 = new ArrayList<>();
                    list787232.add(bar);
                    list787232.add(bar);
                    list787232.add(response.encodeUrl(param).toLowerCase());
                    Stream<String> stream787231 = list787232.stream();
                    String value7844 =
                            stream787231.reduce((entry1, entry2) -> entry1 + entry2).get();

                    is = null;
                } catch (Exception e) {
                    // we tried...
                }
            }
        }
    }
}