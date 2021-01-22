package com.lmonkeyshop.servlet.cate;

import com.lmonkeyshop.entity.LMONKEY_CATEGORY;
import com.lmonkeyshop.service.LMONKEY_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mzw
 * @date 2021/1/22 - 11:51
 */
@WebServlet("/manage/admin_tocateadd")
public class ToCateAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<LMONKEY_CATEGORY> lmonkey_categories = LMONKEY_CATEGORYDao.selectAll();

        request.setAttribute("catelist",lmonkey_categories);
        request.getRequestDispatcher("admin_cateadd.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
