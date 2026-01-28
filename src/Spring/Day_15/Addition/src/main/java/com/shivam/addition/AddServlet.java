package com.shivam.addition;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("add")
public class AddServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int a = Integer.parseInt(req.getParameter("num1"));
        int b = Integer.parseInt(req.getParameter("num2"));

        int k = a+b;
//        k *= k;
        PrintWriter wr = res.getWriter();
        wr.println("result: "+k);
    }
}
