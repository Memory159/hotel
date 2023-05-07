package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        // 判断访问资源路径是否和登录注册相关
        String[] urls = {"/userLogin.jsp","/imgs/","/css/","register.jsp","adminLogin.jsp","/login/logCustomer","/login/registerCustomer","/login/logAdmin","/login/CheckCode"};
        // 获取当前访问的资源路径
        String url = req.getRequestURL().toString();
        // 循环判断
        for (String u : urls) {
            if(url.contains(u)){
                // 放行
                chain.doFilter(request,resp);
                return;
            }
        }


        // 判断session 中是否有 customer
        HttpSession session = req.getSession();
        Object customer = session.getAttribute("customer");
        // 判断session 中是否有 admin
        Object admin = session.getAttribute("admin");


        // 判断customer 和 admin 是否为 null
        if(customer != null || admin != null) {
            // 登录过了
            // 放行
            chain.doFilter(req, resp);
        }else {
            // 没有登录，存储提示信息，跳转到登录页面
            req.setAttribute("login_msg","您尚未登录");
            if(customer == null){
                req.getRequestDispatcher("/userLogin.jsp").forward(req,resp);
            }
            else if(admin == null){
                req.getRequestDispatcher("/adminLogin.jsp").forward(req,resp);
            }
        }

    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
