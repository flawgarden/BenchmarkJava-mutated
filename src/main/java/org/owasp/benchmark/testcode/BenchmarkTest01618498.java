// CodeQL original results: [501]
// Semgrep original results: [501]
// Insider original results: []
// SonarQube original results: []
// CodeQL analysis results: [561]
// Semgrep analysis results: [200, 501, 79]
// Insider analysis results: []
// SonarQube analysis results: []
// Original file name: BenchmarkTest01618.java
// Original file CWE's: [501]
// Mutation info: Insert template from templates/inheritance/interfaces.tmt with index 4
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
import org.owasp.benchmark.helpers.inheritance.*;

@WebServlet(value = "/trustbound-00/BenchmarkTest01618")
public class BenchmarkTest01618498 extends HttpServlet {

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

        String[] values = request.getParameterValues("BenchmarkTest01618");
        String param;
        if (values != null && values.length > 0) param = values[0];
        else param = "";

        ImplementingSuperClass obj = new ImplementingSuperClass();
        param = handleSuperInterface(obj, response.encodeURL(param));
        String bar = new Test498().doSomething(request, param);

        // javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
        request.getSession().setAttribute("userid", bar);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(bar)
                                + "' saved in session.");
    } // end doPost

    public String handleSuperInterface(SuperInterface superInterfaceObj, String param) {
        if (superInterfaceObj instanceof SubInterface subInterfaceObj) {
            return subInterfaceObj.superInterfaceMethod("");
        } else if (superInterfaceObj instanceof SideInterface sideInterfaceObj) {
            return sideInterfaceObj.sideInterfaceMethod(param);
        } else {
            return "";
        }
    }

    private class Test498 {

        public String doSomething(HttpServletRequest request, String param)
                throws ServletException, IOException {

            org.owasp.benchmark.helpers.ThingInterface thing =
                    org.owasp.benchmark.helpers.ThingFactory.createThing();
            String bar = thing.doSomething(param);

            return bar;
        }
    } // end innerclass Test
} // end DataflowThruInnerClass
