package com.laba1.Dao;

import com.laba1.Dao.RatingDao;
import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.config.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.List;

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
    public Rating findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Rating> query = session.createQuery("select m from com.laba1.Entity.Rating m " +
                "where m.users.id =(select t.id from com.laba1.Entity.User t where t.login=:login)")
                .setParameter("login", login);
        List<Rating> results = query.list();
        return results.get(0);
    }

}
