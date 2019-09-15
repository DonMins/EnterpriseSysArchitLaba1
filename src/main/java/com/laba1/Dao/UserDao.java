package com.laba1.Dao;

import com.laba1.Entity.User;

import java.util.List;
/**
 * DAO интерфейс для работы с таблицей Users
 * @author Maks
 * @version 1.1
 */

public interface UserDao {
    User findById(int id) ;
    User findByLogin(String login);
    void save(User user);
    void delete(User user);
    void update(User user);
    List<User> findAll();
}
