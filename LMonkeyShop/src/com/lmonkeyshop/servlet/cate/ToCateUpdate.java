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
 * @date 2021/1/22 - 14:29
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int cateID = Integer.parseInt(request.getParameter("id"));

        LMONKEY_CATEGORY category = LMONKEY_CATEGORYDao.selectByID(cateID);
        ArrayList<LMONKEY_CATEGORY> lmonkey_categories = LMONKEY_CATEGORYDao.selectAll();

        request.setAttribute("catelist",lmonkey_categories);
        request.setAttribute("cate",category);
        request.getRequestDispatcher("admin_catemodify.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
