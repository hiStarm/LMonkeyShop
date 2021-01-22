package com.lmonkeyshop.servlet.user;

import com.lmonkeyshop.entity.LMONKEY_USER;
import com.lmonkeyshop.service.LMONKEY_USERDao;

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
 * @date 2021/1/19 - 19:29
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        int count = LMONKEY_USERDao.selectByNP(userName, passWord);
        if (count>0){
            HttpSession session = request.getSession();
            LMONKEY_USER user = LMONKEY_USERDao.selectAdmin(userName, passWord);

            session.setAttribute("name",user);
            session.setAttribute("isLogin","1");
            response.sendRedirect("index.jsp");
        }else {
            PrintWriter writer = response.getWriter();

            writer.write("<script>");
            writer.write("alert('用户登陆失败');");
            writer.write("location.href='login.jsp';");
            writer.write("</script>");
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
