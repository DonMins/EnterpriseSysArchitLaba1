package com.laba1.Service;


import com.laba1.Entity.User;

import java.util.List;

public interface UserService {
    User findById(int id) ;
    User findByLogin(String login) ;
    void save(User user);
    void delete(User user);
    void update(User user);
    List<User> findAll();
}
