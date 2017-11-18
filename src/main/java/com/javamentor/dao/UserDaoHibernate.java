package com.javamentor.dao;

import java.util.List;
import com.javamentor.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.javamentor.util.HibernateHelper;

public class UserDaoHibernate implements UserDao {

  public UserDaoHibernate() {
  }

  @Override
  public List<User> getAllUsers() {

    Session session = HibernateHelper.getSessison();
    Query<User> query = session.createQuery("from User u");
    List<User> list = query.list();

    return list;
  }

  @Override
  public User getUserById(int id) {

    Session session = HibernateHelper.getSessison();
    Query<User> query = session.createQuery("from User u where u.id=:id");
    query.setParameter("id", id);
    User findUser = query.uniqueResult();
    session.close();
    return findUser;

  }

  @Override
  public void insertUser(User newUser) {

    Session session = HibernateHelper.getSessison();
    Transaction tx = session.beginTransaction();

    session.save(newUser);

    tx.commit();
    session.close();

  }

  @Override
  public void updateUser(int id, User newUser) {

    User updatedUser = getUserById(id);

    updatedUser.setName(newUser.getName());
    updatedUser.setPhone(newUser.getPhone());
    updatedUser.setEmail(newUser.getEmail());

    Session session = HibernateHelper.getSessison();
    Transaction tx = session.beginTransaction();
    session.update(updatedUser);
    tx.commit();
    session.close();

  }

  @Override
  public void deleteUserById(int id) {

    User deleteUser = getUserById(id);

    Session session = HibernateHelper.getSessison();
    Transaction tx = session.beginTransaction();
    session.delete(deleteUser);
    tx.commit();
    session.close();

  }

}
