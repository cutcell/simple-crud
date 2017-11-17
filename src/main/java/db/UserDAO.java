package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

  private final Connection connection;

  public UserDAO(Connection connection) {
    this.connection = connection;
  }

  public List<UserDataSet> getAllUsers() {

    List<UserDataSet> result = new ArrayList<>();

    try (Statement stmt = connection.createStatement()) {
      ResultSet resultSet = stmt.executeQuery("SELECT * FROM users");
      while (resultSet.next()) {
        result.add(new UserDataSet(
            resultSet.getInt(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4)
        ));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;

  }

  public UserDataSet getUserByName(String name) {

    try (PreparedStatement stmt = connection
        .prepareStatement("SELECT name. phone, email FROM users WHERE name LIKE ?")) {

      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        return new UserDataSet(rs.getString(1),
            rs.getString(2), rs.getString(3));
      }


    } catch (SQLException e) {
      e.printStackTrace();
    }

    return new UserDataSet("", "", "");

  }

  public UserDataSet getUserById(int id) {

    try (PreparedStatement stmt = connection
        .prepareStatement("SELECT * FROM users WHERE id=?")) {

      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        return new UserDataSet(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return new UserDataSet("", "", "");

  }

  public void insertUser(UserDataSet newUser) {

    try (PreparedStatement stmt = connection
        .prepareStatement("INSERT INTO users (name, phone, email) VALUES (?, ?, ?)")) {

      stmt.setString(1, newUser.getName());
      stmt.setString(2, newUser.getPhone());
      stmt.setString(3, newUser.getEmail());

      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void updateUser(int id, UserDataSet newUser) {

    try (PreparedStatement stmt = connection
        .prepareStatement("UPDATE users\n"
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

  public void deleteUserById(int id) {

    try (PreparedStatement stmt = connection
        .prepareStatement("DELETE FROM users WHERE id=?")) {

      stmt.setInt(1, id);

      stmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }


}
