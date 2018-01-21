package com.javamentor.controller;

import com.javamentor.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class UserInfo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currentUser = (User) req.getSession().getAttribute("user");
        req.setAttribute("currentUser", currentUser);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/UserInfo.jsp")
                .forward(req, resp);

    }

}
