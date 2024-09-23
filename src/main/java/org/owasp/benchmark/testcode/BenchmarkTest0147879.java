// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest01478.java
// Original file CWE's: [643]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/collections/streams.tmt with name stream_map_positive
// Used extensions: MACRO_VarName -> sealed09823 | MACRO_Create_List -> List<~[TYPE@1]~>
// ~[MACRO_ListName]~ = new ArrayList<>(); | MACRO_Add_Fixed_EXPR_ToList ->
// ~[MACRO_ListName]~.add(~[EXPR_~[TYPE@1]~@1]~); | MACRO_Add_Fixed_CONST_ToList ->
// ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~@1]~); | MACRO_Add_Fixed_VAR_ToList ->
// ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_Create_Stream -> Stream<~[TYPE@1]~>
// ~[MACRO_StreamName]~ = ~[MACRO_ListName]~.stream(); | MACRO_StreamName -> stream787231 |
// MACRO_StreamName -> stream787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 |
// MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_StreamName -> stream787231 |
// MACRO_ListName -> list787231
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
import java.util.stream.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/xpathi-00/BenchmarkTest01478")
public class BenchmarkTest0147879 extends HttpServlet {

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
        boolean flag = true;
        java.util.Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements() && flag) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length && flag; i++) {
                    String value = values[i];
                    if (value.equals("BenchmarkTest01478")) {
                        param = name;
                        flag = false;
                    }
                }
            }
        }

        Object sealed09823 = new PermittedSub2();

        String bar = new Test79().doSomething(request, param);

        try {
            java.io.FileInputStream file =
                    new java.io.FileInputStream(
                            org.owasp.benchmark.helpers.Utils.getFileFromClasspath(
                                    "employees.xml", this.getClass().getClassLoader()));

            List<String> list787231 = new ArrayList<>();
            list787231.add(response.encodeURL(param));
            list787231.add("ktpvr");
            list787231.add(bar);
            Stream<String> stream787231 = list787231.stream();
            stream787231.map(entry111 -> entry111 + "gtpoy");
            bar = stream787231.findFirst().get();

            javax.xml.parsers.DocumentBuilderFactory builderFactory =
                    javax.xml.parsers.DocumentBuilderFactory.newInstance();
            // Prevent XXE
            builderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            javax.xml.parsers.DocumentBuilder builder = builderFactory.newDocumentBuilder();
            org.w3c.dom.Document xmlDocument = builder.parse(file);
            javax.xml.xpath.XPathFactory xpf = javax.xml.xpath.XPathFactory.newInstance();
            javax.xml.xpath.XPath xp = xpf.newXPath();

            String expression = "/Employees/Employee[@emplid='" + bar + "']";
            org.w3c.dom.NodeList nodeList =
                    (org.w3c.dom.NodeList)
                            xp.compile(expression)
                                    .evaluate(xmlDocument, javax.xml.xpath.XPathConstants.NODESET);

            response.getWriter().println("Your query results are: <br/>");

            for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Element value = (org.w3c.dom.Element) nodeList.item(i);
                response.getWriter().println(value.getTextContent() + "<br/>");
            }
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

    private class Test79 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            String bar;

            // Simple ? condition that assigns param to bar on false condition
            int num = 106;

            bar = (7 * 42) - num > 200 ? "This should never happen" : param;

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
