package service;

import db.DBService;
import db.UserDAO;
import db.UserDataSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {

  private final DBService dbService;

  public UserService() {

    dbService = new DBService();

  }

  public void createUsersTable() {
    dbService.createUsersTable();
  }

  public List<User> getAllUsers() {

    List<User> result = new ArrayList<>();
    UserDAO userDAO = new UserDAO(dbService.getConnection());
    List<UserDataSet> users = userDAO.getAllUsers();
    for (UserDataSet user : users) {
      result.add(new User(user.getName(), user.getPhone(), user.getEmail()));
    }
    return result;

  }

  public void addNewUser(String name, String phone, String email) {

    UserDataSet newUser = new UserDataSet(name, phone, email);

    UserDAO userDAO = new UserDAO(dbService.getConnection());
    userDAO.insertUser(newUser);

  }

  public void close() {
    dbService.shutdown();
  }

}
