//package com.app.filters;
//
//import com.app.entities.Customer;
//import com.app.entities.UserAccount;
//import com.app.utils.AppUtils;
//import com.app.utils.UserRoleRequestWrapper;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class SecurityFilter implements Filter {
//
//
//    public SecurityFilter() {
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//            HttpServletRequest request = (HttpServletRequest) servletRequest;
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//            String servletPath = request.getServletPath();
//
//            UserAccount loginedUser = AppUtils.getLoginedUser(request.getSession());
//
//            if (servletPath.equals("/adminpage")) {
//                filterChain.doFilter(request, response);
//                return;
//            }
//            HttpServletRequest wrapRequest = request;
//
//            if ((loginedUser == null) || (loginedUser.getCustomer().getUserRole().equals("user"))) {
//
//                response.sendRedirect( "/ServerSide:war");
//                return;
//            }
//
//            filterChain.doFilter(wrapRequest, response);
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//}
//
//
