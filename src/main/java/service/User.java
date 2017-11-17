package service;

import db.UserDataSet;
import java.io.Serializable;

public class User implements Serializable {

  private int id;
  private String name;
  private String phone;
  private String email;

  public User(String name, String phone, String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public User() {

    this("", "", "");

  }

  public User(UserDataSet userDataSet) {
    this.id = userDataSet.getId();
    this.name = userDataSet.getName();
    this.phone = userDataSet.getPhone();
    this.email = userDataSet.getEmail();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
