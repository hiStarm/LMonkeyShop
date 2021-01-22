package com.lmonkeyshop.servlet.user;

import com.lmonkeyshop.entity.LMONKEY_USER;
import com.lmonkeyshop.service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mzw
 * @date 2020/12/1 - 17:17
 */
@WebServlet(name = "admin_douserselect",urlPatterns = {"/manage/admin_douserselect"})
public class DoUserSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpage = 1;   //当前页
        int count = 5;   //每页显示条数
        String  cp=request.getParameter("cp");
        //接收用户搜索的关键字
        String keyword = request.getParameter("keywords");
        if (cp!=null){
            cpage=Integer.parseInt(cp);
        }
        int[] arr= LMONKEY_USERDao.totalPage(count,keyword);
        //获取用户记录
        ArrayList<LMONKEY_USER> list= null;
        list = LMONKEY_USERDao.selectAll(cpage,count,keyword);
        //放到请求对象域中
        request.setAttribute("userlist",list);
        request.setAttribute("tsum",arr[0]);
        request.setAttribute("tpage",arr[1]);
        request.setAttribute("cpage",cpage);
        if (keyword!=null){
            request.setAttribute("searchPram","&keywords="+keyword);
        }
        request.getRequestDispatcher("admin_user.jsp").forward(request,response);
    }
}
