package com.app.filters;

import com.app.entities.UserAccount;
import com.app.utils.AppUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/adminpage")
public class SecurityFilter implements Filter {


    public SecurityFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            UserAccount loginedUser = AppUtils.getLoginedUser(request.getSession());

            if ((loginedUser == null) || (loginedUser.getCustomer().getUserRole().equals("user"))) {

                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            else if (loginedUser.getCustomer().getUserRole().equals("admin")) {
                filterChain.doFilter(request, response);
            }
    }

    @Override
    public void destroy() {
    }

}


