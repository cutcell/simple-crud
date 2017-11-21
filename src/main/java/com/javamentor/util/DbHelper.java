package com.javamentor.util;

import com.javamentor.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.hibernate.cfg.Configuration;

public class DbHelper {

  private static final String PROPS_PATH = "/cfg/db.properties";
  private static DbHelper instance;

  private Properties dbProps;
  private final Connection connection;
  private final Configuration configuration;

  private DbHelper() {
    dbProps = PropHelper.getDbProperties(DbHelper.class, PROPS_PATH);
    connection = getH2Connection();
    configuration = getHibernateConfiguration();
  }

  public static DbHelper getInstance() {

    if (instance == null) {
      synchronized (DbHelper.class) {
        if (instance == null) {
          instance = new DbHelper();
        }
      }
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
      String driverClass = dbProps.getProperty("jdbc.driverClass");
      String dbURL = dbProps.getProperty("jdbc.url");
      String user = dbProps.getProperty("jdbc.username");
      Class.forName(driverClass);
      connection = DriverManager.getConnection(dbURL, user, "");
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return connection;

  }

  private Configuration getHibernateConfiguration() {

    Configuration cfg = new Configuration();
    cfg.addAnnotatedClass(User.class);
    cfg.setProperties(dbProps);

    return cfg;

  }

}
