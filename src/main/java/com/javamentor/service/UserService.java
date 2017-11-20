package com.javamentor.service;

import com.javamentor.dao.UserDao;
import com.javamentor.dao.UserDaoFactoryImpl;
import com.javamentor.model.User;
import com.javamentor.util.DBHelper;
import java.util.List;

public class UserService implements UsersService {

  private UserDao usersDao = new UserDaoFactoryImpl().getUserDao();

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
    DBHelper.getInstance().shutdown();
  }

}
