//CodeQL original results: [501]
//ApplicationInspector original results: [501]
//Snyk original results: [501]
//Semgrep original results: [501]
//Insider original results: []
//-------------
//CodeQL analysis results: []
//ApplicationInspector analysis results: []
//Snyk analysis results: [501]
//Semgrep analysis results: [501, 79]
//Insider analysis results: []
//Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00031.java
//Original file CWE's: [501]  
//Original file kind: fail
//Mutation info: Insert template from templates-db/languages/java/sensitivity/virtuality/default.tmt with name binary_op_interface_default1_negative 
//Used extensions: MACRO_VarName -> sealed12321
//Program:
/**
 * OWASP Benchmark v1.2
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.*;

@WebServlet(value = "/trustbound-00/BenchmarkTest00031")
public class BenchmarkTest00031137 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

Object sealed12321 = new PermittedSub1();

@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // some code
        response.setContentType("text/html;charset=UTF-8");

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            
BinaryOpInterfaceDefault1 a12341 = new BinaryOpInterfaceDefault1Implementation();
String[] values = map.get("BenchmarkTest00031");
            if (values != null) param = values[0];
        
param = a12341.InterfaceCall("", param);

        }

        // javax.servlet.http.HttpSession.putValue(java.lang.String,java.lang.Object^)
        request.getSession().putValue("userid", param);

        response.getWriter()
                .println(
                        "Item: 'userid' with value: '"
                                + org.owasp.benchmark.helpers.Utils.encodeForHTML(param)
                                + "' saved in session.");
    }
}
