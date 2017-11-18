package com.javamentor.service;

import java.util.List;
import com.javamentor.model.User;

public interface UsersService {

  List<User> getAllUsers();

  void addNewUser(String name, String phone, String email);

  User getUserById(int id);

  void editUser(int id, User user);

  void deleteUserById(int id);

}
