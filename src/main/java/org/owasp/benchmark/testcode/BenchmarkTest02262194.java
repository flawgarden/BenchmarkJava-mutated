// CodeQL original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// -------------
// CodeQL analysis results: [561, 501]
// Semgrep analysis results: [200]
// Insider analysis results: []
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02262.java
// Original file CWE's: [501]
// Original file kind: fail
// Mutation info: Insert template from templates-db/languages/java/sensitivity/collections/list.tmt
// with name list_filter_neutral
// Used extensions: MACRO_Create_List -> List<~[TYPE@1]~> ~[MACRO_ListName]~ = new LinkedList<>(); |
// MACRO_Add_VAR_ToList -> ~[MACRO_ListName]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_Add_EXPR_ToList ->
// ~[MACRO_ListName]~.add(~[EXPR_~[TYPE@1]~@1]~); | MACRO_Add_CONST_ToList ->
// ~[MACRO_ListName]~.add(~[CONST_~[TYPE@1]~@1]~); | MACRO_ListName -> list787231 | MACRO_ListName
// -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName -> list787231 | MACRO_ListName ->
// list787231
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

@WebServlet(value = "/trustbound-01/BenchmarkTest02262")
public class BenchmarkTest02262194 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

        SimpleRecord recordEmpty = new SimpleRecord("");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BinaryOpInterface val89458 = (t, u) -> "";

        response.setContentType("text/html;charset=UTF-8");

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest02262");
            if (values != null) param = values[0];

            List<String> list787231 = new LinkedList<>();
            list787231.add(param);
            list787231.add(response.encodeRedirectUrl(param));
            list787231.add("ggcym");
            param = list787231.stream().filter(s -> 0.8690363F != 0.6354793F).findFirst().get();

            SimpleRecord recordEmpty = new SimpleRecord("");
        }

        String bar = doSomething(request, param);

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

        String bar = org.springframework.web.util.HtmlUtils.htmlEscape(param);

        return bar;
    }
}
