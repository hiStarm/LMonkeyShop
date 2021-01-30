package com.lmonkeyshop.servlet.product;

import com.lmonkeyshop.entity.LMONKEY_CATEGORY;
import com.lmonkeyshop.service.LMONKEY_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_ToProductAdd")
public class ToProductAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        ArrayList<LMONKEY_CATEGORY> father = LMONKEY_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",father);
        ArrayList<LMONKEY_CATEGORY> child = LMONKEY_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",child);

        request.getRequestDispatcher("admin_productadd.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
