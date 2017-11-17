package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {

  private UserService userService = new UserService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String userId = req.getParameter("userId");
    userService.deleteUserById(Integer.valueOf(userId));

    resp.setStatus(HttpServletResponse.SC_OK);
    resp.sendRedirect("/users/view");

  }
}
