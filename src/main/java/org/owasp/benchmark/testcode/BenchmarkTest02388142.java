//CodeQL original results: [328]
//ApplicationInspector original results: [328]
//Snyk original results: [328]
//Semgrep original results: [328]
//Insider original results: []
//-------------
//CodeQL analysis results: [561, 79, 328, 327]
//ApplicationInspector analysis results: []
//Snyk analysis results: [916]
//Semgrep analysis results: [328]
//Insider analysis results: [327, 532]
//Original file name: src/main/java/org/owasp/benchmark/testcode/BenchmarkTest02388.java
//Original file CWE's: [328]  
//Original file kind: fail
//Mutation info: Insert template from templates-db/languages/java/sensitivity/conditional/for.tmt with name for_operator_nested_negative 
//Used extensions: MACRO_VarName -> obj39745 | MACRO_Create_Set -> Set<~[TYPE@1]~> ~[MACRO_SetName@1]~ = new LinkedHashSet<>(); | MACRO_Add_Element_ToSet -> ~[MACRO_SetName@1]~.add(~[EXPR_~[TYPE@1]~]~); | MACRO_Add_Fixed_Element_ToSet -> ~[MACRO_SetName@1]~.add(~[VAR_~[TYPE@1]~@1]~); | MACRO_SetName@1 -> set787233
//Program:
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.*;
import java.util.*;
import java.util.*;
import java.io.*;

@WebServlet(value = "/hash-02/BenchmarkTest02388")
public class BenchmarkTest02388142 extends HttpServlet {

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
        String param = scr.getTheParameter("BenchmarkTest02388");
        if (param == null) param = "";

        String bar = doSomething(request, param);

UnaryOpInterface val89458 = (t) -> "";

try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] input = {(byte) '?'};
            Object inputParam = bar;
            if (inputParam instanceof String) input = ((String) inputParam).getBytes();
            if (inputParam instanceof java.io.InputStream) {
                byte[] strInput = new byte[1000];
                int i = ((java.io.InputStream) inputParam).read(strInput);
                if (i == -1) {
                    response.getWriter()
                            .println(
                                    "This input source requires a POST, not a GET. Incompatible UI for the InputStream source.");
                    return;
                }
                input = java.util.Arrays.copyOf(strInput, i);
            }
            md.update(input);

            byte[] result = md.digest();
            java.io.File fileTarget =
                    new java.io.File(
                            new java.io.File(org.owasp.benchmark.helpers.Utils.TESTFILES_DIR),
                            "passwordFile.txt");
            java.io.FileWriter fw =
                    new java.io.FileWriter(fileTarget, true); // the true will append the new data
            fw.write(
                    "hash_value="
                            + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true)
                            + "\n");
            fw.close();
            response.getWriter()
                    .println(
                            "Sensitive value '"
                                    + org.owasp
                                            .esapi
                                            .ESAPI
                                            .encoder()
                                            .encodeForHTML(new String(input))
                                    + "' hashed and stored<br/>");

        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Problem executing hash - TestCase");
            throw new ServletException(e);
        }

        response.getWriter()
                .println(
                        "Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
    } // end doPost

    private static String doSomething(HttpServletRequest request, String param)
            throws ServletException, IOException {

Object obj39745 = new ImplementingSuperSideClass();

Set<String> set787233 = new LinkedHashSet<>();
set787233.add(obj39745.toString());
set787233.add(param);
String value7845 = "sjssi";

if (set787233.contains(param)) {
    value7845 = param;
}

for (int i = 0; i < obj39745.hashCode(); i++) {
    for (int j = 0; j < param.length(); j++) {
        value7845 = "";
    }
}

String bar = "safe!";
        java.util.HashMap<String, Object> map94322 = new java.util.HashMap<String, Object>();
        map94322.put("keyA-94322", "a_Value"); // put some stuff in the collection
        map94322.put("keyB-94322", param); // put it in a collection
        map94322.put("keyC", "another_Value"); // put some stuff in the collection
        bar = (String) map94322.get("keyB-94322"); // get it back out
        bar = (String) map94322.get("keyA-94322"); // get safe value back out

        return bar;
    }
}
