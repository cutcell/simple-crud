package com.javamentor.service;

import com.javamentor.dao.UserDao;
import com.javamentor.dao.UserDaoHibernate;
import java.util.List;
import com.javamentor.model.User;
import com.javamentor.util.DBHelper;

public class UserService implements UsersService {

  private UserDao usersDao = new UserDaoHibernate();

  public static void createUsersTable() {
    DBHelper.createUsersTable();
  }

  public List<User> getAllUsers() {

    return usersDao.getAllUsers();

  }

  public void addNewUser(String name, String phone, String email) {

    usersDao.insertUser(new User(name, phone, email));

  }

  public User getUserById(int id) {

    return usersDao.getUserById(id);

  }

  public void editUser(int id, User user) {

    usersDao.updateUser(id, user);

  }

  public void deleteUserById(int id) {

    usersDao.deleteUserById(id);

  }

  public static void close() {
    DBHelper.shutdown();
  }

}
