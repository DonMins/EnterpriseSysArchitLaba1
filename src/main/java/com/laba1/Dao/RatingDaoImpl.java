package com.laba1.Dao;

import com.laba1.Dao.RatingDao;
import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.config.HibernateSessionFactoryUtil;
import org.hibernate.Session;

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
}
