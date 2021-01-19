package com.lmonkeyshop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
