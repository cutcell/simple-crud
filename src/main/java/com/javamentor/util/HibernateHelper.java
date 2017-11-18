package com.javamentor.util;

import com.javamentor.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateHelper {

  private static final SessionFactory FACTORY = buidFactory();

  public HibernateHelper() {
  }

  public static Session getSessison() {
    return FACTORY.openSession();
  }

  private static SessionFactory buidFactory() {

    Configuration cfg = buidCfg();
    StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
    srBuilder.applySettings(cfg.getProperties());
    ServiceRegistry sr = srBuilder.build();

    return cfg.buildSessionFactory(sr);

  }

  private static Configuration buidCfg() {

    Configuration cfg = new Configuration();
    cfg.addAnnotatedClass(User.class);
    cfg.setProperty("hibernate.connection.url", "jdbc:h2:~/h2");
    cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
    cfg.setProperty("hibernate.connection.username", "sa");
    cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    cfg.setProperty("hibernate.show_sql", "true");
    cfg.setProperty("hibernate.format_sql", "true");
    cfg.setProperty("hibernate.hbm2ddl.auto", "update");

    return cfg;

  }



}
