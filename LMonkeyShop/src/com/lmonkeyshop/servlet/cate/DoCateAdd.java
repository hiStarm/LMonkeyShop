package com.lmonkeyshop.servlet.cate;

import com.lmonkeyshop.entity.LMONKEY_CATEGORY;
import com.lmonkeyshop.service.LMONKEY_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mzw
 * @date 2021/1/22 - 14:00
 */
@WebServlet("/manage/admin_docateadd")
public class DoCateAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int parentID = Integer.parseInt(request.getParameter("parentID"));
        String className = request.getParameter("className");
        LMONKEY_CATEGORY lmonkey_category=new LMONKEY_CATEGORY(0,className,parentID);
        LMONKEY_CATEGORYDao.insert(lmonkey_category);
        response.sendRedirect("admin_CateSelect");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
