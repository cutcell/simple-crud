package com.javamentor.controller;

import com.javamentor.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/adm/*")
public class UserRoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        User currentUser = (User) session.getAttribute("user");

        req.setAttribute("currentUser", currentUser);

        if (currentUser.getRole().equals("user")) {
            resp.sendRedirect(req.getContextPath() + "/AccessRestricted.html");
        } else {
            filterChain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {

    }
}
