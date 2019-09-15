package com.laba1.Dao;

import com.laba1.Entity.Rating;
import com.laba1.config.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

/**
 * Класс реализующий интерфейс для работы с таблицей Rating
 * @author Maks
 * @version 1.1
 */


public class RatingDaoImpl implements RatingDao {
    @Override
    public Rating findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Rating.class, id);

    }
    @Override
    public void save(Rating rating) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rating);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Rating rating) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(rating);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Rating rating) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rating);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Rating findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Rating> query = session.createQuery("select m from com.laba1.Entity.Rating m " +
                "where m.users.id =(select t.id from com.laba1.Entity.User t where t.login=:login)")
                .setParameter("login", login);
        List<Rating> results = query.list();
        session.close();
        return results.get(0);
    }

    @Override
    public List<Rating> findAll() {
        List<Rating> ratingList = (List<Rating>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From  com.laba1.Entity.Rating")
                .list();
        return ratingList;
    }

}
