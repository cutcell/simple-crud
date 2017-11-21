package com.javamentor.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropHelper {

  public static <T> Properties getDbProperties(Class<T> clazz, String propertiesPath) {

    Properties defaultProps = getDefaultDbProperties();

    URL propsURL = clazz.getResource(propertiesPath);
    if (propsURL == null) {
      storeProperties(propsURL.getFile(), defaultProps);
      return defaultProps;
    }

    Properties properties = new Properties();

    try (BufferedReader br = new BufferedReader(new FileReader(propsURL.getFile()))) {
      properties.load(br);
    } catch (IOException e) {
      e.printStackTrace();
      return defaultProps;
    }

    if (properties.size() == 0) {
      storeProperties(propsURL.getFile(), defaultProps);
      return defaultProps;
    }

    return properties;

  }

  private static Properties getDefaultDbProperties() {

    Properties props = new Properties();

    props.setProperty("jdbc.url", "jdbc:h2:~/h2");
    props.setProperty("jdbc.driverClass", "org.h2.Driver");
    props.setProperty("jdbc.username", "sa");
    props.setProperty("jdbc.password", "");

    props.setProperty("hibernate.connection.url", "jdbc:h2:~/h2");
    props.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
    props.setProperty("hibernate.connection.username", "sa");
    props.setProperty("hibernate.connection.password", "");
    props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    props.setProperty("hibernate.show_sql", "true");
    props.setProperty("hibernate.format_sql", "true");

    return props;

  }

  private static void storeProperties(String path, Properties props) {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
      props.store(bw, "");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
