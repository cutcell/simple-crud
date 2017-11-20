package com.javamentor.util;

import com.javamentor.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.cfg.Configuration;

public class DBHelper {

  private static DBHelper instance;

  private final Connection connection;
  private final Configuration configuration;

  private DBHelper() {
    connection = getH2Connection();
    configuration = getHibernateConfiguration();
  }

  public static DBHelper getInstance() {

    if (instance == null) {
      instance = new DBHelper();
    }

    return instance;

  }

  public Configuration getConfiguration() {
    return configuration;
  }

  public Connection getConnection() {
    return connection;
  }


  public void shutdown() {

    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  private Connection getH2Connection() {

    Connection connection = null;
    try {
      Class.forName("org.h2.Driver");
      connection = DriverManager.getConnection("jdbc:h2:~/h2", "sa", "");
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return connection;

  }

  private Configuration getHibernateConfiguration() {

    Configuration cfg = new Configuration();
    cfg.addAnnotatedClass(User.class);
    cfg.setProperty("hibernate.connection.url", "jdbc:h2:~/h2");
    cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
    cfg.setProperty("hibernate.connection.username", "sa");
    cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    cfg.setProperty("hibernate.show_sql", "true");
    cfg.setProperty("hibernate.format_sql", "true");

    return cfg;

  }

}
