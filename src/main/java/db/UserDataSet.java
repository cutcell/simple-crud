package db;

public class UserDataSet {

  private int id;
  private String name;
  private String phone;
  private String email;

  public UserDataSet(int id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public UserDataSet(String name, String phone, String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public int getId() {
    return id;
  }

}
