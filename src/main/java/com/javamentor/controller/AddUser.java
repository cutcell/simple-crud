package com.javamentor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javamentor.service.UserService;

@WebServlet("/add")
public class AddUser extends HttpServlet {

  private UserService userService = new UserService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    getServletContext()
        .getRequestDispatcher("/WEB-INF/AddUser.jsp")
        .forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String name = req.getParameter("name");
    String phone = req.getParameter("phone");
    String email = req.getParameter("email");

    userService.addNewUser(name, phone, email);

    resp.setStatus(HttpServletResponse.SC_OK);
    resp.sendRedirect("/users/view");


  }

}
