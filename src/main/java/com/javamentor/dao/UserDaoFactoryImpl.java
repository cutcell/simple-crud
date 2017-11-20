package com.javamentor.dao;

import com.javamentor.util.DBHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactoryImpl implements UserDaoFactory {

  @Override
  public UserDao getUserDao() {

    return getAccessType() == AccessType.JDBC
        ? new UserDaoJdbc(DBHelper.getInstance().getConnection())
        : new UserDaoHibernate(DBHelper.getInstance().getConfiguration());

  }

  private AccessType getAccessType() {

    Properties props = new Properties();
    try (InputStream is = UserDaoFactory.class.getResourceAsStream("/UserDaoFactory.properties")) {
      props.load(is);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return AccessType.valueOf(props.getProperty("accessType", "HIBERNATE"));

  }

}
