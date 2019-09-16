package com.laba1;

import com.laba1.Dao.UserDaoImpl;
import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.service.RatingService;
import com.laba1.service.UserService;


public class Main {
    public static void main(String arg[]){
//       UserDaoImpl  userDao = new UserDaoImpl();
//       userDao.findAll().forEach(System.out::println);

        User user = new User("don", "1234","000");
        UserService userService = new UserService();
        userService.saveUser(user);
        RatingService ratingService = new RatingService();
        Rating rating = new Rating(0,0,user);
        ratingService.saveRating(rating);
    }
}
