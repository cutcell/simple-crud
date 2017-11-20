package com.javamentor.dao;

import com.javamentor.util.DBHelper;
import java.io.InputStreamReader;
import java.util.Properties;

public class UserDaoFactoryImpl implements UserDaoFactory {

  private static final String PROPS_PATH = "/cfg/UserDaoFactory.properties";

  @Override
  public UserDao getUserDao() {

    return getAccessType() == AccessType.JDBC
        ? new UserDaoJdbc(DBHelper.getInstance().getConnection())
        : new UserDaoHibernate(DBHelper.getInstance().getConfiguration());

  }

  private AccessType getAccessType() {

    Properties props = new Properties();

    try (InputStreamReader is = new InputStreamReader(
        UserDaoFactory.class.getResourceAsStream(PROPS_PATH))) {
      props.load(is);
    } catch (Exception e) {
      e.printStackTrace();
      return AccessType.HIBERNATE;
    }

    return AccessType.valueOf(props.getProperty("accessType", "HIBERNATE"));

  }

}
