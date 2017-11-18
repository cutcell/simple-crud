package com.javamentor.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javamentor.model.User;
import com.javamentor.service.UserService;

@WebServlet("/view")
public class ViewUsers extends HttpServlet {

  private UserService userService = new UserService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    List<User> userList = userService.getAllUsers();
    req.setAttribute("userList", userList);

    getServletContext()
        .getRequestDispatcher("/WEB-INF/ViewUsers.jsp")
        .forward(req, resp);

  }

  @Override
  public void destroy() {

    UserService.close();
    super.destroy();

  }

}
