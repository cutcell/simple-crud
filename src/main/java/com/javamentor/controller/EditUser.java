package com.javamentor.controller;

import com.javamentor.service.UsersService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javamentor.model.User;
import com.javamentor.service.UserServiceImpl;

@WebServlet("/adm/edit")
public class EditUser extends HttpServlet {

    private UsersService userService = UserServiceImpl.getInstance();

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userId = req.getParameter("userId");
        User editUser = userService.getUserById(Integer.valueOf(userId));

        req.setAttribute("editUser", editUser);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/EditUser.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        userService.editUser(Integer.valueOf(id),
                new User.Builder()
                        .login(login)
                        .password(password)
                        .role(role)
                        .name(name)
                        .phone(phone)
                        .email(email)
                        .build()
        );

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect(req.getContextPath() + "/adm/view");

    }

}
