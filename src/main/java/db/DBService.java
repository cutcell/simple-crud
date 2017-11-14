package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

  private final Connection connection;

  public DBService() {
    this.connection = getH2Connection();
  }

  private static Connection getH2Connection() {

    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:h2:./h2", "sa", "");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return connection;

  }

  public void createUsersTable() {

    if (usersTableExists()) {
      return;
    }

    try (Statement stmt = connection.createStatement()) {
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

  private boolean usersTableExists() {
    try {
      DatabaseMetaData dbMetadata = connection.getMetaData();
      ResultSet tables = dbMetadata.getTables(null, null, "USERS", new String[] {"TABLE"});
      return tables.next();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }


}
