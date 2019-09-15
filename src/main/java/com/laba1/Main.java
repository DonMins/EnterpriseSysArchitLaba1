package com.laba1;

import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.service.RatingService;
import com.laba1.service.UserService;

public class Main {
    public static void main(String arg[]){
        RatingService userService = new RatingService();
        System.out.println(userService.findByLogin("don").getCountgame());
//        User user = new User("don", "1234","000");
//        userService.saveUser(user);
//        RatingService ratingService = new RatingService();
//        Rating rating = new Rating(0,0,user);
//        ratingService.saveRating(rating);
    }
}
