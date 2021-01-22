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
 * @date 2021/1/22 - 15:17
 */
@WebServlet("/manage/admin_docatupdate")
public class DoCateUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int parentID = Integer.parseInt(request.getParameter("parentID"));
        String className = request.getParameter("className");
        int id = Integer.parseInt(request.getParameter("id"));

        LMONKEY_CATEGORY lmonkey_category=new LMONKEY_CATEGORY(id,className,parentID);
        LMONKEY_CATEGORYDao.update(lmonkey_category);
        response.sendRedirect("admin_CateSelect");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
