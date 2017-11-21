package com.javamentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.javamentor.model.User;

public class UserDaoJdbc implements UserDao {

  private Connection connection;

  public UserDaoJdbc(Connection connection) {
    this.connection = connection;
  }

  public UserDaoJdbc() {
  }

  @Override
  public List<User> getAllUsers() {

    List<User> result = new ArrayList<>();

    try (PreparedStatement stmt = connection
        .prepareStatement("SELECT * FROM USERS")) {

      ResultSet resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        result.add(new User(
            resultSet.getInt(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4)
        ));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;

  }

  @Override
  public User getUserById(int id) {

    try (PreparedStatement stmt = connection
        .prepareStatement("SELECT * FROM USERS WHERE id=?")) {

      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        return new User(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return new User("", "", "");

  }

  @Override
  public void insertUser(User newUser) {

    try (PreparedStatement stmt = connection
        .prepareStatement("INSERT INTO USERS (name, phone, email) VALUES (?, ?, ?)")) {

      stmt.setString(1, newUser.getName());
      stmt.setString(2, newUser.getPhone());
      stmt.setString(3, newUser.getEmail());

      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void updateUser(int id, User newUser) {

    try (PreparedStatement stmt = connection
        .prepareStatement("UPDATE USERS\n"
            + "SET name=?, phone=?, email=?\n"
            + "WHERE id=?")) {

      stmt.setString(1, newUser.getName());
      stmt.setString(2, newUser.getPhone());
      stmt.setString(3, newUser.getEmail());
      stmt.setInt(4, id);

      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void deleteUserById(int id) {

    try (PreparedStatement stmt = connection
        .prepareStatement("DELETE FROM USERS WHERE id=?")) {

      stmt.setInt(1, id);

      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }
}
