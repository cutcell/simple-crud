package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.User;
import service.UserService;

@WebServlet("/view")
public class UsersServlet extends HttpServlet {

  private final UserService userService = new UserService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Map<String, String[]> params = req.getParameterMap();

    if (params.containsKey("add")) {

      getServletContext()
          .getRequestDispatcher("/WEB-INF/AddUser.jsp")
          .forward(req, resp);

    } else if (params.containsKey("edit")) {

    } else if (params.containsKey("delete")) {

    } else {

      List<User> userList = userService.getAllUsers();
      req.setAttribute("userList", userList);

      getServletContext()
          .getRequestDispatcher("/WEB-INF/UsersView.jsp")
          .forward(req, resp);

    }

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

  @Override
  public void destroy() {
    userService.close();
    super.destroy();
  }
}
