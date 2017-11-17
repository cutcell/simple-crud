package dao;

import java.util.List;
import model.User;

public interface UsersDAO {

  List<User> getAllUsers();

  User getUserById(int id);

  void insertUser(User newUser);

  void updateUser(int id, User newUser);

  void deleteUserById(int id);

}
