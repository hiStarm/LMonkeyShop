package com.lmonkeyshop.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mzw
 * @date 2021/1/19 - 17:54
 */
@WebServlet("/userCodeCheckServlet")
public class UserCodeCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String num = request.getParameter("num");
        HttpSession session=request.getSession();
        String code = (String) session.getAttribute("code");
        PrintWriter writer = response.getWriter();

        if (code.equals(num)){
            writer.print("true");
        }else {
            writer.print("false");
        }
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
