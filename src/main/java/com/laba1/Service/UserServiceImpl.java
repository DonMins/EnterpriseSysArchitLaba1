package com.laba1.Service;


import com.laba1.Dao.UserDao;
import com.laba1.Entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "UserServiceImpl")
public class UserServiceImpl implements UserService {

    @EJB(beanName = "UserDaoImpl")
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
