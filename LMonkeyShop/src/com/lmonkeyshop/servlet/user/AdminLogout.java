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
 * @date 2021/1/20 - 20:54
 */
@WebServlet("/manage/adminLogout")
public class AdminLogout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();

        session.removeAttribute("name");
        session.removeAttribute("isLogin");
        session.removeAttribute("isAdminLogin");
        PrintWriter out=response.getWriter();
        out.write("<script>");
        out.write("alert('退出成功');");
        out.write("location.href='admin_login.jsp';");
        out.write("</script>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
