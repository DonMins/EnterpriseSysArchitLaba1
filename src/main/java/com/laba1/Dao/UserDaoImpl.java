package com.laba1.Dao;

import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.config.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public User findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<User>query = session.createQuery("select m from com.laba1.Entity.User m " +
                "where m.login=:login")
                .setParameter("login" , login);
        List<User> result = query.list();
        session.close();
        return result.get(0);
    }


    @Override
    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
