package com.lmonkeyshop.servlet.user;

import com.lmonkeyshop.service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mzw
 * @date 2021/1/19 - 16:40
 */
@WebServlet("/userNameCheckServlet")
public class UserNameCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int count = LMONKEY_USERDao.selectByName(name);
        PrintWriter writer = response.getWriter();
        if (count>0){
            writer.print("false");
        }else{
            writer.print("true");
        }
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
