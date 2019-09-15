package com.laba1.Dao;

import com.laba1.Entity.User;
import com.laba1.config.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface UserDao {
    User findById(int id) ;
    User findByLogin(String login);
    void save(User user);
}
