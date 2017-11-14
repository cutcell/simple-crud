package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.User;

@WebServlet("/view")
public class UsersServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    List<User> users = new ArrayList<>();
    users.add(new User("1", "1", "1"));
    users.add(new User("2", "2", "2"));
    users.add(new User("3", "3", "3"));

    req.setAttribute("userList", users);

    System.out.println("forward to...");

    getServletContext()
        .getRequestDispatcher("/WEB-INF/UsersView.jsp")
        .forward(req, resp);

  }
}
