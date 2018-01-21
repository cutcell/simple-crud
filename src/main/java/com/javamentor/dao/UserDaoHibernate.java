package com.javamentor.dao;

import com.javamentor.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class UserDaoHibernate implements UserDao {

    private Configuration cfg;
    private SessionFactory sessionFactory;

    public UserDaoHibernate() {
    }

    public UserDaoHibernate(Configuration cfg) {
        this.cfg = cfg;
        this.sessionFactory = getSessionFactory();
    }

    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery("from Users u").list();
        session.close();
        return list;

    }

    @Override
    public User getUserById(int id) {

        Session session = sessionFactory.openSession();
        User findUser = session.find(User.class, id);
        session.close();
        return findUser;

    }

    @Override
    public void insertUser(User newUser) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(newUser);

        tx.commit();
        session.close();

    }

    @Override
    public void updateUser(int id, User newUser) {

        User foundUser = getUserById(id);

        foundUser.setLogin(newUser.getLogin());
        foundUser.setPassword(newUser.getPassword());
        foundUser.setRole(newUser.getRole());
        foundUser.setName(newUser.getName());
        foundUser.setPhone(newUser.getPhone());
        foundUser.setEmail(newUser.getEmail());

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(foundUser);
        tx.commit();
        session.close();

    }

    @Override
    public void deleteUserById(int id) {

        User deleteUser = getUserById(id);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(deleteUser);
        tx.commit();
        session.close();

    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public User getUserByLogin(String login) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Users u where u.login=:login");
        query.setParameter("login", login);

        List resultList = query.getResultList();

        session.close();

        if (resultList.isEmpty()) {
            return null;
        }

        User foundUser = (User) resultList.get(0);

        return foundUser;

    }

    private SessionFactory getSessionFactory() {

        StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
        srBuilder.applySettings(cfg.getProperties());
        ServiceRegistry sr = srBuilder.build();

        return cfg.buildSessionFactory(sr);

    }

}
