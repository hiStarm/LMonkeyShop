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
 * @date 2020/12/2 - 18:07
 */
@WebServlet(name = "admin_douserdel",urlPatterns = {"/manage/admin_douserdel"})
public class DoUserDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String ids[]=request.getParameterValues("id[]");
        for (int i=0;i<ids.length;i++){
            LMONKEY_USERDao.delByID(ids[i]);
        }
        response.sendRedirect("admin_douserselect");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String id=request.getParameter("id");

        //加入到数据库的用户表中
        int count= LMONKEY_USERDao.delByID(id);
        //成功或失败定向到哪里
        if (count>0){
            response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
        }else{
            PrintWriter out=response.getWriter();
            out.write("<script>");
            out.write("alert('用户删除失败')");
            out.write("location.href='manage/admin_touserupdate?cp="+request.getParameter("cpage")+"'");
            out.write("</script>");
        }
    }
}
