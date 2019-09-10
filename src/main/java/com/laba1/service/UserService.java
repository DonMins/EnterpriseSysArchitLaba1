package com.laba1.service;

import com.laba1.Dao.UserDao;
import com.laba1.Entity.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public UserService(){}

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

}
