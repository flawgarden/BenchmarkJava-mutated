// CodeQL original results: [78]
// Semgrep original results: [78]
// Insider original results: [78]
// ApplicationInspector original results: []
// -------------
// CodeQL analysis results: [561, 497, 209]
// ApplicationInspector analysis results: [497]
// Semgrep analysis results: [200, 78]
// Insider analysis results: [78, 532]
// Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest00498.java
// Original file CWE's: [78]
// Original file kind: fail
// Mutation info: Insert template from
// templates-db/languages/java/sensitivity/reflection/reflection.tmt with name
// simple_reflection_negative
// Used extensions: EXPR_String -> ~[EXPR_String]~.trim() | EXPR_String -> "" | MACRO_Create_Map ->
// Map<~[TYPE@1]~, ~[TYPE@2]~> ~[MACRO_MapName@1]~ = new TreeMap<>(); | MACRO_Add_Element_ToMap ->
// ~[MACRO_MapName@1]~.put(~[VAR_~[TYPE@1]~]~, ~[VAR_~[TYPE@2]~]~); | MACRO_MapName@1 -> map787231
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

@WebServlet(value = "/cmdi-00/BenchmarkTest00498")
public class BenchmarkTest00498159 extends HttpServlet {

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

        java.util.Map<String, String[]> map = request.getParameterMap();
        String param = "";
        if (!map.isEmpty()) {
            String[] values = map.get("BenchmarkTest00498");
            if (values != null) param = values[0];

            Map<String, String> map787231 = new TreeMap<>();
            map787231.put(param, param);
            map787231.put(request.getContextPath(), param);
            String value7849 =
                    map787231.computeIfPresent(
                            request.getContextPath(), (k, v) -> v.equals("qppex") ? v : "bqpoc");
        }

        String bar = "";

        try {
            ReflectionHelper rh =
                    (ReflectionHelper)
                            ReflectionHelper.class.getConstructors()[0].newInstance(param);
            rh.getClass().getDeclaredFields()[0].set(rh, "bnkop");
            param = rh.getValue();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        if (param != null) {

            NestedRecord nested =
                    new NestedRecord(
                            new SimpleRecord(response.encodeURL(bar)), new SimpleRecord("".trim()));

            bar =
                    new String(
                            org.apache.commons.codec.binary.Base64.decodeBase64(
                                    org.apache.commons.codec.binary.Base64.encodeBase64(
                                            param.getBytes())));
        }

        String cmd =
                org.owasp.benchmark.helpers.Utils.getInsecureOSCommandString(
                        this.getClass().getClassLoader());
        String[] args = {cmd};
        String[] argsEnv = {bar};

        Runtime r = Runtime.getRuntime();

        try {
            Process p = r.exec(args, argsEnv, new java.io.File(System.getProperty("user.dir")));
            org.owasp.benchmark.helpers.Utils.printOSCommandResults(p, response);
        } catch (IOException e) {
            System.out.println("Problem executing cmdi - TestCase");
            response.getWriter()
                    .println(org.owasp.esapi.ESAPI.encoder().encodeForHTML(e.getMessage()));
            return;
        }
    }
}
