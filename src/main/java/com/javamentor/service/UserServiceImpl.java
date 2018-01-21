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

    @Override
    public List<User> getAllUsers() {

        return usersDao.getAllUsers();

    }

    @Override
    public void addNewUser(User newUser) {

        usersDao.insertUser(newUser);

    }

    @Override
    public User getUserById(int id) {

        return usersDao.getUserById(id);

    }

    @Override
    public void editUser(int id, User user) {

        usersDao.updateUser(id, user);

    }

    @Override
    public void deleteUserById(int id) {

        usersDao.deleteUserById(id);

    }

    @Override
    public User getUserByLogin(String login) {
        return usersDao.getUserByLogin(login);
    }

}
