package com.javamentor.service;

import java.util.List;

import com.javamentor.model.User;

public interface UsersService {

    List<User> getAllUsers();

    void addNewUser(User newUser);

    User getUserById(int id);

    void editUser(int id, User user);

    void deleteUserById(int id);

    User getUserByLogin(String login);

}
