package com.lmonkeyshop.servlet.user;

import com.lmonkeyshop.entity.LMONKEY_USER;
import com.lmonkeyshop.service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mzw
 * @date 2020/12/2 - 16:25
 */
@WebServlet(name = "admin_touserupdate",urlPatterns = {"/manage/admin_touserupdate"})
public class ToUserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");

        LMONKEY_USER user = LMONKEY_USERDao.selectByID(id);

        request.setAttribute("user",user);
        request.setAttribute("cpage",request.getParameter("cpage"));
        request.getRequestDispatcher("admin_usermodify.jsp").forward(request,response);
    }
}
