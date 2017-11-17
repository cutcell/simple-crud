package service;

import dao.UserDAO;
import java.util.List;
import model.User;
import util.DBHelper;

public class UserService implements UsersService {

  public static void createUsersTable() {
    DBHelper.createUsersTable();
  }

  public List<User> getAllUsers() {

    UserDAO userDAO = new UserDAO(DBHelper.getConnection());
    return userDAO.getAllUsers();

  }

  public void addNewUser(String name, String phone, String email) {

    User newUser = new User(name, phone, email);
    UserDAO userDAO = new UserDAO(DBHelper.getConnection());
    userDAO.insertUser(newUser);

  }

  public User getUserById(int id) {

    UserDAO userDAO = new UserDAO(DBHelper.getConnection());
    return userDAO.getUserById(id);

  }

  public void editUser(int id, User user) {

    UserDAO userDAO = new UserDAO(DBHelper.getConnection());
    userDAO.updateUser(id, user);

  }

  public void deleteUserById(int id) {

    UserDAO userDAO = new UserDAO(DBHelper.getConnection());
    userDAO.deleteUserById(id);

  }

  public static void close() {
    DBHelper.shutdown();
  }

}
