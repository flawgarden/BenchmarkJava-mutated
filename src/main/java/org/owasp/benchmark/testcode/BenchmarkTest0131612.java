// CodeQL original results: [643]
// Snyk original results: [643]
// Semgrep original results: [643]
// ApplicationInspector original results: []
// Insider original results: []
// -------------
// CodeQL analysis results: [404, 772, 570, 571, 561, 79, 643]
// ApplicationInspector analysis results: []
// Snyk analysis results: [79, 643]
// Semgrep analysis results: []
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01316.java
// Original file CWE's: [643]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/collections/streams.tmt with name stream_reduce_positive
// Used extensions: MACRO_Regex -> "[^abc]" | MACRO_Create_List -> List<~[TYPE@1]~>
// ~[MACRO_ListName]~ = new ArrayList<>(); | MACRO_Add_Fixed_VAR_ToList ->
// ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_Add_CONST_ToList ->
// ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~]~); | MACRO_Create_Stream -> Stream<~[TYPE@1]~>
// ~[MACRO_StreamName]~ = ~[MACRO_ListName]~.stream(); | MACRO_StreamName -> stream787231 |
// MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 |
// MACRO_StreamName -> stream787231 | MACRO_ListName -> list787231
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xpathi-00/BenchmarkTest01316")
public class BenchmarkTest0131612 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

        Pattern pattern = Pattern.compile("[^abc]");
        Matcher matcher = pattern.matcher(request.getPathInfo());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String param = request.getParameter("BenchmarkTest01316");
        if (param == null) param = "";

        String bar = new Test12().doSomething(request, param);

        try {
            java.io.FileInputStream file =
                    new java.io.FileInputStream(
                            org.owasp.benchmark.helpers.Utils.getFileFromClasspath(
                                    "employees.xml", this.getClass().getClassLoader()));

            List<String> list787231 = new ArrayList<>();
            list787231.add(bar);
            list787231.add("qtiyv");
            Stream<String> stream787231 = list787231.stream();
            bar = stream787231.reduce((entry1, entry2) -> entry1 + entry2).get();

            javax.xml.parsers.DocumentBuilderFactory builderFactory =
                    javax.xml.parsers.DocumentBuilderFactory.newInstance();
            // Prevent XXE
            builderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            javax.xml.parsers.DocumentBuilder builder = builderFactory.newDocumentBuilder();
            org.w3c.dom.Document xmlDocument = builder.parse(file);
            javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
            javax.xml.xpath.XPath xp = xpf.newXPath();

            String expression = "/Employees/Employee[@emplid='" + bar + "']";
            String result = xp.evaluate(expression, xmlDocument);

            response.getWriter().println("Your query results are: " + result + "<br/>");

        } catch (javax.xml.xpath.XPathExpressionException
                | javax.xml.parsers.ParserConfigurationException
                | org.xml.sax.SAXException e) {
            response.getWriter()
                    .println(
                            "Error parsing XPath input: '"
                                    + org.owasp.esapi.ESAPI.encoder().encodeForHTML(bar)
                                    + "'");
            throw new ServletException(e);
        }
    } // end doPost

    private class Test12 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar;

            // Simple if statement that assigns param to bar on true condition
            int num = 196;
            if ((500 / 42) + num > 200) bar = param;
            else bar = "This should never happen";

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass