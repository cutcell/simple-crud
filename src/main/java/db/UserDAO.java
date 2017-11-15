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
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3)
        ));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;

  }

  public List<UserDataSet> getUserByName() {
    return null;
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

  public void updateUser(UserDataSet oldUser, UserDataSet newUser) {

  }

  public void deleteUser(UserDataSet user) {

  }


}
