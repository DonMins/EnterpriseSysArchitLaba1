package com.laba1;

import com.laba1.Dao.UserDaoImpl;
import com.laba1.Entity.User;


public class Main {
    public static void main(String arg[]){
       UserDaoImpl  userDao = new UserDaoImpl();
       userDao.findAll().forEach(System.out::println);

       User user = new User("do2n", "1234","000");
//        UserService userService = new UserService();
       userDao.save(user);
//        RatingService ratingService = new RatingService();
//        Rating rating = new Rating(0,0,user);
//        ratingService.saveRating(rating);
    }
}
