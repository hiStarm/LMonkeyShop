package com.lmonkeyshop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mzw
 * @date 2021/1/21 - 15:43
 */
@WebFilter("/manage/*")
public class AdminLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String isLogin = (String) session.getAttribute("isAdminLogin");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String substring = requestURI.substring(contextPath.length());
        if (substring.contains("admin_")){
            if (isLogin!=""&&isLogin=="1"){
                chain.doFilter(request, response);

            }else if (substring.contains("admin_login")){
                chain.doFilter(request, response);
            } else{
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('请先登录');");
                writer.write("location.href='admin_login.jsp';");
                writer.write("</script>");
                writer.close();
                return;
            }
        }else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
