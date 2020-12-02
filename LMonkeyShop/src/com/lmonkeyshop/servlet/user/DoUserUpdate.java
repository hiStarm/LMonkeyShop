package com.lmonkeyshop.servlet.user;

import com.lmonkeyshop.entity.LMONKEY_USER;
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
 * @date 2020/12/2 - 17:26
 */
@WebServlet(name = "admin_douserupdate",urlPatterns = {"/manage/admin_douserupdate"})
public class DoUserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String username=request.getParameter("userName");
        String name=request.getParameter("name");
        String pwd=request.getParameter("passWord");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String email=request.getParameter("email");
        String mobile=request.getParameter("mobile");
        String address=request.getParameter("address");
        String userstatus=request.getParameter("userStatus");

        int status = 1;
        if (userstatus!=null){
            status=Integer.parseInt(userstatus);
        }
        //创建用户实体
        LMONKEY_USER user=new LMONKEY_USER(username,name,pwd,sex,birthday,null,
                email,mobile,address,status);

        //加入到数据库的用户表中
        int count= LMONKEY_USERDao.update(user);
        //成功或失败定向到哪里
        if (count>0){
            response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
        }else{
            PrintWriter out=response.getWriter();
            out.write("<script>");
            out.write("alert('用户修改失败')");
            out.write("location.href='manage/admin_touserupdate?id='"+username+"'");
            out.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
