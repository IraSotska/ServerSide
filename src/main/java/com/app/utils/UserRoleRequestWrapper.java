package com.app.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

    private String role = null;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String role, HttpServletRequest request) {
        super(request);
        this.role = role;
        this.realRequest = request;
    }

    public UserRoleRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public boolean isUserInRole(String role) {

        boolean checked = false;

        if (role.equals("admin")) {
            checked = true;
        }

        return checked;
    }


}
