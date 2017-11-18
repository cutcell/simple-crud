package com.javamentor.dao;

import java.util.List;
import com.javamentor.model.User;

public interface UserDao {

  List<User> getAllUsers();

  User getUserById(int id);

  void insertUser(User newUser);

  void updateUser(int id, User newUser);

  void deleteUserById(int id);

}
