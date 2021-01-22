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
 * @date 2021/1/20 - 20:01
 */
@WebServlet("/manage/adminLogin")
public class AdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        int count = LMONKEY_USERDao.selectByNP(userName, passWord);
        if (count>0){
            LMONKEY_USER user = LMONKEY_USERDao.selectAdmin(userName, passWord);
            HttpSession session = request.getSession();
            session.setAttribute("name",user);
            session.setAttribute("isLogin","1");
            if(user.getUSER_STATUS()==2){
                session.setAttribute("isAdminLogin","1");
                response.sendRedirect("admin_index.jsp");

            }else {
                response.sendRedirect("/shop/index.jsp");

            }

        }else {
            PrintWriter writer = response.getWriter();

            writer.write("<script>");
            writer.write("alert('用户登陆失败');");
            writer.write("location.href='admin_login.jsp';");
            writer.write("</script>");
            writer.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
