package com.lmonkeyshop.servlet.home;

import com.lmonkeyshop.entity.LMONKEY_CATEGORY;
import com.lmonkeyshop.service.LMONKEY_CATEGORYDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<LMONKEY_CATEGORY> father = LMONKEY_CATEGORYDao.selectCate("father");
        request.setAttribute("flist",father);
        ArrayList<LMONKEY_CATEGORY> child = LMONKEY_CATEGORYDao.selectCate("child");
        request.setAttribute("clist",child);
        String fid=request.getParameter("fid");
        String cid=request.getParameter("cid");
        int id=0;
        if (fid!=null){
            id = Integer.parseInt(fid);
        }
        if (cid!=null){
            id = Integer.parseInt(cid);
        }
        request.setAttribute("title",LMONKEY_CATEGORYDao.selectByID(id).getCATE_NAME());

        request.getRequestDispatcher("productlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
