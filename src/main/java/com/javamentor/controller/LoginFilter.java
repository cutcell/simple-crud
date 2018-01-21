package com.javamentor.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        String loginURI = req.getContextPath() + "/login";

        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean userLoggedIn = session != null && session.getAttribute("user") != null;

        if (loginRequest || userLoggedIn) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURI);
        }

    }

    @Override
    public void destroy() {

    }
}
