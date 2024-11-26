// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00325.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/varargs/varargs.tmt with name varargs_get_first_string_from_array_negative
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName@1]~ = new ArrayList<>(); | MACRO_Add_Element_ToList -> ~[MACRO_ListName@1]~.add(~[VAR_~[TYPE@1]~]~); | MACRO_ListName@1 -> list787233 | MACRO_VarName -> sealed09823
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

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/trustbound-00/BenchmarkTest00325")
public class BenchmarkTest00325168 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UnaryOpInterface val89458 =
                new UnaryOpInterface() {
                    @Override
                    public String InterfaceCall(String t) {
                        return "";
                    }
                };

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object sealed09823 = new PermittedSub1();

        String param = "";
        java.util.Enumeration<String> headers = request.getHeaders("BenchmarkTest00325");

        if (headers != null && headers.hasMoreElements()) {
            param = headers.nextElement(); // just grab first element
        }

        // URL Decode the header value since req.getHeaders() doesn't. Unlike req.getParameters().
        param = java.net.URLDecoder.decode(param, "UTF-8");

        param = getFirstStringFromArray(response.encodeURL(param), param);

        List<String> list787233 = new ArrayList<>();
        list787233.add(param);
        String value7841 = list787233.set(0, param);

        String bar = org.apache.commons.lang.StringEscapeUtils.escapeHtml(param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    }

    public String getFirstString(String... lines) {
        return getStringWithIndex(0, lines);
    }

    public String getStringWithIndex(int ind, String... lines) {
        return lines[ind];
    }

    public String getFirstStringFromArray(String... lines) {
        return Arrays.asList(lines).get(0);
    }

    public <T168> T168 varargsWithGenerics(T168... elements) {
        return elements[0];
    }

    public String combineStrings(String... strings) {
        return String.join(", ", strings);
    }
}
