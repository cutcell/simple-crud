package com.javamentor.service;

import com.javamentor.dao.UserDao;
import com.javamentor.dao.UserDaoFactoryImpl;
import com.javamentor.model.User;
import java.util.List;

public class UserServiceImpl implements UsersService {

  private static UsersService instance;

  private UserDao usersDao;

  private UserServiceImpl() {
    usersDao = new UserDaoFactoryImpl().getUserDao();
  }

  public static UsersService getInstance() {

    if (instance == null) {
      synchronized (UserServiceImpl.class) {
        if (instance == null) {
          instance = new UserServiceImpl();
        }
      }
    }

    return instance;

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

}
