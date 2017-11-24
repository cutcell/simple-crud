package com.javamentor.controller;

import com.javamentor.model.User;
import com.javamentor.service.UserServiceImpl;
import com.javamentor.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private UsersService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        getServletContext()
                .getRequestDispatcher("/WEB-INF/Login.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User loginUser = userService.getUserByLogin(login);

        if (loginUser == null || !loginUser.getPassword().equals(password)) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        req.getSession().setAttribute("user", loginUser);

        resp.setStatus(HttpServletResponse.SC_OK);

        if (loginUser.getRole().equals("user")) {
            resp.sendRedirect(req.getContextPath() + "/info");
        } else {
            resp.sendRedirect(req.getContextPath() + "/adm/view");
        }

    }

}
