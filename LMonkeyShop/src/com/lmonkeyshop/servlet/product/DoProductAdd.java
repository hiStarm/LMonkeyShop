package com.lmonkeyshop.servlet.product;

import com.jspsmart.upload.*;
import com.lmonkeyshop.entity.LMONKEY_PRODUCT;
import com.lmonkeyshop.service.LMONKEY_PRODUCTDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_DoProductAdd")
public class DoProductAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //创建smartupload对象
        SmartUpload smartUpload=new SmartUpload();
        //初始化
        smartUpload.initialize(this.getServletConfig(),request,response);
        //上传
        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //获取上传文件对象
        Files files = smartUpload.getFiles();
        File file = files.getFile(0);
        //获取上传文件的名称
        String fileName = file.getFileName();
        try {
            smartUpload.save("img/product");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request request1 = smartUpload.getRequest();

        String productName = request1.getParameter("productName");
        String parentID = request1.getParameter("parentID");
        String[] split = parentID.split("-");
        int cid= Integer.parseInt(split[0]);
        int fid= Integer.parseInt(split[1]);
        int productPrice = Integer.parseInt(request1.getParameter("productPrice"));
        String productDesc = request1.getParameter("productDesc");
        int productStock = Integer.parseInt(request1.getParameter("productStock"));
        LMONKEY_PRODUCT lmonkey_product=new LMONKEY_PRODUCT(0,productName,productDesc,productPrice,productStock,fid,cid,fileName);
        int count = LMONKEY_PRODUCTDao.insert(lmonkey_product);
        if (count>0){
            response.sendRedirect("admin_ProductSelect");
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alter('用户添加失败');");
            writer.write("location.href='manage/admin_ToProductAdd';");
            writer.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
