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
 * @date 2021/1/19 - 18:58
 */
@WebFilter("/register")
public class Register implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        PrintWriter writer = response.getWriter();
        if (userName.equals("")){
            writer.write("<script>");
            writer.write("alert('用户名不能为空');");
            writer.write("location.href='reg.jsp';");
            writer.write("</script>");
            writer.close();
            return;
        }

        HttpSession session = request.getSession();
        String veryCode = request.getParameter("veryCode");
        String code = (String) session.getAttribute("code");
        if (!veryCode.equals(code)){

            writer.write("<script>");
            writer.write("alert('验证码错误');");
            writer.write("location.href='reg.jsp';");
            writer.write("</script>");
            writer.close();
            return;
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
