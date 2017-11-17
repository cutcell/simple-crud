package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

  private static Connection CONNECTION = getH2Connection();

  public static Connection getConnection() {

    if (CONNECTION == null) {
      CONNECTION = getH2Connection();
    }

    return CONNECTION;

  }

  public static void createUsersTable() {

    if (usersTableExists()) {
      return;
    }

    try (Statement stmt = CONNECTION.createStatement()) {
      stmt.executeUpdate("CREATE TABLE users (\n"
          + "  id INT IDENTITY(1,1) PRIMARY KEY,\n"
          + "  name VARCHAR(255),\n"
          + "  phone VARCHAR(25),\n"
          + "  email VARCHAR(255)\n"
          + ")");
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  private static boolean usersTableExists() {
    try {
      DatabaseMetaData dbMetadata = CONNECTION.getMetaData();
      ResultSet tables = dbMetadata.getTables(null, null, "USERS", new String[] {"TABLE"});
      return tables.next();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static void shutdown() {
    try {
      CONNECTION.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static Connection getH2Connection() {

    Connection connection = null;
    try {
      Class.forName("org.h2.Driver");
      connection = DriverManager.getConnection("jdbc:h2:./h2", "sa", "");
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return connection;

  }
}
